<%-- 
    Document   : service
    Created on : Jun 10, 2014, 11:39:30 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <s:if test="#session.showService!=null">
            <title><s:property value="sv.name"/> </title>
        </s:if>
        <title>Services</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"  media="all" />
        <link href="css/css.css" rel="stylesheet" type="text/css"  media="all" />
        <link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src='http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
        <script src="js/incrementing.js"></script>
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
                <div class="services">
                    <div class="services">
                        <div class="service-content" >

                            <s:if test="#session.showServiceByDis!=null">
                                <h3>SERVICES</h3>
                                <ul>
                                    <s:iterator value="listSerByIdDis">
                                        <div class="grid_1_of_3 images_1_of_3">
                                            <div class="Project-gallery"><a href="servicesClient?idService=<s:property value="id"/>"><img width="100%" height="150"src="<s:property value="images"/>" alt=""></a></div>
                                            <p><s:property value="name"/></p>
                                            <div class="button"><span><a href="servicesClient?idService=<s:property value="id"/>"><s:property value="price"/>$</a></span></div>
                                        </div>
                                    </s:iterator>
                                </ul>

                            </s:if>
                            <s:if test="#session.showService!=null">
                                <h4><s:property value="sv.name"/></h4>
                                <div class="contents" >
                                    <div class="image" style="float: left"><img width="300" height="250"src="<s:property value="sv.images"/>"/></div>
                                    <form action="addCart" method="post">
                                        <div class="content-text" >

                                            <input style="display: none" type="text" name="id_user" value="<s:property value="#session.id"/>"/>
                                            <input style="display: none" type="text" name="id_service" value="<s:property value="sv.id"/>"/>
                                            <input style="display: none" type="text" name="name_service" value="<s:property value="sv.name"/>"/>
                                            <p class="ct"><s:property value="sv.content"/></p><input style="display: none" type="text" name="image_service" value="<s:property value="sv.images"/>"/>
                                            <p>Quatity : M2<div style="position: relative; top: 20px" class="numbers-row"><input style="position: relative; top: -3px" type="text" name="partridge" id="partridge" value="1"></div></p>
                                            </br></br></br><p>Price : <span><s:property value="sv.price"/>$</span></p><input style="display: none" type="text" name="price_service" value="<s:property value="sv.price"/>"/>
                                            <p>completed in : <span><s:property value="sv.day_completion"/></span> (hours)</p><input style="display: none" type="text" name="day_service" value="<s:property value="sv.day_completion"/>"/>
                                            <p><div class="images_1_of_3"><div style="position: relative; left: -7px; top: 8px" class="contact-form"><input type="submit" value="Buy"/></div></div><span style="color: red; font: 10px;"><s:property value="#session.cartError"/></span></p>

                                        </div>
                                    </form>
                                    <div class="descriptions"  ><div class="left-box1"><p><s:property value="sv.descriptions"/></p></div> </div>

                                </div>

                            </div>
                        </s:if>

                        <s:if test="#session.category!=null">
                            <h3>SERVICE</h3>
                            <ul>
                                <s:iterator value="lisSvCa">
                                    <div class="grid_1_of_3 images_1_of_3">
                                        <div class="Project-gallery"><a href="<s:property value="images"/>"><img width="100%" height="170"src="<s:property value="images"/>" alt=""></a></div>
                                        <p><s:property value="name"/></p>
                                        <div class="button"><span><a href="servicesClient?idService=<s:property value="id"/>"><s:property value="price"/>$</a></span></div>
                                    </div>
                                </s:iterator>
                            </ul>
                        </s:if>
                    </div>
                    <div class="services-sidebar">
                        <h3>CATEGORY</h3>
                        <ul>
                            <ul>
                                <s:iterator value="listCateForDis">
                                    <li><a href="category?ID=<s:property value="id"/>"><s:property value="name"/></a></li>
                                    </s:iterator>
                            </ul>      
                        </ul>

                    </div>

                    <div class="clear"> </div>
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
    session.removeAttribute("allService");
    session.removeAttribute("showService");
    session.removeAttribute("show");
    session.removeAttribute("category");
    session.removeAttribute("showServiceByDis");
    session.removeAttribute("cartError");
%>