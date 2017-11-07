/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 標準クラス;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */

//2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。

public class Date4 {
    public static void main(String[] args)throws ParseException {
        // SimpleDateFormatクラスの作成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ↑の文字列を日付に変換
        Date d = sdf.parse("2015-01-01 00:00:00");
        Date d2 = sdf.parse("2015-12-31 23:59:59");
        // タイムスタンプを取得し、差（ミリ秒）を計算
        // タイムスタンプの中身はlongなので数字としても扱える
        
        System.out.print("差は" + (d2.getTime() - d.getTime()) +"です");
        
    }
}
