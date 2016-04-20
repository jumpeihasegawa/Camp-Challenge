/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jumpei
 */
/**
 * １．Humanという抽象クラスを作成し、以下を実装してください。 ・openというabstractな公開メソッドを用意してください。
 * ・setCardというArrayListを引数とした、abstractな公開メソッドを用意してください。
 * ・checkSumというabstractな公開メソッドを用意してください。 ・myCardsというArrayListの変数を用意してください。
 */
abstract class Human {

    abstract public Integer open(PrintWriter out);

    abstract public void setCard(ArrayList<Integer> mycard, PrintWriter out);

    abstract public boolean checkSum();

    ArrayList<Integer> myCards = new ArrayList<Integer>();

}

/**
 * ２．１で作成した抽象クラスを継承して、以下のクラスを作成してください。 ・Dealerクラス ・Userクラス
 */
/**
 * ３．まずはDealerクラスを完成させます。
 * ・cardsというArrayListの変数を用意し、初期処理でこのcardsに全てのトランプを持たせてください。
 * ・dealという公開メソッドを用意し、cardsからランダムで2枚のカードをArrayListにして返却してください。
 * ・hitという公開メソッドを用意し、cardsからランダムで1枚のカードをArrayListにして返却してください。 / /**
 * ４．DealerとUser両方に必要な処理を実装し、完成させます。
 * ・setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
 * ・checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
 * ・openは、myCardsのカードの合計値を返却するように実装してください。
 */
class Dealer extends Human {

    ArrayList<Integer> Cards = new ArrayList<Integer>();
    ArrayList<Integer> Ldeal = new ArrayList<Integer>();
    ArrayList<Integer> Lhit = new ArrayList<Integer>();
    int goukei;
    int T = 1;

    Dealer() {
        for (int j = 1; j <= 4; j++) {
            for (int i = 1; i <= 13; i++) {
                Cards.add(i);
            }
        }
    }

    public ArrayList<Integer> deal(PrintWriter out) {
        Ldeal.clear();
        Random r = new Random();
        for (int i = 1; i <= 2; i++) {
            int R = r.nextInt(Cards.size());
            Ldeal.add(Cards.get(R));
            Cards.remove(R);
            out.print(" "+R+":");
            out.print(Cards.size());
        }
        
        return Ldeal;
    }

    public ArrayList<Integer> hit(boolean BcheckSum) {
        Random r = new Random();
        Lhit.clear();
        if (BcheckSum == true) {
            int R = r.nextInt(Cards.size());
            Lhit.add(Cards.get(R));
            Cards.remove(R);
        }
        return Lhit;
    }

    public Integer open(PrintWriter out) {
        out.print("ディーラーのポイント" + goukei + "<br>");
        myCards.clear();
        return goukei;
    }

    public void setCard(ArrayList<Integer> DsetCard, PrintWriter out) {
        for (int i = 0; i < DsetCard.size(); i++) {
            myCards.add(DsetCard.get(i));
        }

        out.print("ディーラーのカード" + "(" + T++ + "ターン目)" + "<br>");
        for (int i = 0; i < myCards.size(); i++) {
            out.print("カードの" + myCards.get(i) + "<br>");
        }
    }

    public boolean checkSum() {
        for (int i = 0; i < myCards.size(); i++) {
            if (myCards.get(i) >= 11) {
                myCards.set(i, 10);
            }
        }

        goukei = 0;
        for (int i = 0; i < myCards.size(); i++) {
            goukei += myCards.get(i);
        }
        if (goukei <= 11 && goukei >= 6) {
            for (int i = 0; i < myCards.size(); i++) {
                if (myCards.get(i) == 1) {
                    myCards.set(i, 11);
                    break;
                }
            }
        }
        goukei = 0;
        for (int i = 0; i < myCards.size(); i++) {
            goukei += myCards.get(i);
        }
        if (goukei < 16) {
            return true;
        } else {
            return false;
        }
    }
}

class User extends Human {

    int goukei;
    int T = 1;

    public Integer open(PrintWriter out) {
        out.print("ユーザーのポイント" + goukei);
        myCards.clear();
        return goukei;
    }

    public void setCard(ArrayList<Integer> UsetCard, PrintWriter out) {
        for (int i = 0; i < UsetCard.size(); i++) {
            myCards.add(UsetCard.get(i));
        }
        out.print("ユーザーのカード" + "(" + T++ + "ターン目)" + "<br>");
        for (int i = 0; i < myCards.size(); i++) {
            out.print("カードの" + myCards.get(i) + "<br>");
        }
    }

    public boolean checkSum() {
        for (int i = 0; i < myCards.size(); i++) {
            if (myCards.get(i) >= 11) {
                myCards.set(i, 10);
            }
        }

        goukei = 0;
        for (int i = 0; i < myCards.size(); i++) {
            goukei += myCards.get(i);
        }
        if (goukei <= 11 && goukei >= 6) {
            for (int i = 0; i < myCards.size(); i++) {
                if (myCards.get(i) == 1) {
                    myCards.set(i, 11);
                    break;
                }
            }
        }

        goukei = 0;
        for (int i = 0; i < myCards.size(); i++) {
            goukei += myCards.get(i);
        }

        if (goukei < 16) {
            return true;
        } else {
            return false;
        }
    }
}
