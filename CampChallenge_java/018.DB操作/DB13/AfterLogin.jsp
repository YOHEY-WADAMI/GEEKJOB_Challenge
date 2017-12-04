<%-- 
    Document   : After_login
    Created on : 2017/12/01, 11:57:25
    Author     : guest1Day
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href = "./Login.jsp" title = "ログアウト">ログアウト</a>
        <form action = "./AfterLogin.jsp" method = "post">
            商品名：<input type = "text" name = "Name"><br>
            値段：<input type = "text" name = "Price"><br>
            <button type = "submit" name = "btnSubmit" value = "登録">登録</button><br>
            <button type = "submit" name = "btnSubmit" value = "一覧">商品一覧</button><br>
        </form>
        <%  Connection dbCon = null;
            PreparedStatement dbSt = null;
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "");
                request.setCharacterEncoding("UTF-8");
                String sql = null;

                if (request.getParameter("btnSubmit").equals("登録")) {
                    sql = "INSERT INTO ProductData() VALUES(?,?);";
                    dbSt = dbCon.prepareStatement(sql);
                    String name = request.getParameter("Name");
                    int price = Integer.parseInt(request.getParameter("Price"));
                    dbSt.setString(1, name);
                    dbSt.setInt(2, price);
                    int num = dbSt.executeUpdate();
                    if (num != 0) {
                        out.println("登録しました");
                    }
                } else if (request.getParameter("btnSubmit").equals("一覧")) {
                    sql = "SELECT * FROM ProductData";
                    dbSt = dbCon.prepareStatement(sql);
                    ResultSet dbData = dbSt.executeQuery();
                    while (dbData.next()) {
                        out.println(dbData.getString("name") + " ");
                        out.println(dbData.getString("price") + "円<br>");
                    }
                    dbSt.close();
                    dbData.close();

                }
                dbSt.close();
            } catch (SQLException e_sql) {
                out.println("接続時にエラーが発生しました:" + e_sql.toString());
            } catch (Exception e) {
                out.println("接続時にエラーが発生しました:" + e.toString());
            } finally {
                if (dbCon != null) {
                    try {
                        dbCon.close();
                    } catch (Exception e_con) {
                        out.println(e_con.getMessage());
                    }
                }
            }
        %>
    </body>
</html>
