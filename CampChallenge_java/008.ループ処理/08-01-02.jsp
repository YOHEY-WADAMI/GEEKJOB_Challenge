<%-- 
    Document   : 08-01-02
    Created on : 2017/10/19, 20:43:51
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String Box = "";
    
    for(int i=0 ; i<30 ; i++){
        Box = Box + "A";
    }
    out.print(Box);
    
%>