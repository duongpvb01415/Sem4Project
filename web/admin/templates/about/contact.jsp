
<%@taglib prefix="s" uri="/struts-tags" %>

                                <form action="editcontact" method="post" >
                                    <table class="zebra">
                                        <tr>
                                            <td>Company*</td>
                                            <td><input name="company" type="text" value="<s:property value="c.company"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Phone*</td>
                                            <td><input name="phone" type="text" class="textbox" value="<s:property value="c.phone"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Fax*</td>
                                            <td><input name="fax" type="text" class="textbox" value="<s:property value="c.fax"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Email*</td>
                                            <td><input name="email" type="text" class="textbox" value="<s:property value="c.email"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Address*</td>
                                            <td><input name="address1" type="text" class="textbox" value="<s:property value="c.address1"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Address 2*</td>
                                            <td><input name="address2" type="text" class="textbox" value="<s:property value="c.address2"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Contry *</td>
                                            <td><input name="contry" type="text" class="textbox" value="<s:property value="c.contry"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Title Page</td>
                                            <td><input name="title" type="text" class="textbox" value="<s:property value="c.title"/>"></td>
                                        </tr>
                                        <tr>
                                            <td>Content</td>
                                            <td><textarea name="content" class="textbox"></textarea></td>
                                        </tr>
                                        <tr>
                                            <td>Monday - Friday</td>
                                            <td>Time start : <select name="timeIn1"><option><s:property value="c.timeIn1"/></option><% for (int i = 0; i < 24; i++) {
                                                            out.print("<option>" + i + "</option>");
                                                        } %></select> | Time end : <select name="timeOut1"><option><s:property value="c.timeOut1"/></option><% for (int i = 0; i < 24; i++) {
                                                                out.print("<option>" + i + "</option>");
                                                            } %></select></td>
                                        </tr>
                                        <tr>
                                            <td>Satday</td>
                                                    <td>Time start : <select name="timeIn2"><option><s:property value="c.timeIn2"/></option><% for (int i = 0; i < 24; i++) {
                                                            out.print("<option>" + i + "</option>");
                                                        } %></select> | Time end : <select name="timeOut2"><option><s:property value="c.timeOut2"/></option><% for (int i = 0; i < 24; i++) {
                                                                out.print("<option>" + i + "</option>");
                                                            } %></select></td>
                                        </tr>
                                        <tr>
                                            <td colspan="2"><span><s:if test="#session.error !='Update Contact Success'"><label style="color: red"><s:property value="#session.error"/></label></s:if><s:else><label style="color: chartreuse"><s:property value="#session.error"/></label></s:else></span></td>
                                            </tr>
                                            <tr>
                                                <td colspan="2"><input style="display: none" name="editContact" value="1" type="text"><input type="submit" value="Edit"</td>
                                            </tr>
                                        </table>
                                    </form>
