package com.xuge.bak;

/**
 * author: yjx
 * Date :2022/10/1411:55
 **/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
  private ServerSocket serverSocket = null;
  private HashMap<String, ServerThread> threads = new HashMap<>();
  public void run() throws IOException {
    serverSocket = new ServerSocket(8888);
    System.out.println("服务端启动");
    while (true){
      System.out.println("正在监听");
      Socket accept = serverSocket.accept();
      String address = accept.getInetAddress()+":"+accept.getPort();
      System.out.println("连接成功");
      ServerThread serverThread = new ServerThread(accept,threads);

      threads.put(address,serverThread);

      serverThread.start();

    }
  }

  public static void main(String[] args) throws IOException {
    new Server().run();
  }
}
