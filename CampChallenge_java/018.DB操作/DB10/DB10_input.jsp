<%-- 
    Document   : DB10_input
    Created on : 2017/11/29, 14:58:30
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
        <form action="../DB10" method="get">
            入力したIDのレコードを削除します。<br>
            【ID】<input type="text" name="profilesid"><br>
            <input type="submit" value="送信">
            <input type="reset" value="リセット">
            
        </form>            
    </body>
</html>
