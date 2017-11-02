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
class Class01 {

    public int num1;
    public int num2;

    public void set(int x, int y) {
        this.num1 = x;
        this.num2 = y;
        System.out.println("受け取りok");
    }

    public void get() {
        System.out.print(num1 + ","+num2);
        
    }
}


