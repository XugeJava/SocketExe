package com.xuge.client;

/**
 * author: yjx
 * Date :2022/10/1412:09
 **/


import com.xuge.Utils.ScreenUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.Socket;

/**
 * @program: com.io.socket.client
 * @description: 客户端工作线程
 * @author: liujinghui
 * @create: 2019-02-16 12:06
 **/
public class SocketClientWorker implements Runnable{

  //通信socket
  private Socket clientSocket;
  //客户端名称
  private String clientName;
  //发送消息间隔
  private long sleepTime;
  //发送的消息内容
  private String message;

  public SocketClientWorker(String host,int port,String clientName,long sleepTime,String message){
    try{
      clientSocket= new Socket(host, port);
      this.clientSocket = clientSocket;
      this.clientName = clientName;
      this.sleepTime = sleepTime;
      this.message =  message;
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  public void use() throws AWTException {
    // 获取屏幕的尺寸(屏幕宽高)

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    System.out.println("屏幕的宽和高是：" + screenSize.getWidth() + " x " + screenSize.getHeight());

// 使用工具类截取屏幕

//利用获取到的屏幕宽高捕捉当前的屏幕内容

    BufferedImage image = new Robot().createScreenCapture(new Rectangle(screenSize));
  }

  @Override
  public void run() {
    {
      while (true) {
        try {
          clientSocket.getOutputStream().write(message.getBytes());
          ScreenUtils.use();
          System.out.println(clientName + "客户端向服务器发送图像: " + message);
          Thread.sleep(sleepTime);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}