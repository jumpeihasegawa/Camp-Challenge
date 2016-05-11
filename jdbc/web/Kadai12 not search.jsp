<%-- 
    Document   : Kadai12err_not_sharch
    Created on : 2016/05/11, 17:21:54
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
        該当するデータがありませんでした
        <br>
    </body>
</html>
