package com.test.javaIO.BIO;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BIOClient {

    public static void main(String[] args) throws Exception{

        Socket client = new Socket();
        client.connect(new InetSocketAddress("127.0.0.1",9090));

        System.out.println("client start..");

        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);

        out.writeUTF("Hello from " + client.getLocalSocketAddress());

        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);

        System.out.println("服务器响应： " + in.readUTF());

        client.close();




    }



}
