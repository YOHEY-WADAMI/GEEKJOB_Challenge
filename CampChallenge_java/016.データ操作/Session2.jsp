<%-- 
    Document   : Session2
    Created on : 2017/11/20, 13:38:44
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
        <%
            //文字形式を設定
            request.setCharacterEncoding("UTF-8");
            
            
            out.print(request.getParameter("name") +"<br>");
            out.print(request.getParameter("sex") +"<br>");
            out.print(request.getParameter("hobby") );
            out.print("<br>"+"----------------------------------<br><br>");
            //sessionを取得
            HttpSession hs = request.getSession();
            //input情報をsessionに登録
            hs.setAttribute("name",request.getParameter("name"));
            hs.setAttribute("sex",request.getParameter("sex"));
            hs.setAttribute("hobby",request.getParameter("hobby"));

            String uName = (String)hs.getAttribute("name");
            String uSex = (String)hs.getAttribute("sex");
            String uHobby = (String)hs.getAttribute("hobby");
            
            //radioボタンの確認用
            String check1 ="";
            String check2 ="";
            
            if(hs.getAttribute("sex")!=null){
                if(hs.getAttribute("sex").equals("男")){
                    check1 = "checked";
                }else if(hs.getAttribute("sex").equals("女")){
                    check2 = "checked";
                }
            }

        %>
        <!--初期値の設定ができているかはブラウザ＞右クリック＞要素の検査＞デバッガーから確認できる！-->
        <!--同じjspページ内を遷移す る-->
        <!--玉城さんのコードを参考にした-->
        <form action="Session2.jsp" method="get">
            【名前】<br>
            <input type="text" name="name"
                   value=<% if(uName!=null){out.print(uName);}else{out.print("");}%>><br><br>
            【性別】<br>
            男<input type="radio" name="sex" value="男"<%=check1%>>
            女<input type="radio" name="sex" value="女"<%=check2%>><br><br>
            【趣味】<br>
            <textarea name="hobby" cols="50" rows="10"><%if(uHobby!=null){out.print(uHobby);}else{out.print("");}%></textarea><br><br>

            <input type="submit" value="送信">
            
        </form>
    </body>
</html>
