<%
//クエスリストリングのパラメーターを作る
String zakka = request.getParameter("zakka");
String seisen = request.getParameter("seisen");
String sonota = request.getParameter("sonota");

//String型からint型に変化(商品の個数）
int zakkakosuu = Integer.parseInt(zakka);
int seisenkosuu = Integer.parseInt(seisen);
int sonotakosuu = Integer.parseInt(sonota);

//商品の合計の個数
int kosuugoukei = zakkakosuu+seisenkosuu+sonotakosuu;

//商品の値段
int zakkanedan = 650;
int seisennedan = 298;
int sonotanedan = 300;

//商品の小計
int zakkashoukei = zakkakosuu*zakkanedan;
int seisenshoukei = seisenkosuu*seisennedan;
int sonotashoukei = sonotakosuu*sonotanedan;

//総額
int sougaku = zakkashoukei+seisenshoukei+sonotashoukei;

//パラメーターの値によって表示を変化させる
if(zakka == null){
	
}else{
	out.print("雑貨　"+zakkanedan+"円　"+zakka+"点　"+zakkashoukei+"円"+"<br>");
}
if(seisen == null){
	
}else{
	out.print("生鮮食品　"+seisennedan+"円　"+seisen+"点　"+seisenshoukei+"円"+"<br>");
}
if(sonota == null){
	
}else{
	out.print("その他　"+sonotanedan+"円　"+sonota+"点　"+sonotashoukei+"円"+"<br><br>");
}

//総額を表示
out.print("合計　"+kosuugoukei+"個　"+sougaku+"円"+"<br>");

//ポイントを金額に応じて表示
if(sougaku >= 5000){
	out.print("5000円以上お買い上げなのでポイント5％付与");
}else if(sougaku >= 3000){
	out.print("3000円以上お買い上げなのでポイント4％付与");
}else{
}
%>