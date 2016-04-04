<%
//１０．クエリストリングを利用して、以下の処理を実現してください。
//簡易素因数分解のロジックを作成します。
//クエリストリングから渡された数値を1ケタの素数で可能な限り分解し、
//元の値と素因数分解の結果を表示するようにしてください。
//2ケタ以上の素数が含まれた数値の場合は、
//「元の値　1ケタの素因数　その他」と表記して、その他　に含んでください。

String param = request.getParameter("param");
out.print("元の値"+" "+param+" "+"素因数"+" ");

int atai = Integer.parseInt(param);

while(atai % 2 == 0){
	atai /= 2;
	out.print("2"+" ");
}
for(int i = 3;i <= 7 ; i += 2){
	while(atai % i == 0){
		out.print(i + " ");
		atai /= i;
	}
}
if(atai > 1){
	out.print("その他"+" "+atai);
}
%>