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
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <!--7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)-->
        <% UserDataForm userform = (UserDataForm) hs.getAttribute("userform"); %>
        <!--直リンクしたとき（確認をまだ行っていない状態）にエラー文を表示する機能を付けた-->
        <% if (hs.getAttribute("yes").equals("はい")) {%>
        <h1>登録結果</h1><br>
        名前:<%= userform.getName()%><br>
        生年月日:<%= userform.getYear() + "年" + userform.getMonth() + "月" + userform.getDay() + "日"%><br>
        種別:<%= userform.getType()%><br>
        電話番号:<%= userform.getTell()%><br>
        自己紹介:<%= userform.getComment()%><br>
        以上の内容で登録しました。<br>
        <% } else { %>
        <h1>不正なアクセスです</h1>
        <% }%>
        <br>
        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
