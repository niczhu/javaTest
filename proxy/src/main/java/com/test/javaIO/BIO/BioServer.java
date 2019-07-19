package com.test.javaIO.BIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class BioServer extends Thread{


    private ServerSocket serverSocket;

    public BioServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(4000);
    }

    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");

                Socket server = serverSocket.accept();

                System.out.println("远程主机地址：" + server.getRemoteSocketAddress());

                InputStream inputStream = server.getInputStream();
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                System.out.println(bufferedReader.toString());
//                String a;
//                while ((a=bufferedReader.readLine())!=null){
//                    System.out.println(a);
//                }


                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println("客户端发送内容：" + in.readUTF());

                DataOutputStream out = new DataOutputStream(server.getOutputStream());

                out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();

            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }


    public static void main(String [] args)
    {
        int port = 9090;
        try
        {
            Thread t = new BioServer(port);
            t.run();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
