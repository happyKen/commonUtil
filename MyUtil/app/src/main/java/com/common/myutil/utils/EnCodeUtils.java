package com.common.myutil.utils;

import android.util.Base64;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 编码类
 * Created by wangzekeng on 2017/8/27.
 */

public class EnCodeUtils {
    /**
     * MD5加密
     *
     * @param plainText 需要加密的字符串
     * @return 加密后字符串
     */
    public static String md5(String plainText) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(plainText.getBytes());
            return byteToHex(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件的md5值
     *
     * @param fileName 文件名
     * @return 文件的md5值
     */
    public static String md5File(String fileName) {
        InputStream fis;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;
        try {
            fis = new FileInputStream(fileName);
            md5 = MessageDigest.getInstance("MD5");
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }
            fis.close();
            return byteToHex(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64解密
     *
     * @param s
     * @return
     */
    public static String decodeBase64(String s) {
        return new String(Base64.decode(s, Base64.DEFAULT)).replace("\r", "");
    }

    /**
     * base64加密
     *
     * @param s
     * @return
     */
    public static String encodeBase64(String s) {
        return new String(Base64.encode(s.getBytes(), Base64.DEFAULT));
    }

    /**
     * 字节转hex
     *
     * @param b
     * @return
     */
    public static String byteToHex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString();
    }

    /**
     * hex转字节
     *
     * @param hexStr
     * @return
     */
    public static byte[] hexToBte(String hexStr) {
        byte[] b = hexStr.getBytes();
        if ((b.length % 2) != 0)
            throw new IllegalArgumentException();
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        return b2;
    }
}
