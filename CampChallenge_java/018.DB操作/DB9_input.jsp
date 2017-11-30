<%-- 
    Document   : DB9
    Created on : 2017/11/24, 18:23:15
    Author     : guest1Day
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../DB9" method="post">
            データベースに情報を追加します！<br>
            下記の項目を入力してください。<br><br>
            【ID】<input type="text" name="id"><br>
            【名前】<input type="text" name="name"><br>
            【電話番号】<input type="text" name="tel"><br>
            【年齢】<input type="text" name="age"><br>
            【誕生日】<input type="text" name="birth"><br>

            <input type="submit" value="送信">
            <input type="reset" value="リセット">
        </form>
    </body>
</html>
