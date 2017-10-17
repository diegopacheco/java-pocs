<%--
  Created by IntelliJ IDEA.
  User: diego
  Date: 12/26/2014
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.github.diegopacheco.sandbox.java.spring.wildfly.services.DateService"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<html>
<head>
    <title>Spring 4.13 + JBoss Wildfly 8.20 </title>
</head>
<body>
<%
    ApplicationContext context =  WebApplicationContextUtils.getWebApplicationContext(
                                    getServletConfig().getServletContext());
    DateService ds = (DateService)context.getBean("simpleDateService");
%>
<%= ds.currentTime() %>
</body>
</html>
