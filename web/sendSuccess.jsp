<%-- 
    Document   : contact
    Created on : Jun 8, 2014, 8:52:15 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:property value="c.title"/></title>
     </head>
<%
    if(session.getAttribute("userName")==null){
        response.sendRedirect("home");
    }
%>
    <body>
        <!---start-wrap---->
        <div class="wrap">
            <!---start-header---->
            <jsp:include page="templates/header.jsp"/>
            <!---End-header---->
            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">
                <h4>Contact</h4>
                <div class="section group">				
                    <div class="col span_1_of_3">
                        <div class="company_address">
                            <h3><s:property value="c.company"/></h3>
                            <p><s:property value="c.address1"/>,</p>
                            <p><s:property value="c.address2"/></p>
                            <p><s:property value="c.contry"/></p>
                            <p>Phone:<s:property value="c.phone"/></p>
                            <p>Fax: <s:property value="c.fax"/></p>
                            <p>Email: <span><s:property value="c.email"/></span></p>
                            <p>-----------------------------------</p>
                            <p>Mondays to Fridays </p>
                            <p><s:property value="c.timeIn1"/> : <s:property value="c.timeOut1"/></p>
                            <p>Saturdays </p>
                            <p><s:property value="c.timeIn2"/> : <s:property value="c.timeOut2"/></p>
                        </div>
                    </div>				
                    <div class="col span_2_of_3">
                        <div class="contact-form">
                            <h3>We will contact you at the time of the most recent. Thank you for contacting us</h3>
                            
                        </div>
                    </div>				
                </div>
            </div>
            <!---End-content---->	
            <jsp:include page="templates/footer.jsp"/>
        </div>
        <!---End-wrap---->
    </body>
</html>
<% session.removeAttribute("success"); %>