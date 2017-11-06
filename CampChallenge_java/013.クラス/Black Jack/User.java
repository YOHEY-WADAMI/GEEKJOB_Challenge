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
class User extends Human {

    // カードの合計値を計算して返すopenメソッド
    // myCards（自分の手札の管理）
    @Override
    public int open() {
        //totalは合計値　０でコンストラクト
        int total = 0;
        //myCardsの要素数まで繰り返す
    for(int i = 0;i < myCards.size();i++){
        //そのi番目の要素をたしていく
        total += myCards.get(i);
    }
    return total;//結果をtotalへ返す
    }

    @Override
    //引いたカードをセットしていくsetCardメソッド
    public void setCard(ArrayList<Integer> set) {
        
        for(int i = 0;i <set.size();i++){
        myCards.add(set.get(i));
    }
    }

    @Override
    public boolean checkSum() {
        int total = open();
    if(total <= 20){
        return true;
    }else{
        return false;
    }
    }
        
}
    

