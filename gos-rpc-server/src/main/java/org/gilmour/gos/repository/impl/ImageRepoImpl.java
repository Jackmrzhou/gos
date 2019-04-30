package org.gilmour.gos.repository.impl;

import com.google.protobuf.ByteString;
import org.apache.commons.lang3.SerializationUtils;
import org.gilmour.gos.common.DataServer;
import org.gilmour.gos.common.impl.ZooKeeperResolver;
import org.gilmour.gos.conf.SSDBConf;
import org.gilmour.gos.models.DefaultGImageImpl;
import org.gilmour.gos.models.GImage;
import org.gilmour.gos.pb.FileTransProto;
import org.gilmour.gos.repository.ImageRepo;
import org.nutz.ssdb4j.SSDBs;
import org.nutz.ssdb4j.spi.Response;
import org.nutz.ssdb4j.spi.SSDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

@Repository
public class ImageRepoImpl implements ImageRepo {

    @Autowired
    private ZooKeeperResolver zooKeeperResolver;
    @Autowired
    private SSDBConf ssdbConf;

    @Override
    public GImage Get(String key) throws Exception {
        SSDB ssdb = SSDBs.simple(ssdbConf.getHost(), ssdbConf.getPort(), ssdbConf.getTimeout());
        Response response = ssdb.get(key);
        if (!response.ok()){
            throw new Exception("required object not found");
        }

        DataServer dataServer = SerializationUtils.deserialize(response.datas.get(0));
        ssdb.close();

        if (!zooKeeperResolver.CheckDataServer(dataServer)){
            throw new Exception("data server unavailable");
        }

        FileTransProto.FileRequest fileRequest = FileTransProto.FileRequest.newBuilder()
                .setOperation(FileTransProto.FileRequest.FileOperation.GET)
                .setFileID(key)
                .build();

        Socket client = new Socket(dataServer.getHost(), dataServer.getPort());
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        fileRequest.writeDelimitedTo(out);

        FileTransProto.FileResponse fileResponse = FileTransProto.FileResponse.parseDelimitedFrom(in);

        if (fileResponse.getStatus() != FileTransProto.FileResponse.Status.OK){
            throw new Exception("remote data server error, msg:" + fileResponse.getMsg());
        }

        client.close();

        return new DefaultGImageImpl(fileResponse.getFile().getFileData().toByteArray());
    }

    @Override
    public String Put(GImage image) throws Exception {
        DataServer dataServer = zooKeeperResolver.GetDataServer();
        String key = UUID.randomUUID().toString();

        FileTransProto.CommonFile file = FileTransProto.CommonFile.newBuilder()
                .setFileID(key)
                .setFileSize(image.Size())
                .setFileData(ByteString.copyFrom(image.ToByteArray()))
                .build();

        FileTransProto.FileRequest fileRequest = FileTransProto.FileRequest.newBuilder()
                .setOperation(FileTransProto.FileRequest.FileOperation.PUT)
                .setFileID(key)
                .setFile(file)
                .build();

        Socket client = new Socket(dataServer.getHost(), dataServer.getPort());
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        fileRequest.writeDelimitedTo(out);

        FileTransProto.FileResponse fileResponse = FileTransProto.FileResponse.parseDelimitedFrom(in);

        if (fileResponse.getStatus() != FileTransProto.FileResponse.Status.OK){
            throw new Exception("remote data server error, msg:" + fileResponse.getMsg());
        }

        client.close();

        SSDB ssdb = SSDBs.simple(ssdbConf.getHost(), ssdbConf.getPort(), ssdbConf.getTimeout());
        ssdb.set(key, SerializationUtils.serialize(dataServer)).check();
        ssdb.close();

        return key;
    }
}
