<%-- 
    Document   : 07-sample
    Created on : 2017/10/19, 18:45:42
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%
    HashMap<String , String> key = new HashMap<String , String>();
    
key.put("1" , "AAA");
key.put("hello" , "world");
key.put("soeda" , "33");
key.put("20" , "20");

out.print("1:" + key.get("1") + "<br>");
out.print("hello:" + key.get("hello") +"<br>");
out.print("soeda:" + key.get("soeda") +"<br>");
out.print("20:" + key.get("20") +"<br>");

%>