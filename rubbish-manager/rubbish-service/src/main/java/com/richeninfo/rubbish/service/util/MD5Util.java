package com.richeninfo.rubbish.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密算法：<br>
 * 功能：MD5加密算法封装
 * Created by xuliangjun on 15/10/28.
 */
public final class MD5Util {

    private static final Logger logger = LoggerFactory.getLogger(MD5Util.class);

    private static final char[] HEX = {
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };

    private static String toHexString(byte[] bytes){
        int length = bytes.length;
        StringBuilder sb = new StringBuilder(length*2);
        int x = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < length; i++) {
            if (0 <= bytes[i])
                x = bytes[i];
            else
                x = 256 + bytes[i];
            n1 = x >> 4;
            n2 = x & 0x0f;
            sb.append(HEX[n1]).append(HEX[n2]);
        }
        return sb.toString();
    }

    public static String toMD5(String s){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buf;
            try {
                buf = md.digest(s.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                buf = md.digest(s.getBytes());
            }
            return toHexString(buf).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            if(null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return value;
    }



    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }


    public static String getMd5ByInputStream(InputStream inputStream) {
        try {
            byte[] uploadBytes = toByteArray(inputStream);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            String hashString = new BigInteger(1, digest).toString(16);
            return hashString.toUpperCase();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }catch (NoSuchAlgorithmException e){
            logger.error(e.getMessage());
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(MD5Util.toMD5("123456"));
    }
}
