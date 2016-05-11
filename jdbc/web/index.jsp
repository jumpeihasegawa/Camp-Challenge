<%-- 
    Document   : index
    Created on : 2016/05/06, 12:09:21
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
        <%
            String SQL = "SELECT * FROM profiles where";
            String And = " " + "and" + " ";
            out.print(SQL+And+"A");
        %>
    </body>
</html>
