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
//以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、結果を表示してください。
//「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」
public class mojiirekae {

    public static void main(String[] args) {
        String word = "「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」";
        
        String wd1 = word.replace("I", "い");
        String wd2 = wd1.replace("U", "う");
        
        System.out.println(wd2);

    }

}
