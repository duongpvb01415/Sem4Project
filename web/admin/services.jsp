<%-- 
    Document   : services
    Created on : Jul 4, 2014, 12:59:53 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Deluxe Website Template | Services :: W3layouts</title>
        <link href="css/1style.css" rel="stylesheet" type="text/css"  media="all" />
        <link rel="stylesheet" href="css/style1.css" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Karla' rel='stylesheet' type='text/css'>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="js/responsiveslides.min.js"></script>
        <script src="js/open.windows.js"></script>
        <script>
                    // You can also use "$(window).load(function() {"
                    $(function () {

                    // Slideshow 1
                    $("#slider1").responsiveSlides({
                    maxwidth: 1600,
                            speed: 600
                    });
                    });        </script>
    </head>
    <body>
        <!---start-wrap---->
        <div class="wrap">
            <!---start-header---->
            <jsp:include page="templates/header.jsp"/>
            <div class="top-nav">
                <ul>
                    <li><a href="javascript: void(0);" onclick=" javascript:OpenPopup('addDistrict?pub=1', 'WindowName', '250', '140', 'scrollbars=1');">Add District</a></li>
                    <li><a href="javascript: void(0);" onclick=" javascript:OpenPopup('addDistrict?pub=2', 'WindowName', '250', '140', 'scrollbars=1');">Add Category</a></li>
                    <li><a href="addService?pub=3">Add Service</a></li>
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
                            <s:if test="#session.addService!=null">
                                <jsp:include page="templates/service/addservices.jsp"/>
                            </s:if><s:else>
                                <jsp:include page="templates/service/servicelist.jsp"/>
                            </s:else>
                        </div>
                        <div class="services-sidebar">
                            <h3>DISTRICT</h3>
                            <ul>
                                <s:iterator value="listDisTrict">
                                    <li><a style="display: block; float: left" href="services?showId=<s:property value="id"/>" /><s:property value="name"/></a><a style="color: red; display: block; float: left" href="deleteDis?idDistrict=<s:property value="id"/>"> <img src="images/delete_icon.gif" alt=""/></a> <a style="color: chartreuse" href="javascript: void(0);" onclick=" javascript:OpenPopup('addDistrict?id=<s:property value="id" />', 'WindowName', '250', '140', 'scrollbars=1');"><img src="images/editIcon.gif" alt=""/></a>
                                    
                                    </li>
                                </s:iterator>
                            </ul>
                            </br>
                            <ul>
                                <s:iterator value="listCategory">
                                    <li style="background: none"><a  style="display: block; float: left; " href="services?id=<s:property value="id" />"><s:property value="name" /></a><a  style="color: red; display: block; float: left" href="deleteCategory?idCategory=<s:property value="id" />"> <img src="images/delete_icon.gif" alt=""/></a><a style="color: chartreuse" href="javascript: void(0);" onclick=" javascript:OpenPopup('addCategory?idCategory=<s:property value="id" />', 'WindowName', '250', '140', 'scrollbars=1');"><img src="images/editIcon.gif" alt=""/></a></li>
                                    </s:iterator>
                            </ul>
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
    session.removeAttribute("listCategory");
    session.removeAttribute("addService");
    session.removeAttribute("error");
%>
