package com.dmcq.order.util;

import java.util.Random;

/**
 * @Title KeyUtil
 * @Description TODO
 * @Author qinhao
 * @Date 2019/7/4 10:29
 **/
public class KeyUtil {

    /*
     * @Title createKey
     * @Description 生成唯一主键
     * 规则：时间戳+随机数
     * @Author qinhao
     * @Date 2019/7/4 13:13
     */
    public static synchronized String createKey(){
        //生成六位随机数
        int random = new Random().nextInt(900000)+100000;
        //获取当前时间戳，并拼接字符串
        return System.currentTimeMillis()+""+random;
    }
}
