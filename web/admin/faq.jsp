<%-- 
    Document   : services
    Created on : Jul 4, 2014, 12:59:53 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Faq's</title>
		<link href="css/1style.css" rel="stylesheet" type="text/css"  media="all" />
                <link rel="stylesheet" href="css/style1.css" type="text/css">
		<link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="js/responsiveslides.min.js"></script>
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 1600,
			        speed: 600
			      });
			});
		  </script>
	</head>
	<body>
	<!---start-wrap---->
	<div class="wrap">
		<!---start-header---->
		            <jsp:include page="templates/header.jsp"/>
                            <div class="top-nav">
                                <ul>
                                    <li><a href="addFaq?id=1">Add Faq's</a></li>
                                    <li><a href="addNews?id=2">Add News</a></li>
                                </ul>
                            </div>
		<!---End-header---->
		<!--start-image-slider---->
			
		<!--End-image-slider---->
	<div class="clear"> </div>	
	<!---start-content---->	
	<div class="content">
		<div class="services">
			<div class="services">
						<div class="service-content">
                                                    <s:if test="#session.addFaq!=null">
                                                        <h3>Add Faq's</h3>
                                                        <form action="addFaq" method="post">
                                                        <table class="zebra">
                                                            <tr>
                                                                <td>Question</td>
                                                                <td><input name="question" type="text"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Respones</td>
                                                                <td><textarea name="response" style="width: 50%;height: 100px"></textarea></td>
                                                                
                                                            </tr>
                                                            
                                                            <tr>
                                                                <td colspan="2"><input style="display: none" name="addFaq" type="text" value="1"/><input type="submit" value="Add FAQ"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2"><s:property value="#session.errorFaq"/></td>
                                                            </tr>
                                                            
                                                        </table>
                                                            </form>
                                                    </s:if><s:elseif test="#session.addNews!=null">
                                                        <h3>Add News</h3>
                                                        <form action="addFaq" method="post">
                                                        <table class="zebra">
                                                            <tr>
                                                                <td>Name</td>
                                                                <td><input name="name" type="text"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td>Description</td>
                                                                <td><textarea name="desc"  style="width: 50%; height: 100px"></textarea></td>
                                                            </tr>
                                                            
                                                            <tr>
                                                                <td colspan="2"><input style="display: none" name="addNew" type="text" value="1"/><input type="submit" value="Add News"/></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="2"><s:property value="#session.errorEmpty"/></td>
                                                            </tr>
                                                            
                                                        </table>
                                                            </form>
                                                    </s:elseif><s:else>
							<h3>List FAQ's</h3>
                                                        <s:iterator value="ls">
							<ul>
                                                            <li><span><s:property value="id"/></span></li>
                                                            <li><p><a href="#"><s:property value="question"/></a><s:property value="respones"/></p></li>
								<div class="clear"> </div>
							</ul>
                                                        </s:iterator>
                                                        </s:else>
						</div>
						<div class="services-sidebar">
							<h3>List News</h3>
                                                        <s:iterator value="list">
							 <ul>
                                                             <li><a href="itempNews?id=<s:property value="id"/>"><s:property value="currentDate"/></a></li>
					 		 </ul>
                                                         </s:iterator>
						</div>
						<div class="clear"> </div>
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
    session.removeAttribute("errorEmpty");
    session.removeAttribute("errorFaq");
%>