
<%@taglib prefix="s" uri="/struts-tags" %>
<table class="zebra">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Phone</td>
        <td style="width: 190px">Action</td>
    </tr>
    <s:if test="%{listSend.size()>0}">
        <s:iterator value="listSend">
            <tr>
                <td><s:property value="userName"/></td>
                <td><a href="mailto:<s:property value="email"/>"><s:property value="email"/></a></td>
                <td><s:property value="userPhone"/></td>
                <td><form style="float: left" action="deleteComment"><input style="display: none" type="text" name="id_comment" value="<s:property value="id"/>"/><input type="submit" value="Delete"/></form><a href="javascript: void(0);" onclick=" javascript:OpenPopup('commit?id=<s:property value='id'/>', 'WindowName', '510', '280', 'scrollbars=1');">Detail</a></td>

            </tr>
        </s:iterator>
    </s:if>
    <s:else>
        <tr>
            <td colspan="4">Commentary empty</td>
        </tr>
    </s:else>
</table>
