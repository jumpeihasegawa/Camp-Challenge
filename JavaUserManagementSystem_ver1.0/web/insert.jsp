<%@page import="javax.servlet.http.HttpSession" %>

<!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
<%@page import="jums.JumsHelper" %>
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
        <title>JUMS登録画面</title>
    </head>
    <body>
        <form action="insertconfirm" method="POST">
            <!--4.insertconfirmにて再度入力する際に、このままではフォームに値が保持されていない。適切な処理を施して、再度入力の際にはフォームに値を保持したままにさせなさい-->
            <!--7.フォームから受け取ったデータ自体を格納できるJavaBeansを作成し、これを利用して表示や分岐などをさせなさい(UserDataDTO.javaはデータベースのカラムに対応したJavaBeansなので微妙に違うものです)-->
            <% UserDataForm userform = (UserDataForm) hs.getAttribute("userform"); %>
            <%if (userform == null) {%>
            名前:
            <input type="text" name="name" value="">
            <br><br>
            生年月日:　
            <select name="year">
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <%for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <%for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>日
            <br><br>
            種別:
            <br>
            <!--value="1"　checkedの間が全角のスペースになっており、半角スペースに変更した-->
            <input type="radio" name="type" value="1" checked>エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3">その他<br>
            <br>

            電話番号:
            <input type="text" name="tell" value="">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ></textarea><br><br>
            <% } else { %>
            名前:
            <input type="text" name="name" value="<%out.print(userform.getName());%>">
            <br><br>
            生年月日:　
            <select name="year">
                <%if (userform.getYear() != "") {%>
                <option value="<%out.print(userform.getYear());%>"><%out.print(userform.getYear());%></option>
                <% } else {%>
                <option value="">----</option>
                <% } %>
                <%for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <%if (userform.getMonth() != "") {%>
                <option value="<%out.print(userform.getMonth());%>"><%out.print(userform.getMonth());%></option>
                <% } else {%>
                <option value="">--</option>
                <% } %>
                <%for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <%if (userform.getDay() != "") {%>
                <option value="<%out.print(userform.getDay());%>"><%out.print(userform.getDay());%></option>
                <% } else {%>
                <option value="">--</option>
                <% } %>
                <%for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>日
            <br><br>
            種別:
            <br>
            <% if (userform.getType().equals("1")) {%>
            <!--value="1"　checkedの間が全角のスペースになっており、半角スペースに変更した-->
            <input type="radio" name="type" value="1" checked="">エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3">その他<br>
            <% } else if (userform.getType().equals("2")) {%>
            <input type="radio" name="type" value="1">エンジニア<br>
            <input type="radio" name="type" value="2" checked>営業<br>
            <input type="radio" name="type" value="3">その他<br>
            <% } else {%>
            <input type="radio" name="type" value="1">エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3" checked>その他<br>
            <% } %>
            <br>
            電話番号:
            <input type="text" name="tell" value="<%out.print(userform.getTell());%>">
            <br><br>
            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%out.print(userform.getComment());%></textarea><br><br>
            <% }%>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>

        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>

    </body>
</html>
