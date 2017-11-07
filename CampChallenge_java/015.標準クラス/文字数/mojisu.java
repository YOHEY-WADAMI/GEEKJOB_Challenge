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
//自分のメールアドレスの「@」以降の文字を取得して、表示してください。

public class mojisu {
    public static void main(String[] args) {
        String address = "test123@gmail.com";
        System.out.println(address);
        
        int num = address.indexOf("@");
        System.out.println("@以降の文字：" + address.substring(num+1));
        
    }
    
}
