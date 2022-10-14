package com.xuge.Utils;

/**
 * author: yjx
 * Date :2022/10/1411:57
 **/
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
  /**
   * 接收int类型数据
   * @param is 输入流
   * @return 输入流的前四位，整合为一个int数据
   */
  public static int readInt(InputStream is) {
    int[] values = new int[4];
    try {
      for (int i = 0; i < 4; i++) {
        values[i] = is.read();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    int value = values[0]<<24 | values[1]<<16 | values[2]<<8 | values[3]<<0;
    return value;
  }

  /**
   * 输出一个int类型的数据
   * @param os 输出流
   * @param value 要发送的int数据
   */
  public static void writeInt(OutputStream os,int value) {
    int[] values = new int[4];
    values[0] = (value>>24)&0xFF;
    values[1] = (value>>16)&0xFF;
    values[2] = (value>>8)&0xFF;
    values[3] = (value>>0)&0xFF;

    try{
      for (int i = 0; i < 4; i++) {
        os.write(values[i]);
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  /**
   * 获取string输入
   * @param is 输入流
   * @return 输入的string
   */
  public static String readString(InputStream is) {
    int len = readInt(is);
    byte[] sByte = new byte[len];
    try {
      is.read(sByte);
    } catch (IOException e) {
      e.printStackTrace();
    }
    String s = new String(sByte);
    return s;
  }

  /**
   * 发送string
   * @param os 输出流
   * @param s 要发送的字符串
   */
  public static void writeString(OutputStream os,String s) {
    byte[] bytes = s.getBytes();
    int len = bytes.length;
    writeInt(os,len);

    try {
      os.write(bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
