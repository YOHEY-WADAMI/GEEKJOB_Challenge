/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ファイル操作;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class fileSakusei {

    public static void main(String[] args) throws IOException {
        // 開始時間を取得
        
        LocalDateTime d = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(dtf.format(d));
        
        // ↓C:\Users\guest1Day\Documents\NetBeansProjects\servlet\test2.txtと書いてもいい。
        File fp = new File("C:\\Users\\guest1Day\\Documents\\NetBeansProjects\\servlet\\test2.txt");
        FileWriter fw = new FileWriter(fp,false);

        // ()の内容（開始時間＋開始）をファイルパスの中に書き込み
        fw.write(dtf.format(d) + "　開始\n");  // \nで改行

        System.out.println("現時刻に対して適切な返事を返します。");
        int hour = d.getHour();
//        int minute = d.getMinute();
//        int second = d.getSecond();

        //System.out.println(hour + "時" + minute + "分" + second + "秒");
        //現時刻に対して下記の返事を返すプログラム
        //4:00:00～11:59:59まではおはようございます
        //12:00:00～17:59:59まではこんにちは
        //18:00:00～3:59:59まではこんばんは
        if (0 <= hour && hour <= 8) {
            System.out.println("おはようございます！");
        } else if (9 <= hour && hour <= 17) {
            System.out.println("こんにちは！");
        } else if (17 <= hour && hour <= 23) {
            System.out.println("こんばんは！");
        }

        fw.write(dtf.format(d) +"終了します！<br>");
        fw.close();

        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.readLine());
        br.close();
    }
}
