<%-- 
    Document   : about
    Created on : Jun 11, 2014, 11:28:12 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Deluxe Website Template | About :: W3layouts</title>
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

                <jsp:include page="templates/header.jsp"/>
                <div class="top-nav">
                    <ul>
                        <li><a href="homeedit?home=5">Add About</a></li>
                        <li><a href="homeedit?home=4">Logo Upload</a></li>
                        <li><a href="homeedit?home=3">Slide Upload</a></li>
                        <li><a href="homeedit?home=2">About</a></li>
                        <li><a href="homeedit?home=1">Home</a></li>

                    </ul>
                </div>


            <div class="clear"> </div>	
            <!---start-content---->	
            <div class="content">

                <div class="clear"> </div>
                <div class="box">
                    <div class="left-box">
                        <s:if test="#session.home1!=null">
                        <div class="CSSTableGenerator">
                        <h3>Edit Home Page</h3>
                        <table>
                            <form action="homeedit" method="post">
                                <tr style="display: none">
                                <td>Title</td>
                                <td><input type="text" name="id" value="2"/></td>
                            </tr>
                            <tr>
                                <td>Title</td>
                                <td><input type="text" name="title" value="<s:property value="h.title"/>"/></td>
                            </tr>
                            <tr>
                                <td>Logo</td>
                                <td><select name="logo"><s:iterator value="lisLogo"><option><s:property value="logo"/></option></s:iterator></select></td>
                            </tr>
                            <tr>
                                <td>Home Welcome</td>
                                <td><textarea style="height: 100px; width: 50%" name="content1"><s:property value="h.content1"/></textarea></td>
                            </tr>
                            <tr>
                                <td>OUR TEAM</td>
                                <td><textarea style="height: 100px; width: 50%" name="content2"><s:property value="h.content2"/></textarea></td>
                            </tr>
                            <tr>
                                <td>SERVICES</td>
                                <td><textarea style="height: 100px; width: 50%" name="content3"><s:property value="h.content3"/>"</textarea></td>
                            </tr>
                            <tr>
                                <td>Root Upload</td>
                                <td><span style="color: red">local address for service upload images, avatar .. if you do not save properly address will not upload images to the right and will not display images</span></br></br><input name="link" size="40" value="<s:property value="h.rootUpload"/>"/></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Edit"/></td>
                            </tr>
                            <tr>
                                <td colspan="2"><s:property value="#session.error"/></td>
                                
                            </tr>
                            </form>
                        </table>
                        </div>
                        <div class="clear"> </div>
                        </s:if>
                        <s:if test="#session.home2!=null">
                        <div class="CSSTableGenerator">
                        <h3>List About</h3>
                        <table>
                            <tr>
                                <td>Title</td>
                                <td>Description</td>
                                <td>Action</td>
                            </tr>
                            <s:iterator value="lisAbout">
                               
                                <td><s:property value="title"/></td>
                                <td><s:property value="descriptions"/></td>
                                <td><a href="homeedit?editIdAbout=<s:property value="id"/>">Edit</a></td>
                            </tr>
                            </s:iterator>
                        </table>
                        </div>
                        </s:if>
                        <s:if test="#session.home3!=null">
                        <div class="CSSTableGenerator">
                        <h3>Upload Slide</h3>
                       
                        <table>
                            <form action="uploadslide" method="post" enctype="multipart/form-data">
                            <tr style="display: none">
                                <td>File</td>
                                <td>Browse</td>
                            </tr>
                            <tr>
                                <td>Image</td>
                                <td><input style="display: none" type="text" name="id" value="1"/><input type="file" name="myFile"/></td>
                            </tr>
                            
                            <tr>
                                <td colspan="2"><s:property value="#session.myFile1" /></td>
                                
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Upload"/></td>
                                
                            </tr>
                           </form>
                        </table>
                                </br>
                                <div >
                                <ul>
                                    <s:iterator value="lis">
                                        <li style="padding: 0px; float: left"><img width="348" height="150" src="../<s:property value="slide" />" /><a style="background: none" href="deleteSlide?iddelete=<s:property value="id"/>"><img style="padding: 10px"src="images/f-cross_256-16.png" alt=""/></a></li>
                                    </s:iterator>
                                </ul> 
                                 </div>
                        </div>
                                <div class="clear"> </div>
                        </s:if>
                        <s:if test="#session.home4!=null">
                            <div class="CSSTableGenerator">
                        <h3>Upload Logo</h3>
                       
                        <table>
                            <form action="uploadslide" method="post" enctype="multipart/form-data">
                            <tr style="display: none">
                                <td>File</td>
                                <td>Browse</td>
                            </tr>
                            <tr>
                                <td>Image</td>
                                <td><input style="display: none" type="text" name="id" value="3"/><input type="file" name="myFile"/></td>
                            </tr>
                            
                            <tr>
                                <td colspan="2"><s:property value="#session.myFile1" /></td>
                                
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Upload"/></td>
                                
                            </tr>
                           </form>
                        </table>
                                <div >
                                <ul   >
                                    <s:iterator value="lisLogo">
                                        <li style="padding: 0px; float: left"><img width="348" height="150" src="../<s:property value="logo" />" /><a style="background: none" href="deleteLogo?logodelete=<s:property value="id"/>"><img style="padding: 10px"src="images/f-cross_256-16.png" alt=""/></a></li>
                                        
                                    </s:iterator>
                                </ul> 
                                    </div>
                        </div>
                        </s:if>
                        <s:if test="#session.home5!=null">
                            <div class="CSSTableGenerator">
                                <h3>Add or Edit About</h3>
                                <table>
                                    <form action="addAbout" method="post">
                                        <tr style="display: none">
                                        <td>Id</td>
                                        <td><input name="id" type="text" value="4"/></td>
                                    </tr>
                                        <tr style="display: none">
                                        <td>Id</td>
                                        <td><input name="idAbout" type="text" value="<s:property value="a.id" />"/></td>
                                    </tr>
                                    <tr>
                                        <td>Title</td>
                                        <td><input name="aboutTitle" type="text" value="<s:property value="a.title" />"/></td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td><textarea name="description" style="width: 200px; height: 200px"><s:property value="a.descriptions" /></textarea></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><input type="submit" value="Submit"/></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="color: red"><s:property value="#session.error"/></td>
                                    </tr>
                                    </form>
                                </table>
                            </div>
                        </s:if>
                        
                    </div>
                    <div class="right-box">
                        <h3>List About</h3>
                        <div class="right-box-grid">
                            <s:iterator value="lisAbout">
                            <div class="right-box-grid-img">
                                <a style="background: none" href="deleteAbout?idAboutdelete=<s:property value="id"/>"><img style="padding: 10px"src="images/f-cross_256-16.png" alt=""/></a>
                            </div>
                            <div class="right-box-grid-info">
                                <span><s:property value="title"/></span>
                                
                            </div>
                            <div class="clear"> </div>
                            </s:iterator>
                        </div>
                        <div class="seeall">
                            <a class="see" href="#">View all</a>
                        </div>
                    </div>
                    <div class="clear"> </div>
                </div>
            </div>
            <!---End-content---->	
            <div class="clear"> </div>
            <div class="footer">
                <jsp:include page="templates/footer.jsp"/>
            </div>
        </div>
        <!---End-wrap---->
    </body>
</html>
<%
    session.removeAttribute("error");
    session.removeAttribute("home1");
    session.removeAttribute("home2");
    session.removeAttribute("home3");
    session.removeAttribute("home4");
    session.removeAttribute("home5");
    session.removeAttribute("myFile1");
    session.removeAttribute("myFile2");
    session.removeAttribute("myFile3");
    session.removeAttribute("logo");
%>