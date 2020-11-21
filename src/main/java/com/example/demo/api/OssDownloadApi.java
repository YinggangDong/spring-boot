package com.example.demo.api;

import javax.servlet.http.HttpServletResponse;

/**
 * OssDownloadApi 接口是
 *
 * @author dongyinggang
 * @date 2020-11-11 19:50
 **/
public interface OssDownloadApi {

    void downloadSource(HttpServletResponse response);
}
