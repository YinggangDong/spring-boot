package com.example.demo.wechatnotify;

import cn.hutool.http.HttpRequest;

/**
 * WeChatNotify 类是 测试微信推送消息
 * 1.测试号申请：https://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index
 * 2.接口文档：https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Overview.html
 * 3.accessToken获取:https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html
 * 应用方案Demo文章：https://mp.weixin.qq.com/s/9OcFHoYwjGzkSvEyrM2bGA
 *
 * @author dongyinggang
 * @date 2022-06-20 08:57
 **/
public class WeChatNotify {

    public static void main(String[] args) {
        //1.请求字符串,
        String requestStr = "{\n" +
                "           \"touser\":\"接收人的openId\",\n" +
                "           \"template_id\":\"模板id\",\n" +
                "           \"url\":\"查看详情时跳转的URL\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"恭喜你购买成功！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"巧克力\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"39.8元\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"2014年9月22日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"欢迎再次购买！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        //accessToken 2H过期
        String accessToken = "58_LDEhMPPiJ0FvG57QYtEKSIFbLR8Yw3tI6eu_6wTujV04BkdfbMJ4W" +
                "irdelH71j_WI7UqwIg-0dNxC1WPXpj1TzsP_QJLV7R5dw3BdtkAxzmgn0tsViKpE1lezZyEx" +
                "lkl5g83Ct1qrD0Xuf7_WDBaAAARYW";
        String res = HttpRequest.post("https://api.weixin.qq.com/cgi-bin/message/template/send?" +
                        "access_token=" + accessToken)
                .body(requestStr)
                .execute().body();
        System.out.println(res);
    }
}
