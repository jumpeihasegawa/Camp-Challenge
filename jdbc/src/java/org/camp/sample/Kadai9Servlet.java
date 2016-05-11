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
 * @author Jumpei
 */
public class Kadai9Servlet extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        String ProfilesID = request.getParameter("ProfilesID");
        int ProfilesIDInt = Integer.parseInt(ProfilesID);
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String age = request.getParameter("age");
        int ageInt = Integer.parseInt(age);
        String birthday = request.getParameter("birthday");

        Connection db_con = null;
        ResultSet db_data = null;
        PreparedStatement db_st = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "jumpei", "10pei");
            db_st = db_con.prepareStatement("INSERT INTO profiles VALUES(?,?,?,?,?);");
            db_st.setInt(1, ProfilesIDInt);
            db_st.setString(2, name);
            db_st.setString(3, tell);
            db_st.setInt(4, ageInt);
            db_st.setString(5, birthday);

            db_st.executeUpdate();

            db_st = db_con.prepareStatement("SELECT * FROM profiles where profilesID=?;");
            db_st.setInt(1, ProfilesIDInt);

            db_data = db_st.executeQuery();

            while (db_data.next()) {
                int DProfilesID = db_data.getInt("profilesID");
                String Dname = db_data.getString("name");
                String Dtell = db_data.getString("tell");
                int Dage = db_data.getInt("age");
                String Dbirthday = db_data.getString("birthday");

                HttpSession hs = request.getSession(true);
                hs.setAttribute("ProfilesID", DProfilesID);
                hs.setAttribute("name", Dname);
                hs.setAttribute("tell", Dtell);
                hs.setAttribute("age", Dage);
                hs.setAttribute("birthday", Dbirthday);

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
                getRequestDispatcher("/Kadai9.jsp").
                forward(request, response);

        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai9Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai9Servlet at " + request.getContextPath() + "</h1>");
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
