<%-- 
    Document   : Kadai12
    Created on : 2016/05/10, 16:53:02
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Kadai12Servlet" method="post">
            名前：<input type="text" name="name" >
            年齢：<input type="number" name="age" >
            誕生日：<input type="date" name="birthday" >            
            <input type="submit" value="検索">
        </form>
        <br>
        検索結果
        <br>
        <%
            HttpSession hs = request.getSession(true);
            if (hs.getAttribute("ID") != null) {
                String ID = hs.getAttribute("ID").toString();
                int I = Integer.parseInt(ID);
                for (int i = 1; i <= I; i++) {
                    Object name = hs.getAttribute("name" + i);
                    Object age = hs.getAttribute("age" + i);
                    Object birthday = hs.getAttribute("birthday" + i);
                    out.print(" 名前 " + name + " 年齢 " + age + " 誕生日 " + birthday + "<br>");
                }
            }
        %>
    </body>
</html>
