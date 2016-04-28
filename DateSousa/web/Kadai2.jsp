<%-- 
    Document   : Kadai2jsp
    Created on : 2016/04/25, 15:41:21
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介</title>
    </head>
    <body>
        
        <!--２．以下の機能を実装してください。
　　　１で作成したHTMLの入力データを取得し、画面に表示する-->
        
        <form action="Kadai2Servlet" method="post">
            名前：<%= request.getAttribute( "namae" ) %>
            性別：<%= request.getAttribute( "seibetu" ) %>
            趣味：<%= request.getAttribute( "shumi" ) %>
        </form>
    </body>
</html>
