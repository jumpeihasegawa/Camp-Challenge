/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jumpei
 */
public class Ouyou_loginServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int passwordInt = 0;
        if (password.length() != 0) {
            passwordInt = Integer.parseInt(password);
        }

        //値が入力された場合の処理
        Connection db_con = null;
        ResultSet db_data = null;
        PreparedStatement db_st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "jumpei", "10pei");

            //DBに情報があるか検索
            String SQL = "SELECT * FROM user WHERE name = ? AND password = ?;";
            db_st = db_con.prepareStatement(SQL);
            db_st.setString(1, name);
            db_st.setInt(2, passwordInt);
            db_data = db_st.executeQuery();

            //DBから取得した値を格納する
            db_data.next();
            String userID = db_data.getString("userID");

            //DBから検索した値がなかった場合ログインページに戻す
            HttpSession hs = request.getSession();
            if (userID.length() == 0) {
                hs.setAttribute("no_ID", "情報がありません");
                getServletConfig().getServletContext().
                        getRequestDispatcher("/Ouyoulogin.jsp").
                        forward(request, response);
            }

            //ユーザー情報が一致した場合は商品登録画面に飛ぶ
            if (userID.length() != 0) {
                hs.setAttribute("userID", userID);
            }
            getServletConfig().getServletContext().
                    getRequestDispatcher("/Ouyouitem.jsp").
                    forward(request, response);

            db_data.close();
            db_st.close();
            db_con.close();

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
