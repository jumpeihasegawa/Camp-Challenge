package jums;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertresultと対応するサーブレット フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 *
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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

        //セッションスタート
        HttpSession session = request.getSession();

        //insertresult.jspに直接アクセスをしよとしたときに使用するセッション
        request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
        String yes = request.getParameter("yes");
        session.setAttribute("yes", yes);

        try {
            //2.insertresultにて直リンク防止用の処理が存在しない。insertからinsertconfirmへの流れを参考に修正しなさい
            String accesschk = request.getParameter("ac");
            if (accesschk == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            //7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)
            UserDataForm userform = (UserDataForm) session.getAttribute("userform");

            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataDTO userdata = new UserDataDTO();
            userdata.setName(userform.getName());

            //6.入力された生年月日の情報がDBに正しく格納されていない。これを修正しなさい
            Calendar birthday = Calendar.getInstance();
            int year = Integer.parseInt(userform.getYear());
            int month = Integer.parseInt(userform.getMonth());
            int day = Integer.parseInt(userform.getDay());
            birthday.set(year, month, day);
            userdata.setBirthday(birthday.getTime());

            userdata.setType(Integer.parseInt(userform.getType()));
            userdata.setTell(userform.getTell());
            userdata.setComment(userform.getComment());

            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);

            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        } catch (Exception e) {
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
