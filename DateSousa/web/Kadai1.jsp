<%-- 
    Document   : Kadai1jsp
    Created on : 2016/04/25, 13:36:11
    Author     : Jumpei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>課題１</title>
    </head>
    <body>
        
        <!--１．以下の入力フィールドを持ったHTMLを、Javaで処理する想定で記述してください。
　　　・名前（テキストボックス）、性別（ラジオボタン）、趣味（複数行テキストボックス）-->

        <form action="Kadai2Servlet" method="post">
            名前：<input type="text" name="txtNamae">
            性別：　男<input type="radio" name="rdoSeibetu" value="男">　
                    女<input type="radio" name="rdoSeibetu" value="女">
            趣味：<textarea name="mulShumi"></textarea>
            <input type="submit" value="送信">
        </form>
    </body>
</html>