package com.test.javaIO.BIO;

import java.net.ServerSocket;
import java.net.Socket;

public class BIO {

    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket();
        Socket accept = server.accept();
    }

}
