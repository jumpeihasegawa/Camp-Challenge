<%-- 
    Document   : Ouyou5jsp
    Created on : 2016/04/27, 9:53:18
    Author     : Jumpei
--%>

<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Cookie cs[] = request.getCookies();
    String namae = "";
    String otoko = "";
    String onna = "";
    String shumi = "";
    if (cs != null) {
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].getName().equals("namae")) {
                namae = cs[i].getValue();
                namae = URLDecoder.decode(namae, "UTF-8");
                break;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].getName().equals("shumi")) {
                shumi = cs[i].getValue();
                shumi = URLDecoder.decode(shumi, "UTF-8");
                break;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].getName().equals("seibetu")) {
                if ("男".equals(URLDecoder.decode(cs[i].getValue(), "UTF-8"))) {
                    otoko = "checked";
                    break;
                } else if ("女".equals(URLDecoder.decode(cs[i].getValue(), "UTF-8"))) {
                    onna = "checked";
                    break;
                }

            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>標準クラスの課題の応用５</title>
    </head>
    <body>
        <form action="Ouyou5Servlet" method="post">            
            名前：<input type="text" name="txtNamae" value="<%out.print(namae);%>">
            性別：　男<input type="radio" name="rdoSeibetu" value="男" <%out.print(otoko);%>>
            女<input type="radio" name="rdoSeibetu" value="女" <%out.print(onna);%>>
            趣味：<textarea name="mulShumi"><%out.print(shumi);%></textarea>
            <input type="submit" value="送信">
        </form>
    </body>
</html>
