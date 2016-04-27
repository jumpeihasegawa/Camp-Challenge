/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.sample;

import java.io.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jumpei
 */
public class Kadai10Servlet extends HttpServlet {

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
        
        /*
        １０．紹介していないJAVAの標準クラスを利用して、処理を作成してください。
        講義では紹介されていないJAVAの標準クラスはたくさん存在します。
        １つJAVAの標準クラスを選び、実際にロジックを作成してみてください。     
        また、この処理を作成するに当たり、下記を必ず実装してください。
        ①処理の経過を書き込むログファイルを作成する。
        ②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
        ③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
        ④最後に、ログファイルを読み込み、その内容を表示してください。
         */
        
        //①処理の経過を書き込むログファイルを作成する。
        File LGtxt = new File("LogFile.txt");
        
        FileWriter LGfwa = new FileWriter(LGtxt);
        BufferedWriter LGbw = new BufferedWriter(LGfwa);
                
        //②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
        //③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int mo = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int mi = cal.get(Calendar.MINUTE);
        int s = cal.get(Calendar.SECOND);
        
        LGbw.write("日時　" + y + "年" + mo + "月" + d + "日" + h + "時" + mi + "分" + s + "秒" + "　開始<br>");
        LGbw.newLine();
        
        for(double i = 0;i <= 1000000;i++){
            double ruijou = Math.pow(10,i);
        } 
        
        //②処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
        //③書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
        Calendar cal2 = Calendar.getInstance();
        int y2 = cal2.get(Calendar.YEAR);
        int mo2 = cal2.get(Calendar.MONTH) + 1;
        int d2 = cal2.get(Calendar.DAY_OF_MONTH);
        int h2 = cal2.get(Calendar.HOUR_OF_DAY);
        int mi2 = cal2.get(Calendar.MINUTE);
        int s2 = cal2.get(Calendar.SECOND);
        
        LGbw.write("日時　" + y2 + "年" + mo2 + "月" + d2 + "日" + h2 + "時" + mi2 + "分" + s2 + "秒" + "　終了<br>");
        LGbw.newLine();
        LGbw.close();
        LGfwa.close();
        
        //④最後に、ログファイルを読み込み、その内容を表示してください。
        FileReader LGfr = new FileReader(LGtxt);
        BufferedReader LGbr = new BufferedReader(LGfr);
        String str;
        while((str = LGbr.readLine()) != null){
        out.print(str);
        }


        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Kadai10Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Kadai10Servlet at " + request.getContextPath() + "</h1>");
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
