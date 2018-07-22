<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <title>Test - Login</title>
    </head>
    <body>
        <div id="logindiv">
            <form action="/SoftwareProject/indexServlet" method="post">
                <table id="loginbox">
                    <tr>
                        <td id="formtext">Login:</td>
                        <td id="forminput"><input type="text"/></td>
                    </tr>
                    <tr>
                        <td id="formtext">Password:</td>
                        <td id="forminput"><input type="password"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="login"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>