<%-- 
    Document   : challenge 6
    Created on : 2017/10/18, 19:54:12
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    int type;
    type = 7;
    
    switch(type){
        case 1:
            out.print("one");
            break;
        case 2:
            out.print("two");
            break;
        default:
            out.print("想定外");
            break;            
    }          
%>
