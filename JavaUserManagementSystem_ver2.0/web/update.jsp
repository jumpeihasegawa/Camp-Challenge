<%@page import="jums.UserDataBeans"
        import="jums.JumsHelper" 
        import="jums.UserDataDTO"%>
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
        <title>JUMS変更画面</title>
    </head>
    <body>
        <!--ただし初めはresult_detail.javaから個人のデータを受け取り、フォーム内に直接記入された状態である。このフォームの内容を書き換えていくことでデータの更新ができる-->
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= udb.getName()%>">
            <br><br>

            生年月日:　
            <select name="year">
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" <% if (udb.getYear() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                <% }%>
            </select>年
            <select name="month">
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" <% if (udb.getMonth() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                <% }%>
            </select>月
            <select name="day">
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>" <% if (udb.getDay() == i) {
                        out.print("selected = \"selected\"");
                    }%>><%=i%></option>
                <% } %>
            </select>日
            <br><br>

            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>" <%if (udb.getType() == i) {
                    out.print("checked");
                }%>><%=jh.exTypenum(i)%><br>
            <% }%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%=udb.getTell()%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%></textarea><br><br>
            <!--直リンク防止のための非表示データを送る-->
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <!--送信ボタン付き-->
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=jh.home()%>
    </body>
    <!--不要な</body>が書いてあったので消した-->
</html>
