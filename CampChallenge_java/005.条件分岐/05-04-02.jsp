<%-- 
    Document   : 05-04-02
    Created on : 2017/10/18, 21:03:25
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    char name ;
    name = 'あ';
    
    switch(name){
        case 'A':
            out.print("英語");
            break;
        case 'あ':
            out.print("日本語");
            break;
        }
%>
