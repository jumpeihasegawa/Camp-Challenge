<%@page import="javax.servlet.http.HttpSession" %>

<!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
<%@page import="jums.JumsHelper"%>

<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>

        <!--3. insertconfirmにて、フォームの内容が未入力であっても通過してしまう場合がある。これを通過させないようにし、かつどの項目が不完全なのかをわかるようにしなさい-->
        <% if (!hs.getAttribute("name").equals("")
                    //不完全な項目は、生年月日と電話番号と自己紹介がフォームの条件に入いなかった為、これの条件を追加した、
                    && !hs.getAttribute("year").equals("")
                    && !hs.getAttribute("month").equals("")
                    && !hs.getAttribute("day").equals("")
                    && !hs.getAttribute("tell").equals("")
                    && !hs.getAttribute("comment").equals("")) {%>

        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year") + "年" + hs.getAttribute("month") + "月" + hs.getAttribute("day") + "日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else { %>
        <h1>入力が不完全です</h1>
        <% }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>

        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>

    </body>
</html>
