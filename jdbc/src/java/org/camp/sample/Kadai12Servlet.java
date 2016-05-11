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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jumpeid
 */
public class Kadai12Servlet extends HttpServlet {

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
        ResultSet db_data = null;
        PreparedStatement db_st = null;
        HttpSession hs = request.getSession(true);
        int i = 1;
        String Dname = "";

        //JSPから値をもらう
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int ageInt = 0;
        if (age.length() != 0) {
            ageInt = Integer.parseInt(age);
        }
        String birthday = request.getParameter("birthday");

        //入力された値が空白だったらエラーページに飛ばす
        if (name.length() == 0 && age.length() == 0 && birthday.length() == 0) {
            getServletConfig().getServletContext().
                    getRequestDispatcher("/Kadai12 no input.jsp").
                    forward(request, response);
        }

        //値が入力された場合の処理
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "jumpei", "10pei");

            String SQL = "SELECT * FROM Profiles WHERE ";
            String And = " " + "AND" + " ";

            if (name.length() != 0 && age.length() != 0 && birthday.length() != 0) {
                SQL += "name = ?" + And + "age = ?" + And + "birthday = ?" + ";";
                db_st = db_con.prepareStatement(SQL);
                db_st.setString(1, name);
                db_st.setInt(2, ageInt);
                db_st.setString(3, birthday);
            } else if (name.length() != 0 && age.length() != 0) {
                SQL += "name = ?" + And + "age = ?" + ";";
                db_st = db_con.prepareStatement(SQL);
                db_st.setString(1, name);
                db_st.setInt(2, ageInt);
            } else if (name.length() != 0 && birthday.length() != 0) {
                SQL += "name = ?" + And + "birthday = ?" + ";";
                db_st = db_con.prepareStatement(SQL);
                db_st.setString(1, name);
                db_st.setString(2, birthday);
            } else if (age.length() != 0 && birthday.length() != 0) {
                SQL += "age = ?" + And + "birthday = ?" + ";";
                db_st = db_con.prepareStatement(SQL);
                db_st.setInt(1, ageInt);
                db_st.setString(2, birthday);
            } else {
                if (name.length() != 0) {
                    SQL += "name = ?" + ";";
                    db_st = db_con.prepareStatement(SQL);
                    db_st.setString(1, name);
                }
                if (age.length() != 0) {
                    SQL += "age = ?" + ";";
                    db_st = db_con.prepareStatement(SQL);
                    db_st.setString(1, age);
                }
                if (birthday.length() != 0) {
                    SQL += "birthday = ?" + ";";
                    db_st = db_con.prepareStatement(SQL);
                    db_st.setString(1, birthday);
                }
            }

            db_data = db_st.executeQuery();

            while (db_data.next()) {
                Dname = db_data.getString("name");
                int Dage = db_data.getInt("age");
                String Dbirthday = db_data.getString("birthday");

                hs.setAttribute("name" + i, Dname);
                hs.setAttribute("age" + i, Dage);
                hs.setAttribute("birthday" + i, Dbirthday);
                hs.setAttribute("ID", i);
                i++;
            }

            if (Dname.length() == 0) {
                getServletConfig().getServletContext().
                        getRequestDispatcher("/Kadai12 not search.jsp").
                        forward(request, response);
            }

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

        getServletConfig().getServletContext().
                getRequestDispatcher("/Kadai12.jsp").
                forward(request, response);
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai12Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai12Servlet at " + request.getContextPath() + "</h1>");
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
