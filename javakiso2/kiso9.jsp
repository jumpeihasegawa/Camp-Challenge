<%@ page import="java.util.HashMap"%>
<%
//９．以下の順で、連想配列を作成してください。"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"

HashMap<String,String>hMap =
	new HashMap<String,String>();

hMap.put("1","AAA");
hMap.put("hello","world");
hMap.put("soeda","33");
hMap.put("20","20");

out.print(hMap.get("1")+(" "));
out.print(hMap.get("hello")+(" "));
out.print(hMap.get("soeda")+(" "));
out.print(hMap.get("20")+(" "));
%>