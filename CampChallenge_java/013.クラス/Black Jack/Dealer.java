package BlackJack;

import java.util.ArrayList;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest1Day
 */
public class Dealer extends Human {

    //ArrayList配列を用意
    ArrayList<Integer> cards = new ArrayList();

    public Dealer() {
        //ハート、ダイヤ、スペード、クローバの４種類
        for (int i = 1; i <= 4; i++) {
            //１０まではそのまま加えるがそれ以上は一律１０で加える
            for (int j = 1; j <= 13; j++) {
                if (j <= 10) {
                    cards.add(j);//()の中の値を0番目から順番にcardsにセットする
                } else {
                    cards.add(10);
                }
            }
        }
    }
//dealメソッドの中身
    //ArrayListメソッドの中の処理を始める
    public ArrayList<Integer> deal() {
        //dealcardにインスタンス
        ArrayList<Integer> dealCard = new ArrayList<Integer>();
        //Randomメソッドを準備　ランダムに受け取る準備
        Random rand = new Random();

        //2回繰り返す
        for (int i = 0; i < 2; i++) {
            //cards（山札）に先ほど加えた52枚からランダムにnextIntメソッドでIndexへ加える
            int Index = rand.nextInt(cards.size());
            
            //↓がIntegerなのはそういうもん　
            //cardsから引いたindex（取得したint型乱数）を取得し、dealCardsに追加
            Integer card = cards.get(Index);
            dealCard.add(card);
            //  ↓は、↑２行をまとめたもの
            //  dealCard.add(cards.get(Index));
            // 取得した乱数を2度続けて引かないよう削除　結果をdealCardに返す
            cards.remove(Index);
        }
        return dealCard;
    }
    // 山札（cards）からランダムで1枚のカードを引き、ArrayListにして返却
    public ArrayList<Integer> hit() {
        ArrayList<Integer> hitCard = new ArrayList<>();
        Random rand = new Random();
        int Index = rand.nextInt(cards.size());
        //cardsで取得したIndexをhitCardに加える
        hitCard.add(cards.get(Index));
        //乱数で取得したIndexを削除
        cards.remove(Index);
        //結果をhitCardへ返す
        return hitCard;
    }

    // カードの合計値を計算して返すopenメソッド　手札の公開
    @Override
    public int open() {
        int total = 0;
        //myCards（手札）にある枚数文繰り返す
        for (int i = 0; i < myCards.size(); i++) {
            //ArrayList配列のmyCards（手札）のi番目の要素を取得
            total = total + myCards.get(i);
        }
        return total; //結果をtotalへ返す
    }

    // カードを自分の手札にセットする
    // set　に引いたカードが入ってきたら、set　の要素数分すべてをmyCardsに追加する
    @Override
    public void setCard(ArrayList<Integer> set) {
        for (int i = 0; i < set.size(); i++) {
            myCards.add(set.get(i));
            
            
        }

    }

    // 「自分の合計値」からまだカードを引く必要があるかチェック
    //合計値がどうなるかの判定
    @Override
    public boolean checkSum() {
        //openメソッドの戻り値が１６かそれ以下ならtrueを返し、それ以外はfalseを返す
        int total = open();
        if (total <= 16) {
            return true;
        } else {
            return false;
        }

    }

}
