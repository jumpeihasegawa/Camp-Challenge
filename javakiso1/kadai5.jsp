<%
//定数と変数を宣言
int hensu = 10;
final int teisu = 2;

//四則演算する
//足し算
int tasizan = hensu + teisu;
//引き算
int hikizan = hensu - teisu;
//掛け算
int kakezan = hensu * teisu;
//割り算
int warizan = hensu / teisu;

//四則演算を出力
//足し算
out.print("10+2=");
out.print(tasizan + "<br>");
//引き算
out.print("10-2=");
out.print(hikizan + "<br>");
//掛け算
out.print("10×2=");
out.print(kakezan + "<br>");
//割り算
out.print("10÷2=");
out.print(warizan + "<br>");
%>