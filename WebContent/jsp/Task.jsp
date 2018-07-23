<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <title>Test - Task</title>
    </head>
    <body>
        <div id="navigationbar">
            <div id="logodiv">
                <form action="/SoftwareProject/indexServlet" method="post">
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
            <div class="overview-content">
                <div id="task-desc">
                    <div class="nav-links">
                        ${projectlink} -
                        ${workpackagelink} -
                    	${tasklink}
                    </div>
                    <h1>Task 1</h1>
                    <div class="story-points">
                        Story points: ${time}
                    </div>
                    <div class="worker">
                        Assigned User: ${assigneduser}
                    </div>
                    <div class="deadline">
                        Deadline: ${deadline}
                    </div>
                    <div class="status">
                        Status: ${status}
                    </div>
                    <br>
                    <div class="description">
                        Description: ${description}
                    </div>
                     </div>
            </div>
            <div id="my-tasks">
                <table>
                    ${mytasks}
                </table>
            </div>
        </div>
    </body>
</html>