<%-- 
    Document   : 06
    Created on : 2017/10/18, 21:15:23
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>

<%
    ArrayList<String> data = new ArrayList<String>();
    
    data.add("10");
    data.add("100");
    data.add("soeda");
    data.add("hayashi");
    data.add("-20");
    data.add("118");
    data.add("END");
    
    data.set(2,"33");
    
    out.println(data.get(0));
    out.println(data.get(1));
    out.println(data.get(2));
    out.println(data.get(3));        
    out.println(data.get(4));
    out.println(data.get(5));        
    out.println(data.get(6));    

%>