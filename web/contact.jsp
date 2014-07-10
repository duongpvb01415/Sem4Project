<%-- 
    Document   : contact
    Created on : Jun 8, 2014, 8:52:15 AM
    Author     : Windows
--%>
<%
    if(session.getAttribute("contact")==null){
        response.sendRedirect("contact");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:property value="c.title"/></title>		
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="js/responsiveslides.min.js"></script>
    </head>
    <body>
        <!---start-wrap---->
        <div class="wrap">
            <!---start-header---->
            <jsp:include page="templates/header.jsp"/>
            <!---End-header---->
            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">
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
                            <h3>Contact Us</h3>
                            <form action="send">
                                <s:if test="#session.email==null">
                                <div>
                                    <span><label>NAME*</label></span>
                                    <span><input name="userName" type="text" class="textbox"></span>
                                </div>
                                <div>
                                    <span><label>E-MAIL*</label></span>
                                    <span><input name="email" type="text" class="textbox"></span>
                                </div>
                                </s:if><s:else>
                                    <div style="display: none">
                                    <span><label>NAME*</label></span>
                                    <span><input name="userName" type="text" value="<s:property value="#session.name"/>" class="textbox"></span>
                                </div>
                                <div style="display: none">
                                    <span><label>E-MAIL*</label></span>
                                    <span><input name="email" type="text" value="<s:property value="#session.email"/>" class="textbox"></span>
                                </div>
                                </s:else>
                                <div>
                                    <span><label>MOBILE*</label></span>
                                    <span><input name="userPhone" type="text" class="textbox"></span>
                                </div>
                                <div>
                                    <span><label>SUBJECT*</label></span>
                                    <span><textarea name="body"> </textarea></span>
                                </div>
                                <div>
                                    <span><label style="color: red"><s:property value="#session.sendError" /></label></span>
                                    
                                </div>
                                <div>
                                    <span><input type="submit" value="Submit"></span>
                                </div>
                            </form>
                            
                    </div>				
                </div>
            </div>
            <!---End-content---->	
            <jsp:include page="templates/footer.jsp"/>
        </div>
        <!---End-wrap---->
    </body>
</html>
<% 
    session.removeAttribute("sendError"); 
    session.removeAttribute("contact"); 

%>