<%@page import="javax.servlet.http.HttpSession" %>

<!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
<%@page import="jums.JumsHelper"%>
<!--7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)-->
<%@page import="jums.UserDataForm"%>

<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <!--7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)-->
        <% UserDataForm userform = (UserDataForm) hs.getAttribute("userform"); %>
        <!--直リンクしたとき（登録をまだ行っていない状態）にエラー文を表示する機能を付けた-->
        <% if (hs.getAttribute("btnSubmit").equals("確認画面へ")) {%>
        <h1>登録確認</h1>
        名前:<%= userform.getName()%><br>
        生年月日:<%= userform.getYear() + "年" + userform.getMonth() + "月" + userform.getDay() + "日"%><br>
        種別:<%= userform.getType()%><br>
        電話番号:<%= userform.getTell()%><br>
        自己紹介:<%= userform.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <!--2.insertresultにて直リンク防止用の処理が存在しない。insertからinsertconfirmへの流れを参考に修正しなさい-->
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <% } else {%>
        <h1>不正なアクセスです</h1>
        <% }%>
        <br>

        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>

    </body>
</html>
