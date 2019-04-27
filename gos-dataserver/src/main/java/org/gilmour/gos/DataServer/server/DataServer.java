package org.gilmour.gos.DataServer.server;

import org.gilmour.gos.DataServer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class DataServer{

    private final int port = 9001;
    @Autowired
    private FileService fileService;

    public DataServer(FileService fileService){
        this.fileService = fileService;
    }


    public void run() throws Exception{
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        System.out.println("start listening...");
        while (true){
            Socket socket = serverSocket.accept();
            threadPool.submit(new Handler(socket, fileService));
        }
    }
}
