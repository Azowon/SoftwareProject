<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <title name="title">${title}</title>
    </head>
    <body>
        <div id="navigationbar">
            <div id="logodiv">
                <form action="/sw_proj/indexServlet" method="post">
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
                <div id="project-desc">
                    <div class="nav-links">
                        ${projectlink}
                    </div>
                    <h1>${name}</h1>
                    <div class="story-points">
                        Total Story Points: ${time}
                    </div>
                    <div class="deadline">
                        Deadline: ${deadline}
                    </div>
                    <br>
                    <div class="description">
                        ${description}
                    </div>
                    <button class="edit-button" onclick="window.location.href = 'EditProject.html'">Edit Project</button>
                </div>
                <div id="project-workpackages">
                    <table class="overview-table">
                        ${workpackages}
                    </table>
                    <form type="submit" action="NewWorkpackage.html" method="get">
                        <button class="create-new-button">Create new Workpackage</button>
                    </form>
                </div>
            </div>
            <div id="my-tasks">
                <table>
                    <tr>
						${mytasks}
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>