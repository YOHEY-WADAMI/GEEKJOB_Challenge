<%-- 
    Document   : 08-01-03
    Created on : 2017/10/19, 20:50:56
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%   
    int j=0;
    
    for(int i=1; i<=100; i++){
        j= j+i;
    }out.print("0~100まですべて足した解＝" + j);
%>