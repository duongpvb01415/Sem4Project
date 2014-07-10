<%-- 
    Document   : test
    Created on : Jul 9, 2014, 6:32:54 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <s:set var="total" value="%{0}" />
<s:iterator value="myValues">
     <s:set var="total" value="%{top + #attr.total}" />
</s:iterator> 
<s:property value="%{'' + #attr.total}" /> 
    </body>
</html>
