<%@page import="jums.UserDataBeans"
        import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataBeans> udb = (ArrayList<UserDataBeans>) request.getAttribute("searchResult");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for (int i = 0; i < udb.size(); i++) {%>
            <tr>
                <!--名前がクリック可能になっており、クリックするとresultdetailへ遷移する(クリックしたデータと詳細データが異なっている-->
                <td><a href="ResultDetail?id=<%= udb.get(i).getUserID()%>" ><%= udb.get(i).getName()%></a></td>
                <td><%= jh.birthday(udb.get(i))%></td>
                <!--種別がDBの数字のまま表示されるのでJumsHelperのメソッドで日本語表記にする-->
                <td><%= jh.exTypenum(udb.get(i).getType())%></td>
                <td><%= udb.get(i).getNewDate()%></td>
            </tr>
            <% }%>
        </table>
        <%=jh.home()%>
    </body>
</html>
