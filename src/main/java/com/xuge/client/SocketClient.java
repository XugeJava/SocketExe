package com.xuge.client;

/**
 * author: yjx
 * Date :2022/10/1412:09
 **/


import java.io.IOException;
import java.net.Socket;

/**
 * @program: com.io.socket.client
 * @description: 客户端测试启动类
 * @author: liujinghui
 * @create: 2019-02-16 10:39
 **/
public class SocketClient {

  public static void main(String[] args) throws IOException {
    //服务端IP和端口 创建客户端服务端socket
    new Thread(new SocketClientWorker("127.0.0.1", 6666,"ClientA",5000,"A发送消息。。")).start();
    new Thread(new SocketClientWorker("127.0.0.1", 6666,"ClientB",4000,"B发送消息。。")).start();
    new Thread(new SocketClientWorker("127.0.0.1", 6666,"ClientC",3000,"C发送消息。。")).start();
  }
}