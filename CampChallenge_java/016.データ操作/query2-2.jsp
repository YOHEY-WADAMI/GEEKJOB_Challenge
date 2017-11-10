<%-- 
    Document   : query2-2
    Created on : 2017/11/10, 16:52:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            int num = Integer.parseInt(request.getParameter("number"));
            
            //素因数分解の処理
            //渡された数値（num）を表示
            out.print("入力された数値は" + num + "です。<br>");
            
            //素数は１，２，３，５，７のみ
            // 1に対する素数は1である
            if (num == 1) {
                out.print(num + "の場合、結果は" + num + "になります。");
            }
            // numが1より大きいうちは繰り返す
            while (num > 1) {
                // numを2で割って、「あまり」が「0と等しい」を満たすなら「2」と表示
                // numが50の場合、50÷2＝25で「あまり0」満たすので「2」を表示
                
                if (num % 2 == 0) {
                    out.print("　2　");
                    num = num / 2;
                } else if (num % 3 == 0) {
                    out.print("　3　");
                    num = num / 3;
                } else if (num % 5 == 0) {
                    out.print("　5　");
                    num = num / 5;
                } else if (num % 7 == 0) {
                    out.print("　7　");
                    num = num / 7;
                } else {
                    out.print("余りは" + num + "です。");
                    break;
                }
            }

        %>
    </body>
</html>
