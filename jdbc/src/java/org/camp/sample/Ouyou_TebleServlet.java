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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Ouyou_TebleServlet extends HttpServlet {

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

        Connection db_con = null;
        PreparedStatement db_st = null;
        String SQL = "";

        try {
            //データベースに接続する
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "root", "");
            
            //userテーブルを作成する
            SQL = "CREATE TABLE user(userID int,name varchar(255),password int);";
            db_st = db_con.prepareStatement(SQL);
            db_st.executeUpdate();

            //ユーザーの情報を入れる（？の順番はuserID,name,password）
            SQL = "INSERT INTO user VALUES(?,?,?);";
            db_st = db_con.prepareStatement(SQL);
            db_st.setInt(1, 1);
            db_st.setString(2, "田中 実");
            db_st.setInt(3, 123);
            db_st.executeUpdate();
            
            db_st.setInt(1, 2);
            db_st.setString(2, "鈴木 茂");
            db_st.setInt(3, 234);
            db_st.executeUpdate();
            
            db_st.setInt(1, 3);
            db_st.setString(2, "鈴木 実");
            db_st.setInt(3, 345);            
            db_st.executeUpdate();
            
            db_st.setInt(1, 4);
            db_st.setString(2, "佐藤 清");
            db_st.setInt(3, 456);            
            db_st.executeUpdate();
            
            db_st.setInt(1, 5);
            db_st.setString(2, "高橋 清");
            db_st.setInt(3, 567);            
            db_st.executeUpdate();
            
            //ユーザー情報管理テーブルを作成する
            SQL = "CREATE TABLE item (itemID int,name varchar(255),price int,number int,userID int);";
            db_st = db_con.prepareStatement(SQL);
            db_st.executeUpdate();
            
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

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ouyou_TebleServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ouyou_TebleServlet at " + request.getContextPath() + "</h1>");
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
