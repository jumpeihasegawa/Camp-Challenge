<%
//変数を宣言
int hensu = 3;

if(hensu == 1){
	//値が１なら「１です」と表示
	out.print("１です");
}else if(hensu == 2){
	//値が２なら「プログラミングキャンプ！」と表示
	out.print("プログラムキャンプ！");
}else{
	//それ以外なら「その他です！」
	out.print("その他です！");
}
%>