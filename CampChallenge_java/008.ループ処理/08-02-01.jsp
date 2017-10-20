<%-- 
    Document   : 08-02-01
    Created on : 2017/10/19, 21:39:40
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
//while文を利用して、以下の処理を実現してください。
//1000を2で割り続け、100より小さくなったらループを抜ける処理
    int i = 1000; 
    int count =0;
    
    while(i>100){
        out.println(i);
        i = i/2;
        count++;
        
        
    }out.print("<br>"+count + "回ループした");
           
%>