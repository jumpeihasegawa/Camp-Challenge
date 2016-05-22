<%@page import="jums.UserDataBeans"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) request.getAttribute("searchResult");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= jh.birthday(udb)%>日<br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        登録日時:<%= udb.getNewDate()%><br>

        <form action="Update" method="POST">
            <!--直リンク防止のための非表示データを送る-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <!--value="変更"style="width:100px"の間に空白がないので可読性のために空白を入れる-->
            <input type="submit" name="update" value="変更" style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <!--直リンク防止のための非表示データを送る-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <!--value="削除"style="width:100px"の間に空白がないので可読性のために空白を入れる-->
            <input type="submit" name="delete" value="削除" style="width:100px">
        </form>
        <%=jh.home()%>
    </body>
</html>
