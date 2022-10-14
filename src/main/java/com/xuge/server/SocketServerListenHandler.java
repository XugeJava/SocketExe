package com.xuge.server;

/**
 * author: yjx
 * Date :2022/10/1412:08
 **/


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: com.io.socket.server
 * @description: 服务端监听类
 * 监听客户端的请求
 * @author: liujinghui
 * @create: 2019-02-16 10:39
 **/
public class SocketServerListenHandler {

  //A server socket waits for requests to come in over the network.
  //这是一个不断等待获取网络传入请求的服务端Socket
  private ServerSocket serverSocket;

  /**
   * 构造方法
   * @param port 端口
   */
  public SocketServerListenHandler(int port){
    try{
      serverSocket = new ServerSocket(port);
      this.serverSocket = serverSocket;
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  /**
   * 无限循环的监听客户端的连接
   * Listens for a connection to be made to this socket and accepts it.
   * 当有一个连接产生，将结束accept()方法的阻塞
   * The method blocks until a connection is made.
   */
  public void listenClientConnect(){
    while(true){
      try {
        System.out.println("服务端监听开始。。。");
        Socket clientConnectSocket = serverSocket.accept();
        System.out.println("监听到客户端连接。。。创建处理客户端连接的handler工具。。");
        new SocketServerClientHandler(clientConnectSocket).start();
      } catch (Exception e) {
        System.out.println("服务端监听连接程序异常");
      }
    }
  }
}