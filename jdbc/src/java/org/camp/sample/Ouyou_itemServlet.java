/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Ouyou_itemServlet extends HttpServlet {

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

        //JSPから値をもらう
        request.setCharacterEncoding("UTF-8");
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        int number = Integer.parseInt(request.getParameter("リンゴの個数"));
        int userID = Integer.parseInt(request.getParameter("userID"));
        
        //DBの処理
        Connection db_con = null;
        ResultSet db_data = null;
        PreparedStatement db_st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            
            String SQL = "INSERT INTO item VALUES(?,?,?,?,?)";
            db_st = db_con.prepareStatement(SQL);
            db_st.setInt(1, itemID);
            db_st.setString(2, "リンゴ");
            db_st.setInt(3, 300);
            db_st.setInt(4, number);
            db_st.setInt(5, userID);
            
            db_st.executeUpdate();
            
            getServletConfig().getServletContext().
                    getRequestDispatcher("/Ouyouadd.jsp").
                    forward(request, response);
            
        } catch (SQLException e_sql) {
            out.println("接続時にエラーが発生しました：" + e_sql.toString());
        } catch (Exception e) {
            out.println("接続時にエラーが発生しました：" + e.toString());
        } finally {
            if (db_con != null) {
                try {
                    db_con.close();
                } catch (Exception e_con) {
                    System.out.println(e_con.getMessage());
                }
            }
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
