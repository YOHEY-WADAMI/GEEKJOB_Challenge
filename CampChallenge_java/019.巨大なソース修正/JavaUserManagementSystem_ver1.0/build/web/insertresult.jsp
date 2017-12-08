<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= request.getAttribute("name")%><br>
        生年月日:<%= request.getAttribute("year") + "年" + request.getAttribute("month") + "月" + request.getAttribute("day") + "日"%><br>
        種別:<%= request.getAttribute("type")%><br>
        電話番号:<%= request.getAttribute("tell")%><br>
        自己紹介:<%= request.getAttribute("comment")%><br>
        以上の内容で登録しました。<br>
        

    </body>
    <p><%=JumsHelper.getInstance().home()%></p>
</html>
