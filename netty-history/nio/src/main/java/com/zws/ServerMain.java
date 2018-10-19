package com.zws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by 28483 on 2018/8/5.
 */
public class ServerMain {

    public static void main(String[] args) {

    }

    public void testConnect() throws Exception{
        Socket socket=new Socket("192.168.82.35",4700);//BIO 阻塞
        System.out.println("连接成功");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //下面这种写法，不用关闭客户端，服务器端也是可以收到的
        {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("hi");
            printWriter.flush();
        }
        //这种写法必须关闭客户端，服务器端才可以收到 NIO不用
        {
//        socket.getOutputStream().write(new byte[]{'h','i'});
//        socket.getOutputStream().flush();
            //必须关闭BIO服务器才能收到消息.NIO服务器不需要关闭
            //socket.close();
        }
        byte[] buf = new byte[2048];
        System.out.println("准备读取数据~~");

        while(true){
            try {
                //两种读取数据方式
                int count = socket.getInputStream().read(buf);        //会阻塞
                //String readFromServer = bufferedReader.readLine();//可以读取到数据 会阻塞,直到遇见\n
                //System.out.println("方式二： 读取数据" + readFromServer);
                System.out.println("方式一： 读取数据" + new String(buf) + " count = " + count);
                Thread.sleep(1*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //break;
        }

    }


    public void testNioServer(){
        Thread server = new Thread(new Server());
        server.start();

        while(true){
            try {
                Thread.sleep(3*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }



}
