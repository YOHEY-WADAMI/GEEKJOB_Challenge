<%-- 
    Document   : challenge 6
    Created on : 2017/10/18, 19:54:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    int type;
    type = 10;
    
    switch(type){
        case 10:
            out.print(" サッカー");
            break;
        case 20:
            out.print("野球");
            break;
        case 30:
            out.print("ラグビー");
            break;            
    }          
%>
