package com.ys.inventory.common.utils;

import com.google.common.io.ByteStreams;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author wyh
 * @version 2018/1/3.
 */
public class DownloadUtil {
    /**
     * 文件下载
     * @param file 文件
     * @param specName 文件名
     * @return
     * @throws IOException
     */
    public static ResponseEntity<byte[]> download(File file, String specName) throws IOException {
        return download(FileUtil.toByteArray(file),specName);
    }

    /**
     * 输入流直接下载
     * @param in 输入流
     * @param specName 文件名
     * @return
     * @throws IOException
     */
    public static ResponseEntity<byte[]> download(InputStream in, String specName) throws IOException {
        return download(ByteStreams.toByteArray(in),specName);
    }

    /**
     * 文件下载
     * @param bytes 字节数组
     * @param specName 文件名
     * @return
     * @throws IOException
     */
    public static ResponseEntity<byte[]> download(byte[] bytes, String specName) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode(specName,"UTF-8"));
        headers.setContentLength(bytes.length);
        return ResponseEntity.ok().headers(headers).body(bytes);
    }

    /**
     * 读取文件
     * @param bytes 字节数组
     * @param mediaType 内容类型
     * @return
     * @throws IOException
     */
    public static ResponseEntity<byte[]> read(byte[] bytes, MediaType mediaType) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        headers.setContentLength(bytes.length);
        return ResponseEntity.ok().headers(headers).body(bytes);
    }

}
