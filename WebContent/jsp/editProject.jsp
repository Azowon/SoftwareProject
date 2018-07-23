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
                <div class="nav-links">
                	<div id="projectid" style="display:none;">${projectid}</div>
                    <a href="${pageContext.request.contextPath}/${project}">${project}</a>
            	</div>
                <h1>Edit Project</h1>
                <form action="void()" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Project Name:</td>
                            <td><input type="text" name="project-name" value="${project}"/></td>
                        </tr>
                        <tr>
                            <td>Deadline:</td>
                            <td><input type="date" name="project-deadline" value="${projectdeadline}"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="project-description">${projectdetails}</textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="apply-button">Apply</button>
                </form>
                <form action="${pageContext.request.contextPath}/${project}">
                	<button class="cancel-button">Cancel</button>
            	</form>
            </div>
        </div>
    </body>
</html>