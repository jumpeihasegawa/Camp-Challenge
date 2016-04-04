<%
//８．７で作成した配列の"soeda"を"33"に変更してください。

String a[] = {"10","100","soeda","hayasi","-20","118"};

for(int i = 0;i < a.length;i++){
out.print(a[i]+" ");
}

a[2] = "33";
out.print("<br>");
for(int i = 0;i < a.length;i++){
out.print(a[i]+" ");
}

%>