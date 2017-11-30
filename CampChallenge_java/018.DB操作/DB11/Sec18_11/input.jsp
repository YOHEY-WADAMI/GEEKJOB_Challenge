<%-- 
    Document   : DB11_input
    Created on : 2017/11/29, 16:49:08
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
        <form action="../Search" method="POST">
            【情報を更新したいIDを入力してください】<br><br>
            【ID】<input type="text" name="profilesid"><br>
            -------------------------------------<br><br>
            
            
            <input type="submit" value="送信する">
            <input type="reset" value="リセットする">
        </form>
    </body>
</html>
