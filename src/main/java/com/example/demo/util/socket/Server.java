package com.example.demo.util.socket;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Server 类是
 *
 * @author dongyinggang
 * @date 2022-02-08 21:41
 **/
public class Server {

    public static void main(String[] args) throws IOException {

        /**
         * 实现UDP协议通信的服务端
         */
        System.out.println("==========这是服务端=============");
        //创建DatagramSocket对象，用来监听7777端口，若有数据来传输，则接受
        DatagramSocket socket = new DatagramSocket(7777);

        //创建字节数组
        byte[] by = new byte[512];
        //创建DatagramPacket对象,用来接收数据，以字节数组形式接收
        DatagramPacket packet = new DatagramPacket(by, by.length);

        //接收客户端发送过来的数据
        socket.receive(packet);

        //获得用户发送的数据
        byte[] data = packet.getData();
        //获得客户端发送过来数据的长度以及端口
        int length = packet.getLength();
        int port = packet.getPort();
        String depJson = new String(data, 0, length);
        Dep dep = JSON.parseObject(depJson, Dep.class);
        System.out.println(JSON.toJSONString(dep));
        socket.close();
    }
}
