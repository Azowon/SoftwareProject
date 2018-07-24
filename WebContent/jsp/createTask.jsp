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
            <div id="hdiv">
            	<button class="hbutton">Heatmap</button>
                <div class="heatmap-content">
                    ${heatmapcontent}
                </div>
            </div>
            <div id="logoutdiv">
            	<form action="${pageContext.request.contextPath}/LogoutServlet" method="post">
            		<button class="logout-button">Logout</button>
            	</form>
            </div>
            <div id="udiv">
            	<form action="${userpath}" method="post">
                	<button class="user-config-button">${username}</button>
                </form>
            </div>
            <div id="delete-user-div">
            	<form action="${pageContext.request.contextPath}/DeleteUserFormServlet" method="post">
                	<button class="delete-user-button">Delete User</button>
            	</form>	
			</div>
            <div id="create-user-div">
            	<form action="${pageContext.request.contextPath}/CreateUserFormServlet" method="post">
                	<button class="create-user-button">Create User</button>
            	</form>
            </div>
        </div>
        <div class="content">
            <div class="create-model">             
                <h1>Create or edit a Task</h1>
                <form action="${pageContext.request.contextPath}/CreateTaskServlet" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Task Name: </td>
                            <td><input type="text" name="task-name"/></td>
                        </tr>
                        <tr>
                            <td>Deadline: </td>
                            <td><input type="date" name="task-deadline"/></td>
                        </tr>
                        <tr>
                            <td>Workpackage Name: </td>
                            <td><input type="text" name="workpackage-name"/></td>
                        </tr>
                        <tr>
                            <td>Time Booked: </td>
                            <td><input type="text" name="task-booked"/></td>
                        </tr>
                        <tr>
                            <td>Time Planned: </td>
                            <td><input type="text" name="task-time"/></td>
                        </tr>
                        <tr>
                            <td>Status: </td>
                            <td><input type="text" name="task-status"/></td>
                        </tr>
                        <tr>
                            <td>Description: </td>
                            <td><textarea rows="5" cols="50" name="task-description"></textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="create-button">Create or Edit</button>
                </form>
				<input class="cancel-button" type="button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/WorkpackageServlet?id=${workpackageid}'" />
            </div>
        </div>
    </body>
</html>