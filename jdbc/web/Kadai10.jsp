<%-- 
    Document   : Kadai10
    Created on : 2016/05/10, 14:49:49
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
        <title>削除情報</title>
    </head>
    <body>
        <form action="Kadai10Servlet" method="post">
            ID：<input type="number" name="ProfilesID" placeholder="削除したいIDを入力してください" required>            
            <input type="submit" value="削除">
        </form>
        <br>
        削除情報
        <br>
        <%
            if (ProfilesID != null) {
                out.print("ID " + ProfilesID + " 名前 " + name + " 電話 " + tell + " 年齢 " + age + " 誕生日 " + birthday + "<br>");
            }
        %>
    </body>
</html>
