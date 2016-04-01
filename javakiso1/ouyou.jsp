<%
//商品の種類
String shouhin = request.getParameter("shouhin");

//String型からint型に変化
int shouhin2 = Integer.parseInt(shouhin);

//商品の種類を選別
if(shouhin2 == 1){
	out.print("雑貨");
}else if(shouhin2 == 2){
	out.print("生鮮食品");
}else if(shouhin2 == 3){
	out.print("その他");
}else{

}

//商品の個数
String kosuu = request.getParameter("kosuu");

//String型からint型に変化
int kosuu2 = Integer.parseInt(kosuu);

//商品の総額
String sougaku = request.getParameter("sougaku");

//String型からint型に変化
int sougaku2 = Integer.parseInt(sougaku);

//商品1点の値段
int itten = sougaku2/kosuu2;

out.print(itten+"円"+kosuu+"点"+"総額"+sougaku+"円"+"<br>");

//ポイントを金額に応じて表示
if(sougaku2 >= 5000){
	out.print(sougaku2+"円お買い上げなのでポイント"+sougaku2*0.05+"％付与");
}else if(sougaku2 >= 3000){
	out.print(sougaku2+"円以上お買い上げなのでポイント"+sougaku2*0.04+"％付与");
}else{
}
%>