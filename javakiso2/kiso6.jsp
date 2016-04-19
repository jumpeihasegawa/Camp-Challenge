<%
//６．while文を利用して、以下の処理を実現してください。1000を2で割り続け、100より小さくなったらループを抜ける処理

int atai = 1000;

while(atai < 100){
	atai = atai/2;
}
out.print(atai);
%>