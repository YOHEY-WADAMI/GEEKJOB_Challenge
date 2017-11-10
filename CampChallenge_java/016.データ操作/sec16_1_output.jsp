<%-- 
    Document   : _16_1_2
    Created on : 2017/11/10, 13:45:00
    Author     : guest1Day
--%>

<!--以下の機能を実装してください。
「入力フィールド」の課題で作成したHTMLの入力データを取得し、画面に表示する-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
// 文字コード指定
            request.setCharacterEncoding("UTF-8");
            // 情報の取り出しと表示
            out.print("【氏名】" + request.getParameter("name") + "<br>");
            out.print("【性別】" + request.getParameter("gender") + "<br>");
            out.print("【趣味】" + request.getParameter("hobby"));
%>