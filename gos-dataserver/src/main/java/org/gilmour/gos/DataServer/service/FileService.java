package org.gilmour.gos.DataServer.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileService {
    boolean PutFile(String key, InputStream inputStream) throws IOException;
    InputStream GetFile(String key) throws IOException;
}
