/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Kadai8to9Servlet extends HttpServlet {

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
        
        //８．ファイルに自己紹介を書き出し、保存してください。
        File Ptxt = new File("Profile.txt");
        
        FileWriter Pfwa = new FileWriter(Ptxt);
        Pfwa.write("自己紹介");
        Pfwa.write("<br>");
        Pfwa.write("氏名：長谷川隼兵です。");
        Pfwa.write("<br>");
        Pfwa.write("生年月日：１９８８年０９月２８日");
        Pfwa.write("<br>");
        Pfwa.write("出身地：新潟県");
        Pfwa.write("<br>");
        Pfwa.write("血液型：Ｂ型");
        Pfwa.write("<br>");
        Pfwa.write("地元のラーメンは背油系です。");
        Pfwa.close();
        
        //９．ファイルから自己紹介を読み出し、表示してください。
        FileReader Pfr = new FileReader(Ptxt);
        BufferedReader Pbr = new BufferedReader(Pfr);
        out.print(Pbr.readLine());
        Pbr.close();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai8Servlet</title>");            
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
