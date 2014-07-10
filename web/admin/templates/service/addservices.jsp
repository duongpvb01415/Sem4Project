<%@taglib prefix="s" uri="/struts-tags"%>
<table class="zebra">
    <form action="addService" method="post" enctype="multipart/form-data">
        <tr style="display: none">
            <td>id</td>
            <td><input name="idSer" type="text" value="<s:property value='s.id'/>"></td>
        </tr>
        <tr>
            <td>Name *</td>
            <td><input name="name" type="text" value="<s:property value='s.name'/>"></td>
        </tr>
        <tr>
            <td>Content *</td>
            <td><input name="content" type="text" value="<s:property value='s.content'/>"></td>
        </tr>
        <tr>
            <td>Category*</td>
            <td>
                <select name="id_category" >
                    <option><s:property value='s.id_category'/></option>
                    <s:iterator value="cmbCategory">
                        <option value="<s:property value="id"/>"><s:property value="name"/></option>
                    </s:iterator>
                </select>
            </td>
        </tr>
        <tr>
            <td>Price *</td>
            <td><input name="price" type="text" value="<s:property value='s.price'/>"></td>
        </tr>
        <tr>
            <td>Upload Image</td>
            <td><input name="myFile" type="file" value="<s:property value='s.images'/>"></td>
        </tr>
        <tr>
            <td>Descriptions</td>
            <td><textarea name="descriptions"  style="width: 100%; height: 300px"><s:property value='s.descriptions'/></textarea></td>
        </tr>
        <tr>
            <td>Time Expiration</td>
            <td><input type="text" name="day_completion" value="<s:property value='s.day_completion'/>"/></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red"><s:property value="#session.error"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"></td>
        </tr>

    </form>
</table>