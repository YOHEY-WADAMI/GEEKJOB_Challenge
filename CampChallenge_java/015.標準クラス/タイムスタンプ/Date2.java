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

//現在の日時を「年-月-日 時:分:秒」で表示してください。
public class Date2 {
    public static void main(String[] args){
        Date d = new Date();
                
        //どういう書式で出力するか設定する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //今日の日付をformat()で処理して出力
        System.out.println(sdf.format(d));
    }
    
}
