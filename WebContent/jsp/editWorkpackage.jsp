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
                <form action="index.html">
                    <a href="index.html"><img id="logo" src="LOGO.png"></a>
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
                    <a href="${pageContext.request.contextPath}/${project}">${project}</a> -
                	<div id="workpackageid" style="display:none;">${workprojectid}</div>
            		<a href="${pageContext.request.contextPath}/${workpackage}">${workpackage}</a>
                </div>
                <h1>Edit Workpackage</h1>
                <form action="void()" method="get">
                    <table class="create-table">
                        <tr>
                            <td>Workpackage Name:</td>
                            <td><input type="text" name="workpackage-name" value="${workpackage}"/></td>
                        </tr>
                        <tr>
                            <td>Deadline:</td>
                            <td><input type="date" name="workpackage-deadline" value="${projectdeadline}"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea rows="5" cols="50" name="workpackage-description">${workpackagedetails}</textarea></td>
                        </tr>
                    </table>
                    <button type="submit" class="apply-button">Apply</button>
                </form>
                <form action="${pageContext.request.contextPath}/${workpackage}">
                	<button class="cancel-button">Cancel</button>
            	</form>
            </div>
        </div>
    </body>
</html>