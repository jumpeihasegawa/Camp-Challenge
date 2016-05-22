<%@page import="jums.UserDataBeans"
        import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    //詳細データはセッションで受け取る
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("DetailData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除確認</h1>
        以下の内容を削除します。よろしいですか？<br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= jh.birthday(udb)%>日<br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        登録日時:<%= udb.getNewDate()%><br>

        <form action="DeleteResult" method="POST">
            <!--直リンク防止のための非表示データを送る-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <!--value="はい"style="width:100px"の間に空白がないので可読性のために空白を入れる-->            
            <input type="submit" name="YES" value="はい" style="width:100px">
        </form>
        <!--リンクの先はトップページに変更-->
        <form action="index.jsp" method="POST">
            <!--直リンク防止のための非表示データを送る-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <!--value="はい"style="width:100px"の間に空白がないので可読性のために空白を入れる-->       
            <input type="submit" name="NO" value="トップに戻る" style="width:100px">
        </form>
    </body>
</html>
