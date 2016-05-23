<%-- 
    Document   : newjsp
    Created on : 2016/05/12, 19:26:14
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        HttpSession hs = request.getSession();
        String no_ID = "";
        if (hs.getAttribute("no_ID") != null) {
            no_ID = hs.getAttribute("no_ID").toString();
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>名前とパスワードを入力してください</h1>
        <br>
        <br>
        <form action="Ouyou_loginServlet" method="post">
            名前：<input type="text" name="name" required>
            パスワード：<input type="password" name="password" required>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
