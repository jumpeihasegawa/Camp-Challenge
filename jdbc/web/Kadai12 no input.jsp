<%-- 
    Document   : Kadai12err
    Created on : 2016/05/11, 16:04:45
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
        検索したいものを入力してくだい
        <br>
    </body>
</html>
