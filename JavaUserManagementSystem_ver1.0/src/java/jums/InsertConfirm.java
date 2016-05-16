package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 *
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if (accesschk == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            //7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)
            //4.insertconfirmにて再度入力する際に、このままではフォームに値が保持されていない。適切な処理を施して、再度入力の際にはフォームに値を保持したままにさせなさい
            //フォームからの入力を取得
            UserDataForm userform = new UserDataForm();
            userform.setName(request.getParameter("name"));
            userform.setYear(request.getParameter("year"));
            userform.setMonth(request.getParameter("month"));
            userform.setDay(request.getParameter("day"));
            userform.setType(request.getParameter("type"));
            userform.setTell(request.getParameter("tell"));
            userform.setComment(request.getParameter("comment"));
            
            //セッションに格納
            session.setAttribute("userform", userform);

            //insertconfirm.jspに直接アクセスをしよとしたときに使用するセッション
            String btnSubmit = request.getParameter("btnSubmit");
            session.setAttribute("btnSubmit", btnSubmit);

            System.out.println("Session updated!!");

            //3. insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい
            String no_value = "";
            if (userform.getName().equals("")) {
                no_value += "名前<br>";
            }
            if (userform.getYear().equals("")) {
                no_value += "年数<br>";
            }
            if (userform.getMonth().equals("")) {
                no_value += "月数<br>";
            }
            if (userform.getDay().equals("")) {
                no_value += "日数<br>";
            }
            if (userform.getTell().equals("")) {
                no_value += "電話番号<br>";
            }
            if (userform.getComment().equals("")) {
                no_value += "自己紹介<br>";
            }
            if (no_value.length() != 0) {
                throw new Exception(no_value + "未入力です");
            }
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
