/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 標準クラス;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author guest1Day
 */

//2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
public class Date1 {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2016,0,1,0,0,0);
        
        System.out.print(c.getTime());
    }
}
