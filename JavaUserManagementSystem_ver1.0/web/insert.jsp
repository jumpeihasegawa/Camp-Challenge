<%@page import="javax.servlet.http.HttpSession" %>

<!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
<%@page import="jums.JumsHelper" %>

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
            名前:
            <% if (hs.getAttribute("name") != null) { %>
            <input type="text" name="name" value="<%out.print(hs.getAttribute("name"));%>">
            <% } else { %>
            <input type="text" name="name" value="">
            <% } %>
            <br><br>

            生年月日:　
            <select name="year">
                <% if (hs.getAttribute("year") == null) { %>
                <option value="">----</option>
                <% } else {%>
                <option value="<%out.print(hs.getAttribute("year"));%>"><%out.print(hs.getAttribute("year"));%></option>
                <% } %>
                <%
                    for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"> <%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <% if (hs.getAttribute("month") == null) { %>
                <option value="">--</option>
                <% } else { %>
                <option value="<%out.print(hs.getAttribute("month"));%>"><%out.print(hs.getAttribute("month"));%></option>
                <% } %>
                <%
                    for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <% if (hs.getAttribute("day") == null) { %>
                <option value="">--</option>
                <% } else { %>
                <option value="<%out.print(hs.getAttribute("day"));%>"><%out.print(hs.getAttribute("day"));%></option>
                <% } %>
                <%
                    for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:
            <br>

            <!--value="1"　checkedの間が全角のスペースになっており、半角スペースに変更した-->
            <% if (hs.getAttribute("type") == null || hs.getAttribute("type").equals("1")) {%>
            <input type="radio" name="type" value="1" checked>エンジニア<br>
            <input type="radio" name="type" value="2">営業<br>
            <input type="radio" name="type" value="3">その他<br>
            <% } else if (hs.getAttribute("type").equals("2")) {%>
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
            <% if (hs.getAttribute("tell") != null) { %>
            <input type="text" name="tell" value="<%out.print(hs.getAttribute("tell"));%>">
            <% } else { %>
            <input type="text" name="tell" value="">
            <% } %>
            <br><br>

            自己紹介文
            <br>
            <% if (hs.getAttribute("tell") != null) { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ><%out.print(hs.getAttribute("comment"));%></textarea><br><br>
            <% } else { %>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" ></textarea><br><br>
            <% }%>
            
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>

        <!--1.JumsHelperクラスを利用して、全部のページにトップへのリンクが表示されるようにしなさい-->
        <%=JumsHelper.getInstance().home()%>

    </body>
</html>
