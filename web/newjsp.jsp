<%-- 
    Document   : newjsp
    Created on : Jul 8, 2014, 3:00:36 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <script type="text/javascript">
            $(".ddd").on("click", function() {

                var $button = $(this);
                var oldValue = $button.parent().find("input .quntity-input").val();

                if ($button.text() == "+") {
                    var newVal = parseFloat(oldValue) + 1;
                } else {
                    // Don't allow decrementing below zero
                    if (oldValue > 0) {
                        var newVal = parseFloat(oldValue) - 1;
                    } else {
                        newVal = 0;
                    }
                }

                $button.parent().find("input .quntity-input").val(newVal);

            });
        </script>
        <div class="sp-quantity">
            <div class="sp-minus fff"> <a class="ddd" href="#">-</a></div>
            <div class="sp-input">
                <input type="text" class="quntity-input" value="1">
            </div>
            <div class="sp-plus fff"> <a class="ddd" href="#">+</a></div>
        </div>
    </body>
</html>
