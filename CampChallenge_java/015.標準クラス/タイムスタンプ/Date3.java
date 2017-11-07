/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 標準クラス;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 *
 * @author guest1Day
 */
//2016年11月4日 10時0分0秒のタイムスタンプを作成し、「年-月-日 時:分:秒」で表示してください
public class Date3 {

    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        c.set(2016, 10, 4, 10, 0, 0);
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        int minute = c.get(Calendar.MINUTE);
//        int second = c.get(Calendar.SECOND);
//        
//        System.out.println(year +" "+month);
        Date d = new Date(2016,10,4,10,0,0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        System.out.println(sdf.format(d));
    }

}
