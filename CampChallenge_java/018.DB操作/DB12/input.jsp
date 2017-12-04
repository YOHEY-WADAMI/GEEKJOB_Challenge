<%-- 
    Document   : Search
    Created on : 2017/11/30, 10:23:35
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
        <form action="../Search_1" method="POST">
            <center>
                <br><br><br><br><br><br><br><br>
                検索したい情報の「名前・年齢・誕生日」を入力してください<br><br>    
                
                名前【例：山田太郎】<br><input type="text" name="name"><br><br>
                年齢【例：30】<br><input type="text" name="age" size="10"><br><br>
                誕生日【例：2000/12/24なら20001224と入力してください】
                <br><input type="text" name="birthday"><br><br>
                
                <input type="submit" name="btnSubmit" value="検索する">
                <input type="reset" name="reset" value="リセット">
            </center>
        </form>
    </body>
</html>
