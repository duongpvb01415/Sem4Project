<%@taglib prefix="s" uri="/struts-tags"%>
<h3>Add User</h3>
<form action="addUser" method="post" >
    <table class="zebra">
        <tr style="display: none">
            <td><input name="id" type="text" value="<s:property value="#session.idU"/>" /></td>
        </tr>
        <tr>
            <td>Name*</td>
            <td><input name="name" type="text" value="<s:property value="use.name"/>"/></td>
        </tr>
        <tr>
            <td>Email*</td>
            <td><input name="email" type="text" class="textbox" value="<s:property value="use.email"/>"/></td>
        </tr>
        <tr>
            <td>Password*</td>
            <td><input name="pass" type="password" class="textbox" value="<s:property value="use.pass"/>"/></td>
        </tr>
        <tr>
            <td>Phone*</td>
            <td><input name="phone" type="text" class="textbox" value="<s:property value="use.phone"/>"/></td>
        </tr>
        <tr>
            <td>Birth Day*</td>
            <td><input name="birth" type="date" class="textbox" value="<s:property value="use.birth"/>"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><select name="gender"><option><s:property value="use.gender"/></option><option>Male</option><option>Famale</option></select></td>
        </tr>
        <tr>
            <td>Accout type</td>
            <td><select name="typeadmin"><option>Client</option><option>Admin</option></select></td>
        </tr>
        <tr>
            <td colspan="2"><label style="color: red"><s:property value="#session.error"/></label></td>
        </tr>
        <tr>
            <td colspan="2"><s:if test="use.id!=0"><input type="submit" value="Edit User"/></s:if><s:else><input type="submit" value="Add User"/></s:else></td>
        </tr>
    </table>
</form>