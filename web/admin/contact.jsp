<%-- 
    Document   : contact
    Created on : Jul 4, 2014, 1:00:19 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Contact</title>
        <link href="css/1style.css" rel="stylesheet" type="text/css"  media="all" />
        <link rel="stylesheet" href="css/style1.css" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
        <script src="js/open.windows.js"></script>
    </head>
    <body>
        <!---start-wrap---->
        <div class="wrap">
            <!---start-header---->
            <jsp:include page="templates/header.jsp"/>
            <div class="top-nav">
                <ul>
                    <li><a href="contact?id=1">Contact Manager</a></li>
                    <li><a href="contact?id=2">Commentator Manager</a></li>
                </ul>
            </div>
            <!---End-header---->
            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">
                <div class="section group">
                    <div class="col span_1_of_3" style="width: 30%; float: left">
                        <div class="company_address">
                            <h3><s:property value="c.company"/></h3>
                            <p><s:property value="c.address1"/></p>
                            <p><s:property value="c.address2"/></p>
                            <p><s:property value="c.contry"/></p>
                            <p>Phone:<s:property value="c.phone"/></p>
                            <p>Fax: <s:property value="c.fax"/></p>
                            <p>Email: <span><s:property value="c.email"/></span></p>
                        </div>
                    </div>
                    <div class="contact-form" style="width: 65%; float: left">
                        <s:if test="#session.contact!=null">
                            <jsp:include page="templates/about/contact.jsp"/>
                        </s:if><s:else>
                            <jsp:include page="templates/about/feeback.jsp"/>
                        </s:else>
                    </div>
                </div>
            </div>
            <!---End-content---->	
            <div class="clear"> </div>
            <jsp:include page="templates/footer.jsp"/>

        </div>
        <!---End-wrap---->
    </body>
</html>

<%
    session.removeAttribute("contact");
    session.removeAttribute("error");
%>