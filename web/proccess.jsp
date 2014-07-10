<%-- 
    Document   : index
    Created on : Jun 9, 2014, 5:32:29 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Proccess</title>
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
        <script>

            function myFunction() {
            var x;
                    if (confirm("Press a button!") == true) {
            document.getElementById('project');
            } else {
            x = "You pressed Cancel!";
            }
            document.getElementById("demo").innerHTML = x;</script>
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
                <ul class="rslides" id="slider1">
                    <s:iterator value="lis">
                        <li><img src="<s:property value="slide"/>"/></li>
                        </s:iterator>
                </ul>
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

                        <s:if test="#session.procc!=null">
                            <div id="container">
                                <table class="zebra">
                                    <tr>
                                        <td style="width: 5%">Image</td>
                                        <td style="width: 35%">Name</td>
                                        <td style="width: 5%">Price</td>
                                        <td style="width: 5%">Completed</td>
                                    </tr>
                                    <s:iterator value="lisCart">
                                        <tr>
                                            <td><img width="50" height="50" src="<s:property value="image_service"/>"></td>
                                            <td><s:property value="name_service"/></a></td>
                                            <td><s:property value="price_service"/>$</td>
                                            <td><s:property value="day_service"/> (hours) </td>
                                        </tr>
                                    </s:iterator>

                                    <form action="project" id="project" method="post" enctype="multipart/form-data">
                                        <tr >
                                            <td style="text-align: right"colspan="3">Total : <s:property value="total"/>$</td>
                                            <td colspan="2">In : <s:property value="totalDay"/>(hours)</td>
                                        </tr>
                                        <tr>
                                            <td  colspan="2" style="text-align: right">Start Day *</td>
                                            <td colspan="2"><input type="date" name="start_time"></td>
                                        </tr>
                                        <tr style="display: none">
                                            <td colspan="2" style="text-align: right"><input type="text" name="id_user" value="<s:property value="#session.id"/>"></td>
                                            <td colspan="2"><input type="text" name="total_price" value="<s:property value="total"/>"/></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="text-align: right">Phone *</td>
                                            <td colspan="2"><input type="text" name="phone" /></td>
                                        </tr>

                                        <tr >
                                            <td colspan="2" style="text-align: right">Address *</td>
                                            <td colspan="2"><input type="text" name="addresss" /></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2" style="text-align: right">Avatar</td>
                                            <td colspan="2"><input type="file" name="myFile"/></td>
                                        </tr>
                                        <tr >
                                            <td colspan="2" style="text-align: right">Request more</td>
                                            <td colspan="2"><textarea style="width:100%; height: 5em" name="more"></textarea></td>
                                        </tr>

                                        <tr>
                                            <td colspan="2" style="text-align: left"><a href="cart?back=1">Back</a></td>

                                            <td class="contact-form"     colspan="2" style="text-align: right"><input style="display: none" type="text" name="proccess" value="1"/><input style="display: none" type="text" name="status" value="1"/><input  type="submit" onclick="myFunction().document.getElementById('project')" value="Continue"/></td>
                                        </tr>
                                    </form>
                                    <tr>
                                        <td colspan="4" style="color: red"><s:property value="#session.error"/></td>

                                    </tr>
                                </table>
                            </div>

                            <script>
                                        function myFunction() {
                                        var x;
                                                if (confirm("Press a button!") == true) {

                                        } else {
                                        x = "You pressed Cancel!";
                                        }
                                        document.getElementById("demo").innerHTML = x;
                                        }
                            </script>
                        </s:if>
                        <s:else>
                            <h3><s:property value="#session.error"/></h3>
                            <div id="container">

                                <div class="project">

                                    <table class="zebra">
                                        <tr>
                                            <td colspan="2">Project Information</td>
                                        </tr>
                                        <tr>
                                            <td>Avatar</td>
                                            <td><img width="100" height="100" src="<s:property value="p.avatar"/>"/></td>
                                        </tr>
                                        <tr>
                                            <td>Project ID</td>
                                            <td><s:property value="p.id"/></td>
                                        </tr>
                                        <tr>
                                            <td>Time Start</td>
                                            <td><s:property value="p.start_time"/></td>
                                        </tr>
                                        <tr>
                                            <td>Name contact</td>
                                            <td><s:property value="#session.name"/></td>
                                        </tr>
                                        <tr>
                                            <td>Phone contact</td>
                                            <td><s:property value="p.phone"/></td>
                                        </tr>
                                        <tr>
                                            <td>Address Construction</td>
                                            <td><s:property value="p.address"/></td>
                                        </tr>
                                        <tr>
                                            <td>Time request</td>
                                            <td><s:property value="p.time_request"/></td>
                                        </tr>
                                        <tr>
                                            <td>Total price project</td>
                                            <td><s:property value="p.total_price"/>$</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="payment">
                                    <table class="zebra">
                                        <tr>
                                            <td colspan="2">Payment Information</td>
                                        </tr>
                                        <tr>
                                            <td>Company</td>
                                            <td><s:property value="c.company"/></td>
                                        </tr>
                                        <tr>
                                            <td>Address</td>
                                            <td><s:property value="c.address1"/></td>
                                        </tr>
                                        <tr>
                                            <td>Address 2</td>
                                            <td><s:property value="c.address2"/></td>
                                        </tr>
                                        <tr>
                                            <td>Phone contact</td>
                                            <td><s:property value="c.phone"/></td>
                                        </tr>
                                        <tr>
                                            <td>Email contact</td>
                                            <td><s:property value="c.email"/></td>
                                        </tr>
                                        <tr>
                                            <td>Monday - Friday</td>
                                            <td><s:property value="c.timeIn1"/> : <s:property value="c.timeOut1"/></td>
                                        </tr>
                                        </tr>
                                    </table>
                                </div>
                                <div class="status">
                                    <table class="zebra">
                                        <tr>
                                            <td colspan="2">Status Project</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <s:if test="p.startus==1">
                                                    Up-Coming 
                                                </s:if><s:elseif test="p.startus==2">
                                                    On-Going
                                                </s:elseif><s:elseif test="p.startus==3">
                                                    Accomplished 
                                                </s:elseif><s:else>
                                                    Abortive
                                                </s:else>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="service">
                                    <table class="zebra">
                                        <tr>
                                            <td style="width: 2%">Image</td>
                                            <td style="width: 80%">Name</td>
                                            <td style="width: 5%">Price</td>
                                            <td colspan="2" style="width: 5%">Completed</td>
                                        </tr>
                                        <s:if test="lisCart.size()>0">
                                            <s:iterator value="lisCart">
                                                <tr style="height: 50px" >
                                                    <td><img width="30" height="30" src="<s:property value="image_service"/>"></td>
                                                    <td><s:property value="name_service"/></td>
                                                    <td><s:property value="price_service"/>$</td>
                                                    <td colspan="2"><s:property value="day_service"/> (hours)</td>
                                                </tr>
                                            </s:iterator>
                                        </s:if><s:else>
                                            <tr  style="height: 50px"><td colspan="5">Cart Empty</td></tr>
                                        </s:else>
                                        <tr style="height: 50px">
                                            <td colspan="2" style="text-align: right">Total :  </td>
                                            <td><s:property value="total"/>$</td>
                                            <td colspan="2"><s:property value="totalDay"/>(hours)</td>

                                        </tr>
                                        <tr>

                                            <td colspan="4"></td>
                                            <td class="contact-form"><form action="verify"><input style="display: none" name="verify" value="1"/><input type="submit" value="Submit"/></form></td>
                                        </tr>
                                    </table>
                                </div>

                            </div>
                        </s:else>
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
    session.removeAttribute("cart");
    session.removeAttribute("error");
    session.removeAttribute("error1");
    session.removeAttribute("proccess");
    session.removeAttribute("getProject");
%>