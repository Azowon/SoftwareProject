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
            <div class="edit-model">
                <h1>Create new User</h1>
                <form action="void()" method="get">
                    <table class="edit-table">
                        <tr>
                            <td>Role:</td>
                            <td>
                                <select name="user-role">
                                    <option>member</option>
                                    <option>admin</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>First Name:</td>
                            <td><input type="text" name="user-firstname"/></td>
                        </tr>
                        <tr>
                            <td>Last Name:</td>
                            <td><input type="text" name="user-lastname"/></td>
                        </tr>
                        <tr>
                            <td>Team:</td>
                            <td><input type="text" name="user-team"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="user-description"></textarea></td>
                        </tr>
                    </table>
                    <form action="${pageContext.request.contextPath}/indexServlet" method="get">
                		<button class="cancel-button">Cancel</button>
            		</form>
                </form>
            </div>
        </div>
    </body>
</html>