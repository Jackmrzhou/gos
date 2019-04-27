package org.gilmour.gos.DataServer.server;


import com.google.protobuf.ByteString;
import org.apache.commons.io.IOUtils;
import org.gilmour.gos.DataServer.service.FileService;
import org.gilmour.gos.pb.FileTransProto;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class Handler implements Runnable {

    private Socket socket;
    private FileService fileService;

    Handler(Socket socket, FileService fileService){
        this.socket = socket;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        FileTransProto.FileResponse.Builder fileResponseBuilder = FileTransProto.FileResponse.newBuilder();
        try{
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            FileTransProto.FileRequest fileRequest = FileTransProto.FileRequest.parseDelimitedFrom(in);

            if (fileRequest.getOperation().equals(FileTransProto.FileRequest.FileOperation.GET)){
                // double copy here.
                // todo:need optimization
                byte[] fileData = IOUtils.toByteArray(fileService.GetFile(fileRequest.getFileID()));
                FileTransProto.CommonFile file = FileTransProto.CommonFile.newBuilder()
                        .setFileID(fileRequest.getFileID())
                        .setFileData(ByteString.copyFrom(fileData))
                        .setFileSize(fileData.length)
                        .build();

                fileResponseBuilder.setFile(file).setStatus(FileTransProto.FileResponse.Status.OK);
            }else if (fileRequest.getOperation().equals(FileTransProto.FileRequest.FileOperation.PUT)){
                boolean res = fileService.PutFile(fileRequest.getFileID(), fileRequest.getFile().getFileData().newInput());
                if (res){
                    fileResponseBuilder.setStatus(FileTransProto.FileResponse.Status.OK).build();
                }else{
                    fileResponseBuilder.setStatus(FileTransProto.FileResponse.Status.Err).setMsg("Data Server Error");
                }
            }

            FileTransProto.FileResponse fileResponse = fileResponseBuilder.build();
            fileResponse.writeDelimitedTo(out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
