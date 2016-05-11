<%-- 
    Document   : Kadai8jsp
    Created on : 2016/05/06, 17:49:28
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>名前検索</title>
    </head>
    <body>
        <form action="Kadai8Servlet" method="post">
            名前：<input type="search" name="namae" size="30" placeholder="検索する名前を入力してください" required>
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
                    Object ProfilesID = hs.getAttribute("ProfilesID" + i);
                    Object name = hs.getAttribute("name" + i);
                    Object tell = hs.getAttribute("tell" + i);
                    Object age = hs.getAttribute("age" + i);
                    Object birthday = hs.getAttribute("birthday" + i);
                    out.print("ID " + ProfilesID + " 名前 " + name + " 電話 " + tell + " 年齢 " + age + " 誕生日 " + birthday + "<br>");
                }
            }
        %>
    </body>
</html>
