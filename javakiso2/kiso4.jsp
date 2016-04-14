<%
//４．for文を利用して、"A"を30個連結する処理を実現してください。

String[] moji = new String[30];
for(int i = 0;i < 30;i++){
	moji[i] = "A";
}
for(int i = 0;i < 30;i++){
	out.print(moji[i]);

}
%>