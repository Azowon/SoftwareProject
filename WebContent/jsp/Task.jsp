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
            <div id="udiv">
                <button class="user-config-button" onclick="window.location.href = 'UserConfig.html';">User Config</button>
            </div>
            <div id="create-user-div">
                <button class="create-user-button" onclick="window.location.href = 'CreateUser.html'">Create User</button>
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
                    <button class="edit-button" onclick="window.location.href = 'EditTask.html'">Edit Task</button>
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