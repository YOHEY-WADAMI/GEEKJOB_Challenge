<%-- 
    Document   : Login
    Created on : 2017/12/01, 11:54:47
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
        <form action="./Login.jsp" method="post">
            <center><br><br><br><br><br>
                <h1>ログインはこちら</h1><br><br>
                【名前】<input type="text" name="Name"><br><br>
                
                【パスワード】<input type="text" name="Pass"><br><br>
                
                <input type="submit" name="Login" value="ログイン">
                <input type="reset" value="キャンセル">
            </center>
        </form>
        <%
            
            Connection dbCon = null;
            PreparedStatement dbSt = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db", "root", "");
                
                String sql = "SELECT * FROM userdata WHERE name = ?";
                dbSt = dbCon.prepareStatement(sql);
                
                request.setCharacterEncoding("UTF-8");
                dbSt.setString(1,request.getParameter("Name"));
                ResultSet dbData = dbSt.executeQuery();
                
                while(dbData.next()){
                    if(request.getParameter("Name").equals(dbData.getString("name")) && request.getParameter("Pass").equals(dbData.getString("password"))){
                    System.out.println("ログインに成功しました");
                    response.sendRedirect("./AfterLogin.jsp");
                    }else {
                        System.out.println("ログインに失敗しました");
                        response.sendRedirect("./Login.jsp");
                    }
                }
                
                dbSt.close();
                dbData.close();
                
            }catch (SQLException e_sql){
                out.println("接続時にエラーが発生しました:" + e_sql.toString());
                    }catch (Exception e){
                        out.println("接続時にエラーが発生しました:" + e.toString());
                    }finally{
                        if (dbCon != null){
                            try {
                                dbCon.close();
                                } catch (Exception e_con) {
                                    System.out.println(e_con.getMessage());
                                }
                        }
                }
        %>
    </body>
</html>
