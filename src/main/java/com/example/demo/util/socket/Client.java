package com.example.demo.util.socket;

import com.alibaba.fastjson.JSON;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Client 类是
 *
 * @author dongyinggang
 * @date 2022-02-08 21:42
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        /**
         * 实现UDP协议通信的客户端
         */
        System.out.println("==========这是客户端=============");

        String content = "初次学习Socket网络编程！";
        Dep dep = new Dep();
        dep.setName(content);
        String depJson = JSON.toJSONString(dep);
        byte[] bytes = depJson.getBytes();

        //声明byte数组，为最原始的接收ip地址
        byte[] addr = {127, 0, 0, 1};
        //创建InetAddress对象，封装需要传输到的主机
        InetAddress address = InetAddress.getByAddress(addr);

        //创建DatagramPacket对象，封装数据以及需要传输到的地址和端口
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, 7777);

        //创建DatagramSocket对象，用来将数据进行打包服务，指定快递员的端口为8888
        DatagramSocket socket = new DatagramSocket(8888);

        //实现数据传输
        socket.send(packet);

        socket.close();
    }
}
