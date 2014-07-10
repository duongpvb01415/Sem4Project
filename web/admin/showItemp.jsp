<%-- 
    Document   : comment.jsp
    Created on : Jun 14, 2014, 12:04:31 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:property value="cm.userName"/></title>
        <link href="css/style1.css" rel="stylesheet" type="text/css"  media="all" />
    </head>
    <body>

        <s:if test="#session.addCategory!=null">
            <form action="addCategory" method="post" >
                <table>
                    <tr style="display: none">
                        <td></td>
                        <td><input name="category" type="text" value="<s:property value='c.id'/>"/></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input name="nameCategory" type="text" value="<s:property value='c.name'/>"/></td>
                    </tr>
                    <tr>
                        <td>District</td>
                        <td>
                            <select name="descriptions">
                                <option><s:property value='c.descriptions'/></option>
                                <s:iterator value="listDisTrict">
                                    <option value="<s:property value="id"/>"><s:property value="name"/></option>
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Add Category" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><span style="color: red"><s:property value="#session.categoryError"/></span></td>
                    </tr>
                </table>
            </form>
        </s:if>
        <s:elseif test="#session.addDistrict!=null">
            <table>
            <form action="addDic" method="post">
                <tr style="display: none">
                    <td>table</td>
                    <td><input name="table" type="text" value="1"/></td>
                    <td><input name="id" type="text" value="<s:property value="d.id"/>"/></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input name="name" type="text" value="<s:property value="d.name"/>"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add District"/></td>
                </tr>
                <tr>
                    <td colspan="2"><s:property value="#session.error"/></td>
                </tr>
            </form>
        </table>
        </s:elseif>
        <s:else>
                    
        <div class="company_address">
            <p>Name: <s:property value="cm.userName"/></p>
            <p>Email: <s:property value="cm.email"/></p>
            <p>Phone: <s:property value="cm.userPhone"/></p>
            <p>Comment: <s:property value="cm.body"/></p>
        </div>
        </s:else>
    </body>
</html>
<%
    session.removeAttribute("addDistrict");
    session.removeAttribute("error");
    session.removeAttribute("addCategory");
%>