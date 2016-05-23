<%-- 
    Document   : Ouyou item
    Created on : 2016/05/12, 23:19:20
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession();
    String userID = "";
    if (hs.getAttribute("userID") != null) {
        userID = hs.getAttribute("userID").toString();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>商品を登録してください</h1>
        <form action="Ouyou_itemServlet" method="post">
            <input type="radio" name="itemID" value="1">リンゴ 1個 \300
            <input type="number" name="リンゴの個数" value="">個数
            <br>
            <br>
            <input type="hidden" name="userID" value="<%=userID%>">
            <input type="submit" value="登録">
        </form>
        <br>
        <form action="Ouyou_itemLogServlet" method="post">
            <input type="hidden" name="userID" value="<%=userID%>">
            <input type="submit" value="登録履歴">
        </form>
    </body>
</html>
