package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author qianyongchao
 * @Description
 * @Date 2018/10/29
 * @Modified By
 */
public class DateUtil {

    public static String getCurrentTime() {

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return sdf.format(new Date());
    }


}
