<%@taglib prefix="s" uri="/struts-tags"%> 
<h3>List User</h3>
<table class="zebra">
    <tr>
        <td>Full Name</td>
        <td>Email</td>
        <td>Phone</td>
        <td>Gender</td>
        <td>Aciton</td>
    </tr>
    <s:if test="%{lisU.size()>0}">
        <s:iterator value="lisU">
            <tr>
                <td style="width: 20%"><s:property value="name"/></td>
                <td style="width: 30%"><s:property value="email"/></td>
                <td style="width: 15%"><s:property value="phone"/></td>
                <td style="width: 10%"><s:if test="gender==true">Male</s:if><s:else>Female</s:else></td>
                <td style="width: 15%">
                        <a href="editUser?idUser=<s:property value="id"/>">Edit</a>
                        <a href="editUser?deleteId=<s:property value="id"/>">Delete</a>
                </td>
            </tr>
        </s:iterator>
    </s:if><s:else>
        <tr>
            <td colspan="6">Users empty</td>
        </tr>
    </s:else>
</table>