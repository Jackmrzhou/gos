package org.gilmour.gos.DataServer.service.impl;

import org.apache.commons.io.IOUtils;
import org.gilmour.gos.DataServer.conf.DataServerConf;
import org.gilmour.gos.DataServer.conf.StorageConf;
import org.gilmour.gos.DataServer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private StorageConf storageConf;

    @Override
    public boolean PutFile(String key, InputStream inputStream) throws IOException{
        Path FilePath = Paths.get(storageConf.getBasePath(), key);
        FileOutputStream out = new FileOutputStream(FilePath.toFile());
        IOUtils.copy(inputStream, out);
        out.close();
        return true;
    }

    @Override
    public InputStream GetFile(String key) throws IOException {
        Path FilePath = Paths.get(storageConf.getBasePath(), key);
        File file = new File(FilePath.toUri());
        return new FileInputStream(file);
    }
}
