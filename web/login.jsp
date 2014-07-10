<%-- 
    Document   : login
    Created on : Jun 10, 2014, 11:33:08 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Deluxe Website Template | Home :: W3layouts</title>
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

            <!--End-image-slider---->
            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">

                <div class="clear"> </div>
                <div class="box">
                    <div class="left-box">
                        <div class="contact-form">
                            <s:if test="#session.name==null">
                                <h3>Register</h3>
                                <form action="register" method="post" >
                                    <div>
                                        <span><label>Name*</label></span>
                                        <span><input name="name" type="text"></span>
                                    </div>
                                    <div>
                                        <span><label>Email*</label></span>
                                        <span><input name="email" type="text" class="textbox"></span>
                                    </div>
                                    <div>
                                        <span><label>Password*</label></span>
                                        <span><input name="pass" type="password" class="textbox"></span>
                                    </div>
                                    <div>
                                        <span><label>Phone*</label></span>
                                        <span><input name="phone" type="text" class="textbox"></span>
                                    </div>
                                    <div>
                                        <span><label>Birth Day*</label></span>
                                        <span><input name="birth" type="date" class="textbox"></span>
                                    </div>
                                    <div>
                                        <span><label>Gender</label></span>
                                        <span><select name="gender"><option>Male</option><option>Famale</option></select></span>
                                    </div>
                                    <div>
                                        <span><label style="color: red"><s:property value="#session.error"/></label></span>
                                    </div>

                                    <div>
                                        <span><input type="submit" value="Add User"></span>
                                    </div>
                                </form>
                            </s:if>
                            <s:elseif test="#session.account!=null">
                                <table class="zebra">
                                    Hello
                                </table>
                            </s:elseif>
                            <s:elseif test="#session.itempProject!=null">
                                <div class="project" style="padding-right: 1em; padding-bottom: 2em">

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
                                <div class="payment" style="padding-left: 1em">
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
                                <div class="status"  style="padding-left: 1em; padding-top: 2em">
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
                                            <td colspan="2" style="width: 80%">Name</td>
                                            <td style="width: 5%">Price</td>
                                            <td colspan="2" style="width: 5%">Completed</td>
                                        </tr>
                                        <s:if test="listSvByProject.size()>0">
                                            <s:iterator value="listSvByProject">
                                                <tr style="height: 50px" >
                                                     <td colspan="2"><s:property value="name_service"/></td>
                                                    <td><s:property value="price_service"/>$</td>
                                                    <td colspan="2"><s:property value="hour_service"/> (hours)</td>
                                                </tr>
                                            </s:iterator>
                                        </s:if><s:else>
                                            <tr  style="height: 50px"><td colspan="5">Cart Empty</td></tr>
                                        </s:else>
                                        <tr style="height: 50px">
                                            <td colspan="2" style="text-align: right">Total :  </td>
                                            <td><s:property value="p.total_price"/>$</td>
                                            <td colspan="2"><s:property value="totalHour"/>(hours)</td>

                                        </tr>
                                        <tr>


                                    </table>
                                </div>
                                            <div class="service">
                                                <s:if test="#session.id!=null">
                                                    
                                                <table class="zebra">
                                                    <s:iterator value="lisComProject">
                                                    <tr>
                                                        <td><span style="color: chartreuse"><s:property value="name"/> : <s:property value="time_content"/></span><s:property value="content"/></td>
                                                    </tr>
                                                    </s:iterator>
                                                    <form action="conmentProject" method="post">
                                                    <tr>
                                                        <td><textarea style="width: 80%; height: 40px" name="content"></textarea></td>
                                                    </tr>
                                                    <tr>
                                                        <td><input type="submit" value="Comment"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td><s:property value="#session.content"/></td>
                                                    </tr>
                                                    </form>
                                                </table>
                                                    
                                                </s:if>
                                            </div>
                            </s:elseif>
                            <s:else>
                                <table class="zebra" style="padding-bottom: 2em">
                                    <tr style="text-align: center"><form action="user" method="post">
                                        <td><select name="status">
                                                        <option>All</option>
                                                        <option value="1">Up-Coming</option>
                                                        <option value="2">On-Going</option>
                                                        <option value="3">Accomplished</option>
                                                        <option value="4">Abortive</option>
                                            </select><input type="submit" value="Search"/></td>

                                    </tr></form>
                                </table>
                                <table class="zebra">
                                    <tr>
                                        <td style="width: 10%">Avatar</td>
                                        <td style="width: 65%">Address</td>
                                        <td style="width: 15%">Start Time</td>
                                        <td style="width: 5%">Total</td>
                                        <td style="width: 5%">Status</td>
                                    </tr>
                                    <s:iterator value="listProjectUser">
                                        <tr>
                                            <td><img width="50" height="50" src="<s:property value="avatar"/>"/></td>
                                            <td><a href="user?itempProject=<s:property value="id"/>"><s:property value="address" /></a></td>
                                            <td><s:property value="start_time" /></td>
                                            <td><s:property value="total_price" /></td>
                                            <td><s:if test="startus==1"><form action="statusCancel" method="post"><input style="display: none" type="text" name="cancel" value="4"/><input style="display: none" type="text" name="id_project" value="<s:property value="id"/>"/><input type="submit" value="Cancel"/></form></s:if>
                                                <s:elseif test="startus==2">On-Going</s:elseif>
                                                <s:elseif test="startus==3">Accomplished</s:elseif>
                                                <s:elseif test="startus==4">Abortive</s:elseif>
                                                </td>
                                        </tr>
                                    </s:iterator>
                                </table>
                            </s:else>

                        </div>
                    </div>
                    <div class="right-box">
                        <div class="contact-form">
                            <s:if test="#session.name==null">
                                <form action="checkLogin" method="post">
                                    <div>
                                        <span><label>Email</label></span>
                                        <span><input name="email" type="text" class="textbox" value="<s:property value="#session.emaillogin"/>"></span>
                                    </div>
                                    <div>
                                        <span><label>Password</label></span>
                                        <span><input name="password" type="password" class="textbox" value="<s:property value="#session.password"/>"></span>
                                    </div>
                                    <span style="position: relative; top: 35px; width: 150px"><input type="checkbox" name="check"/><label> remember login</label></span>
                                    <span style="position: absolute; top:145px; color: red"><s:property value="#session.loginError"/></span>
                                    <div style="float: right"><span><input type="submit" value="Login"/></a></span></div>

                                </form>
                            </s:if><s:else>

                                <div>
                                    <span><label>Email</label> : <label><b><s:property value="#session.email"/></b></label></span>
                                </div>
                                <div>
                                    <span><label>Name</label> : <label><b><s:property value="#session.name"/></b></label></span>
                                </div>
                                <div>
                                    <span><label>Birth Day</label> : <label><b><s:property value="#session.birth"/></b></label></span>
                                </div>
                                <div>
                                    <span><label>Gender</label> : <label><b><s:if test="#session.gender==true">Male</s:if><s:else>Famale</s:else></b></label></span>
                                    </div>


                                    <div style="float: right"><span><a href="Logout"><input type="submit" value="Logout"></a></form></span></div>
                                        </s:else>
                        </div>
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
    session.removeAttribute("user");
    session.removeAttribute("account");
    session.removeAttribute("itempProject");
    session.removeAttribute("content");
%>