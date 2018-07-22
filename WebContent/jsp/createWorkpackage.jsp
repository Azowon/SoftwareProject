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
            	<form action="${userpath}" method="post">
                	<button class="user-config-button">${username}</button>
                </form>
            </div>
            <div id="delete-user-div">
            	<form action="${pageContext.request.contextPath}/DeleteUser" method="post">
                	<button class="delete-user-button">Delete User</button>
            	</form>	
			</div>
            <div id="create-user-div">
            	<form action="${pageContext.request.contextPath}/CreateUser" method="post">
                	<button class="create-user-button">Create User</button>
            	</form>
            </div>
        </div>
        <div class="content">
            <div class="create-model">
            <div class="nav-links">
                <div id="projectid" style="display:none;">${projectid}</div>
                <a href="${pageContext.request.contextPath}/${project}">${project}</a>
            </div>
            <h1>Create new Workpackage</h1>
                <form action="${pageContext.request.contextPath}/CreateWorkpackageServlet" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Workpackage Name:</td>
                            <td><input type="text" name="workpackage-name"/></td>
                        </tr>
                        <tr>
                            <td>Deadline:</td>
                            <td><input type="date" name="workpackage-deadline"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="workpackage-description"></textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="create-button">Create</button>
                </form>
                <form action="${pageContext.request.contextPath}/${project}">
                	<button class="cancel-button">Cancel</button>
            	</form>
            </div>
        </div>
    </body>
</html>