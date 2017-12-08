<%@page import="base.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    String msg = (String)request.getAttribute("msg");
    
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <%
        out.print(msg +"<br><br>");
    %>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=udb.getName()%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"> <%if(udb.getYear().equals(String.valueOf(i))){%> selected <%}%> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"> <%if(udb.getMonth().equals(String.valueOf(i))){%> selected <%}%> <%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"> <%if(udb.getDay().equals(String.valueOf(i))){%> selected <%}%> <%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%if(udb.getType().equals("1")){%> checked="checked" <%}%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%if(udb.getType().equals("2")){%> checked="checked" <%}%>>営業<br>
        <input type="radio" name="type" value="3" <%if(udb.getType().equals("3")){%> checked="checked" <%}%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udb.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= session.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
