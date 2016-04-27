/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Kadai5Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //５．自分の氏名について、バイト数と文字数を取得して、表示してください。
        String kanji = "長谷川隼兵";
        String hiragana = "はせがわじゅんぺい";
        String katakana = "ハセガワジュンペイ";
        String eigo = "hasegawa jumpei";

        out.print(kanji + "の文字数" +kanji.length()+ "<br>");
        out.print(hiragana + "の文字数" +hiragana.length()+ "<br>");
        out.print(katakana + "の文字数" +katakana.length()+ "<br>");
        out.print(eigo + "の文字数" +eigo.length()+ "<br>");
        out.print("<br>");

        out.print(kanji + "のバイト数" + kanji.getBytes().length + "<br>");
        out.print(hiragana + "のバイト数" + hiragana.getBytes().length + "<br>");
        out.print(katakana + "のバイト数" + katakana.getBytes().length + "<br>");
        out.print(eigo + "のバイト数" + eigo.getBytes().length + "<br>");
        out.print("<br>");

        byte[] Kn = kanji.getBytes();
        out.print(kanji + "のバイト数" + Kn.length + "<br>");
        byte[] H = hiragana.getBytes();
        out.print(hiragana + "のバイト数" + H.length + "<br>");
        byte[] Kt = katakana.getBytes();
        out.print(katakana + "のバイト数" + Kt.length + "<br>");
        byte[] E = eigo.getBytes();
        out.print(eigo + "のバイト数" + E.length + "<br>");

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>標準クラスの課題５</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
