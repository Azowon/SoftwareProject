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
                <div class="nav-links">
                    <a href="${pageContext.request.contextPath}/${project}">${project}</a>
            	</div>
                <h1>Edit Task</h1>
                <form action="void()" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Task Name:</td>
                            <td><input type="text" name="task-name" value="${task}"/></td>
                        </tr>
                        <tr>
                            <td>Deadline</td>
                            <td><input type="date" name="task-deadline" value="${taskdeadline}"/></td>
                        </tr>
                        <tr>
                            <td>Story Points:</td>
                            <td><input type="text" name="task-time" value="${tasktime}"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="task-description">${taskdetails}</textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="apply-button">Apply</button>
                </form>
                <form action="${pageContext.request.contextPath}/${task}">
                	<button class="cancel-button">Cancel</button>
            	</form>
            </div>
        </div>
    </body>
</html>