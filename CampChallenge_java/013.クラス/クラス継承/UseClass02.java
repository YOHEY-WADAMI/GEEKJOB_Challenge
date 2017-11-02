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
//課題「クラスの作成」で作成したクラスを継承し、以下の機能を持つクラスを作成してください。
//1. ２つの変数の中身をクリアするパブリックなメソッド
public class UseClass02 {

    public static void main(String[] args) {
        Class02 cal = new Class02();

        cal.set(5, 7);
        cal.clear();
        cal.get();
    }

}
