/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 文字列;

/**
 *
 * @author guest1Day
 */
//自分の氏名について、バイト数と文字数を取得して、表示してください。

public class Byte {
    public static void main(String[] args) {
        String name = "和田見洋平";
        
        System.out.println(name);
        System.out.println("文字数：" +name.length());
        System.out.println("バイト数：" + name.getBytes().length);
    }
    
}
