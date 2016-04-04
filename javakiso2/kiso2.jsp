<%
//２．switch文を利用して、以下の処理を実現してください。値が"A"なら「英語」、値が"あ"なら「日本語」、それ以外は何も表示しない処理

String atai = "い";
int bangou;

//文字列に番号を当てはめる
if(atai == "A"){
	bangou = 1;
}else if(atai == "あ"){
	bangou = 2;
}else{
	bangou = 3;
}

//番号別で表示を変える
String messege = "";

switch(bangou){
	case 1:
		messege = "英語";
		break;
	case 2:
		messege = "日本語";
		break;
	default:

		break;
}
out.print(messege);
%>