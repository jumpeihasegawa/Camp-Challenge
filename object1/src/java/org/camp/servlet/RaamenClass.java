/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.PrintWriter;

/**
 *
 * @author Jumpei
 */

/**
 * ３．以下の機能を持つクラスを作成してください。
 * ・パブリックな２つの変数
 * ・２つの変数に値を設定するパブリックな関数
 * ・２つの変数の中身をprintするパブリックな関数
 */
    public class RaamenClass{
        public String suupu = "";
        public String ajinokosa= "";
        public void setRaamen(String Suupu,String Ajinokosa){
            suupu = Suupu;
            ajinokosa = Ajinokosa;
        }
        public void showSuupu(PrintWriter out){
            out.print(suupu+"<br>");
        }
        public void showAjinokosa(PrintWriter out){
            out.print(ajinokosa+"<br>");
        }
    }  
    
        /**
         * ４．３のクラスを継承し、以下の機能を持つクラスを作成してください。
         * ・２つの変数の中身をクリアするパブリックな関数
         */
        class taberu extends RaamenClass {
        public void gotisousama(){
            suupu = "";
            ajinokosa ="";
        }
    }