package BlackJack;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest1Day
 */
//Humanの中身を抽象する。それぞれの要素を記載。
//ポイントはカードを受けとる、受け取ったカードの値を計算するそして闘う＞行動責任
//その情報を保持する責任
abstract class Human {
    //カードの合計値を計算して返す
    abstract public int open();

    // カードを自分の手札にセットする＞setCarad
    // DealerとUserそれぞれにsetCardを用意
    abstract public void setCard(ArrayList<Integer> card);

    //合計値がまだカードを引き必要があるかの確認
    abstract public boolean checkSum();
    
    // 自分の持ち札をを管理する＞myCards
    ArrayList<Integer> myCards = new ArrayList<Integer>();
}

