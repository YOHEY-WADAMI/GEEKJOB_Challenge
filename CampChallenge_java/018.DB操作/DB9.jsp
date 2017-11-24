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
<%
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    int str1 = 0;
    int str4 = 0;
    try {
        request.setCharacterEncoding("UTF-8");
        str1 = Integer.parseInt(request.getParameter("id"));
        String str2 = request.getParameter("name");
        String str3 = request.getParameter("tel");
        str4 = Integer.parseInt(request.getParameter("age"));
        String str5 = request.getParameter("birth");

        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

        ps = con.prepareStatement("insert into profiles values(?,?,?,?,?)");
        ps.setInt(1, str1);
        ps.setString(2, str2);
        ps.setString(3, str3);
        ps.setInt(4, str4);
        ps.setString(5, str5);
        ps.executeUpdate();

        
    } catch (Exception e) {
        out.print("エラーが発生しました。" + e.toString() + "<br>");
    } finally {
        if (con != null) {
            try {
                con.close();
                out.println("コネクション切断に成功しました。" + "<br><br>");
            } catch (Exception e) {
                out.println("コネクションはありません。" + "<br><br>");
                out.print(e.getMessage());
            }
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="DB9.jsp" method="post">
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
