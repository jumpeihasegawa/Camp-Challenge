<%
//１．switch文を利用して、以下の処理を実現してください。値が1なら「one」、値が2なら「two」、それ以外は「想定外」と表示する処理

int atai = 3;
String message = "";

switch(atai){
	case 1:
		message = "one";
		break;
	case 2:
		message = "two";
		break;
	default:
		message = "想定外";
		break;
}
out.print(message);
%>

