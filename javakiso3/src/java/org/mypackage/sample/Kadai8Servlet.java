/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Kadai8Servlet extends HttpServlet {

    HashMap<String, String> ID(int ID) {
        HashMap<String, String> IDMap = new HashMap<String, String>();
        if (ID == 001) {
            IDMap.put("ID", "1");
            IDMap.put("名前", "伊藤博文");
            IDMap.put("生年月日", "1841年10月16日");
            IDMap.put("住所", "山口県熊毛郡大和町");
        } else if (ID == 2) {
            IDMap.put("ID", "2");
            IDMap.put("名前", "黒田清隆");
            IDMap.put("生年月日", "1888年4月30日");
            IDMap.put("住所", "鹿児島県鹿児島市新屋敷通町");
        } else if (ID == 3) {
            IDMap.put("ID", "3");
            IDMap.put("名前", "三条実美");
            IDMap.put("生年月日", "1889年10月25日");
            IDMap.put("住所", "");
        }
        return IDMap;
    }

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

        Integer limit = 2;
        for (int i = 1; i <= 3; i++) {
            HashMap ID = ID(i);
            if (ID.get("名前") == null) {
                continue;
            } else {
                out.print(ID.get("名前") + "<br>");
            }
            if (ID.get("生年月日") == null) {
                continue;
            } else {
                out.print(ID.get("生年月日") + "<br>");
            }
            if (ID.get("住所") == null) {
                continue;
            } else {
                out.print(ID.get("住所") + "<br>");
            }
            if(limit == i){
                break;
            }
        }

            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>課題8:先にInteger limit=2を定義しておき、課題7の処理のうち2人目(limitで定義した値の人数)まででループ処理を抜けるようにする</title>");
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
