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
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <!--2.insertresultにて直リンク防止用の処理が存在しない。insertからinsertconfirmへの流れを参考に修正しなさい-->
        <% if (hs.getAttribute("yes") == "はい") {%>
        
        <h1>登録結果</h1><br>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year") + "年" + hs.getAttribute("month") + "月" + hs.getAttribute("day") + "日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        以上の内容で登録しました。<br>
        <% } else { %>
        <h1>不正なアクセスです</h1>
        <% }%>
        <br>
        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
