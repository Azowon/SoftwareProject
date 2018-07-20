<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <title>${title}</title>
    </head>
    <body>
        <div id="navigationbar">
            <div id="logodiv">
                <form action="${pageContext.request.contextPath}/indexServlet" method="post">
                    <input type='image' src='${pageContext.request.contextPath}${logo}'/>
                </form>
            </div>
            <div id="pdiv">
                <button class="pbutton">Project</button>
                <div class="project-content">
                    ${projectcontent}
                </div>
            </div>
            <div id="udiv">
                <button class="user-config-button" onclick="window.location.href = 'UserConfig.html';">User Config</button>
            </div>
            <div id="create-user-div">
                <button class="create-user-button" onclick="window.location.href = 'CreateUser.html'">Create User</button>
            </div>
        </div>
        <div class="content">
            <div class="create-model">
                <h1>Create new Project</h1>
                <form action="${pageContext.request.contextPath}/CreateProjectServlet" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Project Name:</td>
                            <td><input type="text" name="project-name"/></td>
                        </tr>
                        <tr>
                            <td>Deadline:</td>
                            <td><input type="date" name="project-deadline"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="project-description"></textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="create-button">Create</button>
                </form>
                <form action="${pageContext.request.contextPath}/indexServlet">
                	<button class="cancel-button">Cancel</button>
            	</form>
            </div>
        </div>
    </body>
</html>