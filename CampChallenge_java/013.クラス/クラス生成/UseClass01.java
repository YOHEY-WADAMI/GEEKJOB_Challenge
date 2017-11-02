package クラス;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest1Day
 */
//以下の機能を持つクラスを作成してください。
//1. パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、２つの変数の中身をprintするパブリックなメソッド

public class UseClass01 {

    public static void main(String[] args) {
        
        Class01 use = new Class01();

        use.set(5,7);
        use.get();
    }
}
