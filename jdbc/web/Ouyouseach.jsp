<%-- 
    Document   : Ouyou seach
    Created on : 2016/05/23, 18:57:50
    Author     : Jumpei
--%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession hs = request.getSession();
    ArrayList itemArr = (ArrayList) hs.getAttribute("itemArr");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>登録一覧</h1>
        <table border=1>
            <tr>
                <th>商品ID</th>
                <th>商品名</th>
                <th>値段</th>
                <th>個数</th>
            </tr>
            <tr>
                <% for (int i = 0; i < itemArr.size(); i++) {%>
                <td><%= itemArr.get(i).toString()%></td>
                <% if ((i + 1) % 4 == 0) {out.print("</tr>");}%>
                <% }%>
        </table>
        <a href="Ouyouitem.jsp">登録画面へ戻る</a>
    </body>
</html>
