/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class BlackjackServlet extends HttpServlet {

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

        Dealer D = new Dealer();
        ArrayList<Integer> Udeal = D.deal(out);

        User U = new User();
        U.setCard(Udeal, out);
        boolean UcheckSum = U.checkSum();
        int ut = 1;
        while (UcheckSum == true) {
            ArrayList<Integer> Uhit = D.hit(UcheckSum);
            U.setCard(Uhit, out);
            UcheckSum = U.checkSum();
            ut++;
        }
        int u = U.open(out);

        out.print("<br><br>");
        ArrayList<Integer> Ddeal = D.deal(out);
        D.setCard(Ddeal, out);
        boolean BcheckSum = D.checkSum();
        int dt = 1;
        while (BcheckSum == true) {
            ArrayList<Integer> Dhit = D.hit(BcheckSum);
            D.setCard(Dhit, out);
            BcheckSum = D.checkSum();
            dt++;
        }
        int d = D.open(out);

        out.print("<br>");

        if (u == 21 && d == 21) {
            if (ut < dt) {
                out.print("ユーザーの勝ちです");
            } else if (ut > dt) {
                out.print("ディーラーの勝ちです");
            } else if (ut == dt) {
                out.print("引き分けです");
            }
        } else if (u > 21 && d > 21 || u == d) {
            out.print("引き分けです");
        } else if (u > 21 || d > 21) {
            if (u > d) {
                out.print("ディーラーの勝ちです");
            } else {
                out.print("ユーザーの勝ちです");
            }
        } else if (u > d) {
            out.print("ユーザーの勝ちです");
        } else {
            out.print("ディーラーの勝ちです");
        }

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>オブジェクト指向２の課題</title>");
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
