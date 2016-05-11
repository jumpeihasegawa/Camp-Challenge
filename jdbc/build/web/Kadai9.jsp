<%-- 
    Document   : Kadai9
    Created on : 2016/05/09, 15:40:26
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession hs = request.getSession(true);
    Object ProfilesID = hs.getAttribute("ProfilesID");
    Object name = hs.getAttribute("name");
    Object tell = hs.getAttribute("tell");
    Object age = hs.getAttribute("age");
    Object birthday = hs.getAttribute("birthday");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>追加情報</title>
    </head>
    <body>
        <form action="Kadai9Servlet" method="post">
            ID：<input type="number" name="ProfilesID" required>
            名前：<input type="text" name="name" required>
            電話：<input type="tel" name="tell" maxlength="17" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" required>
            年齢：<input type="number" name="age" required>
            誕生日：<input type="date" name="birthday" required>            

            <input type="submit" value="追加">
        </form>
        <br>
        追加情報
        <%
            if (ProfilesID != null) {
                out.print("ID " + ProfilesID + " 名前 " + name + " 電話 " + tell + " 年齢 " + age + " 誕生日 " + birthday + "<br>");
            }
        %>
    </body>
</html>
