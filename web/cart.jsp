<%-- 
    Document   : index
    Created on : Jun 9, 2014, 5:32:29 PM
    Author     : Windows
--%>
<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect("loging");
    }
 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FAQ's</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script>
            // You can also use "$(window).load(function() {"
            $(function() {

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
            <!---End-header---->
            <!--start-image-slider---->
            <div class="image-slider">
                <!-- Slideshow 1 -->

                <!-- Slideshow 2 -->
            </div>
            <!--End-image-slider---->
            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">
                <div class="grids">

                </div>
                <div class="clear"> </div>
                <div class="box">
                    <div class="left-box">

                        <div id="container">   
                            <table class="zebra">
                                <tr>
                                    <td style="width: 20%">Image</td>
                                    <td style="width: 75%">Name</td>
                                    <td style="width: 5%">Price</td>
                                    <td style="width: 5%">Completed</td>
                                    <td style="width: 3%">Action</td>
                                </tr>
                                <s:if test="lisCart.size()>0">
                                    <s:iterator value="lisCart">
                                        <tr>
                                            <td><img width="100" height="100" src="<s:property value="image_service"/>"></td>
                                            <td><a href="servicesClient?idService=<s:property value="id_service"/>"><s:property value="name_service"/></a></td>
                                            <td><s:if test="quatity==0"><s:property value="price_service"/>$</s:if><s:else><s:property value="quatity"/> x <s:property value="price_service/quatity"/>$</s:else></td>
                                            <td><s:if test="quatity==0"><s:property value="day_service"/>(hours)</s:if><s:else><s:property value="quatity"/> x <s:property value="day_service/quatity"/>(hours)</s:else></td>
                                            <td><a  href="delService?ID=<s:property value="id"/>">delete</a></td>
                                        </tr>
                                    </s:iterator>
                                </s:if><s:else>
                                    <tr  style="height: 50px"><td colspan="5">Cart Empty</td></tr>
                                </s:else>
                                <tr style="height: 50px">
                                    <td colspan="2" style="text-align: right">Total :  </td>
                                    <td><s:property value="total"/>$</td>
                                    <td colspan="2">completed in <s:property value="totalDay"/>(hours)</td>

                                </tr>
                                <tr>

                                    <td style="text-align: right" colspan="5" class="contact-form"><form action="delCart" method="post"><input style="display: none" type="text" name="procc" value="1"/> <s:if test="lisCart.size()>0"><input type="submit" value="Continue"/></s:if></form></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                                    <div class="right-box">
				<h3>Service News</h3>
                                <s:iterator value="listTop5Service">
				<div class="right-box-grid">
					<div class="right-box-grid-img">
                                            <a href="servicesClient?idService=<s:property value="id"/>"><img height="80" width="80" src="<s:property value="images"/>" title="img"></a>
					</div>
					<div class="right-box-grid-info">
						<span>Price : <s:property value="price"/>$</span></br>
						<span>completed in : <s:property value="day_completion"/>(hours)</span>
						<p><s:property value="name"/></p>
					</div>
					<div class="clear"> </div>
				</div>
                                </s:iterator>
			</div>
                    <div class="clear"> </div>
                </div>
            </div>
            <!---End-content---->	
        <jsp:include page="templates/footer.jsp"/>
    </div>
    <!---End-wrap---->
</body>
</html>

<%
    session.removeAttribute("procc");
    session.removeAttribute("cart");
    session.removeAttribute("error");
    session.removeAttribute("error1");
    session.removeAttribute("proccess");
 
%>