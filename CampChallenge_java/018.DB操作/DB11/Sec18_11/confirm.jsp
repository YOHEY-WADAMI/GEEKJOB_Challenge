<%-- 
    Document   : comfirm
    Created on : 2017/11/29, 17:55:46
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String record = (String) request.getAttribute("record");
    out.println("変更前のレコードは下記のとおりです。" +"<br>");
    out.println(record);
    out.println("------------------------------------------" +"<br><br>");
%>

<%
    String Number = (String)request.getAttribute("id");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Update" method="POST">
            <input type="hidden" name="profilesid" value="<%= Number%>">
            【変更したい情報を入力してください】<br>
            【NAME】<input type="text" name="name"><br>
            【TEL】<input type="text" name="tel"><br>
            【年齢】<input type="text" name="age"><br>
            【誕生日】<input type="text" name="birthday"><br><br>
            
            <input type="submit" value="送信します">
            <input type="reset" value="リセット">
        </form>
    </body>
</html>
