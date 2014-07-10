<%@taglib prefix="s"  uri="/struts-tags"%>
<h3>SERVICE</h3>
                            <table class="zebra">
                                <tr>
                                    <td style="width: 10%">Image</td>
                                    <td style="width: 45%">Name</td>
                                    <td style="width: 20%">Price</td>
                                    <td style="width: 10%">Time</td>
                                    <td style="width: 15%">Action</td>
                                </tr>
                                <s:if test="#session.listCategory!=null">
                                    <s:iterator value="listServiceInDistrict">
                                        <tr>
                                            <td><img src="../<s:property value="images"/>" width="50" height="50"/></td>
                                            <td><a href="javascript: void(0);" onclick=" javascript:OpenPopup('showService?idService=<s:property value="id" />', 'WindowName', '500', '300', 'scrollbars=1');"><s:property value="name"/></a></td>
                                            <td><s:property value="price"/></td>
                                        <td><s:property value="day_completion"/></td>
                                        <td><a href="deleteDis?delService=<s:property value="id"/>">Delete </a>|<a href="addService?idService=<s:property value="id" />"> Edit</a></td>
                                        </tr>
                                    </s:iterator>
                                </s:if>
                                <s:else>
                                    <s:iterator value="listService">
                                        <tr>
                                            <td><img src="../<s:property value="images"/>" width="50" height="50"/></td>
                                            <td><a href="javascript: void(0);" onclick=" javascript:OpenPopup('showService?idService=<s:property value="id" />', 'WindowName', '500', '300', 'scrollbars=1');"><s:property value="name"/></a></td>
                                            <td><s:property value="price"/></td>
                                        <td><s:property value="day_completion"/></td>
                                        <td><a href="deleteDis?delService=<s:property value="id"/>">Delete </a>|<a href="addService?idService=<s:property value="id" />"> Edit</a></td>
                                        </tr>
                                    </s:iterator>
                                </s:else>
                            </table>
