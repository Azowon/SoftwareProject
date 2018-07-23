package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.Logger;
import Util.Utilities;

/**
 * Creates and executes SQL statements
 * @author Raphael Albiez
 *
 */
public class StatementCreator {
	
	/**
	 * Creates new StatementCreator
	 */
	public StatementCreator() {}
	
	/**
	 * Selects all users from database
	 * @return List of all users
	 */
	public List<User> selectUsers()
	{
		List<User> users=new ArrayList<User>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM users","Regular");
			
			while(res.next())
			{
				users.add(new User(
						res.getLong("user_id"),
						res.getString("username"),
						res.getString("firstname"),
						res.getString("lastname"),
						res.getString("description"),
						res.getString("team"),
						res.getString("role")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return users;
	}
	
	/**
	 * Selects all users in a specific task
	 * @param taskId Id of the task to list users in
	 * @return List of all users in specific task
	 */
	public List<User> selectUsersInTask(long taskId)
	{
		List<User> users=new ArrayList<User>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM users_in_task, users WHERE users_in_task.user_id= users.user_id AND task_id="+taskId,"Regular");
			
			while(res.next())
			{
				users.add(new User(
						res.getLong("users.user_id"),
						res.getString("users.username"),
						res.getString("users.firstname"),
						res.getString("users.lastname"),
						res.getString("users.description"),
						res.getString("users.team"),
						res.getString("users.role")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return users;
	}
	
	/**
	 * Selects all users using where condition
	 * @param condition where condition
	 * @return List of selected users
	 */
	public List<User> selectUsersWhere(String condition)
	{
		List<User> users=new ArrayList<User>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM users WHERE "+condition,"Regular");
			
			while(res.next())
			{
				users.add(new User(
						res.getLong("user_id"),
						res.getString("username"),
						res.getString("firstname"),
						res.getString("lastname"),
						res.getString("description"),
						res.getString("team"),
						res.getString("role")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return users;
	}
	
	/**
	 * Inserts new user into database
	 * @param u User to insert
	 */
	public void insertUser(User u)
	{
		String statement="INSERT INTO users VALUES (DEFAULT,\'"+u.getUsername()+"\',\'"+u.getFirstname()+"\',\'"+u.getLastname()+"\',\'"+u.getDescription()
				+"\',\'"+u.getTeam()+"\',\'"+u.getRole()+"\')";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		
	}
	
	/**
	 * Updates user
	 * @param u User to update
	 */
	public void updateUser(User u)
	{
		String statement="UPDATE users SET username=\'"+u.getUsername()+"\',firstname=\'"+u.getFirstname()+"\',lastname=\'"+u.getLastname()
				+"\',description=\'"+u.getDescription()+"\',team=\'"+u.getTeam()+"\',role=\'"+u.getRole()+"\' where user_id="+u.getId();
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Deletes User
	 * @param u User to delete
	 */
	public void deleteUser(User u)
	{
		try
		{
			StatementExecutor.executeUpdate("DELETE FROM authentication WHERE username=\'"+u.getUsername()+"\'", "Password");
			StatementExecutor.executeUpdate("DELETE FROM users_in_task WHERE user_id="+u.getId(), "Regular");
			StatementExecutor.executeUpdate("UPDATE task SET assigned_user_id=1 where assigned_user_id="+u.getId(), "Regular");
			this.deleteUserRoleInProject(u.getId(), -1);
			StatementExecutor.executeUpdate("DELETE FROM users WHERE user_id="+u.getId(),"Regular");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}

	/**
	 * Selects all projects
	 * @return List of all projects
	 */
	public List<Project> selectProjects()
	{
		List<Project> projects=new ArrayList<Project>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM project","Regular");
			
			while(res.next())
			{
				projects.add(new Project(
						res.getLong("project_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return projects;
	}
	
	/**
	 * Selects projects using condition
	 * @param condition where condition
	 * @return List of selected projects
	 */
	public List<Project> selectProjectsWhere(String condition)
	{
		List<Project> projects=new ArrayList<Project>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM project WHERE "+condition,"Regular");
			
			while(res.next())
			{
				projects.add(new Project(
						res.getLong("project_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return projects;
	}
	
	/**
	 * Insert new project
	 * @param p Project to insert
	 */
	public void insertProject(Project p)
	{
		String statement="INSERT INTO project VALUES (DEFAULT,\'"+p.getName()+"\',\'"+p.getDescription()+"\',\'"+p.getDeadline().toString()+"\')";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Update project
	 * @param p Project to update
	 */
	public void updateProject(Project p)
	{
		String statement="UPDATE project SET name=\'"+p.getName()+"\',description=\'"+p.getDescription()+"\',deadline=\'"+p.getDeadline().toString()+"\' where project_id="+p.getId();
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Delete project
	 * @param p Project to delete
	 */
	public void deleteProject(Project p)
	{
		try
		{
			this.deleteUserRoleInProject(-1, p.getId());
			this.deleteTPoint(p.getId());
			List<Workpackage> workpackages=this.selectWorkpackageWhere("project_id="+p.getId());
			for(Workpackage w : workpackages) {
				this.deleteWorkpackage(w);
			}
			StatementExecutor.executeUpdate("DELETE FROM project WHERE project_id="+p.getId(),"Regular");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Selects all workpackages
	 * @return List of all workpackages
	 */
	public List<Workpackage> selectWorkpackages()
	{
		List<Workpackage> workpackages=new ArrayList<Workpackage>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM workpackage","Regular");
			
			while(res.next())
			{
				workpackages.add(new Workpackage(
						res.getLong("workpackage_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline"),
						res.getLong("project_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return workpackages;
	}
	
	/**
	 * Selects all workpackages using condition
	 * @param condition where condition
	 * @return List of all selected workpackages
	 */
	public List<Workpackage> selectWorkpackageWhere(String condition)
	{
		List<Workpackage> workpackages=new ArrayList<Workpackage>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM workpackage WHERE "+condition,"Regular");
			
			while(res.next())
			{
				workpackages.add(new Workpackage(
						res.getLong("workpackage_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline"),
						res.getLong("project_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return workpackages;
	}
	
	/**
	 * Insert new workpackage
	 * @param w Workpackage to insert
	 */
	public void insertWorkpackage(Workpackage w)
	{
		String statement="INSERT INTO project VALUES (DEFAULT,\'"+w.getName()+"\',\'"
				+w.getDescription()+"\',\'"+w.getDeadline().toString()+"\',\'"+w.getProjectId()+"\')";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Update workpackage
	 * @param w Workpackage to update
	 */
	public void updateWorkpackage(Workpackage w)
	{
		String statement="UPDATE project SET name=\'"+w.getName()+"\',description=\'"+w.getDescription()
				+"\',deadline=\'"+w.getDeadline().toString()+"\',project_id=\'"+w.getProjectId()+"\' where workpackage_id="+w.getId();
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Delete workpackage
	 * @param w Workpackage to delete
	 */
	public void deleteWorkpackage(Workpackage w)
	{
		try
		{			
			List<Task> tasks=this.selectTaskWhere("workpackage_id="+w.getId());
			for(Task t : tasks)
			{
				this.deleteTask(t);
			}
			StatementExecutor.executeUpdate("DELETE FROM workpackage WHERE workpackage_id="+w.getId(),"Regular");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Selects all sasks
	 * @return List of all tasks
	 */
	public List<Task> selectTask()
	{
		List<Task> tasks=new ArrayList<Task>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM task","Regular");
			
			while(res.next())
			{
				tasks.add(new Task(
						res.getLong("task_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline"),
						res.getString("status"),
						res.getDouble("time_booked"),
						res.getDouble("time_planned"),
						res.getLong("workpackage_id"),
						res.getLong("assigned_user_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return tasks;
	}
	
	/**
	 * Selects all tasks, which a specific user is part of
	 * @param userId User to look up
	 * @return List of all tasks for user
	 */
	public List<Task> selectTasksForUser(long userId)
	{
		List<Task> tasks=new ArrayList<Task>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM users in_task, task WHERE users_in_task.task_id=task.task_id AND users_in_task.user_id="+userId,"Regular");
	
			while(res.next())
			{
				tasks.add(new Task(
						res.getLong("task.task_id"),
						res.getString("task.name"),
						res.getString("task.description"),
						res.getDate("task.deadline"),
						res.getString("task.status"),
						res.getDouble("task.time_booked"),
						res.getDouble("task.time_planned"),
						res.getLong("task.workpackage_id"),
						res.getLong("task.assigned_user_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return tasks;
	}
	
	/**
	 * Selects all tasks using condition
	 * @param condition where condition
	 * @return List of tasks using condition
	 */
	public List<Task> selectTaskWhere(String condition)
	{
		List<Task> tasks=new ArrayList<Task>();
		try 
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT * FROM task WHERE "+condition,"Regular");
			
			while(res.next())
			{
				tasks.add(new Task(
						res.getLong("task_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline"),
						res.getString("status"),
						res.getDouble("time_booked"),
						res.getDouble("time_planned"),
						res.getLong("workpackage_id"),
						res.getLong("assigned_user_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return tasks;
	}
	
	/**
	 * Insert new task
	 * @param t Task to insert
	 */
	public void insertTask(Task t)
	{
		String statement="INSERT INTO task VALUES (DEFAULT,\'"+t.getName()+"\',\'"+t.getDescription()+"\',\'"+t.getDeadline().toString()
				+"\',\'"+t.getStatus()+"\',\'"+t.getTimeBooked()+"\',\'"+t.getTimePlanned()+"\',\'"+t.getWorkpackageId()+"\',\'"+t.getUserId()+"\')";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Update task
	 * @param t Task to update
	 */
	public void updateTask(Task t)
	{
		String statement="UPDATE project SET name=\'"+t.getName()+"\',description=\'"+t.getDescription()
				+"\',deadline=\'"+t.getDeadline().toString()+"\',status=\'"+t.getStatus()+"\',time_booked=\'"+t.getTimeBooked()
				+"\',time_planned=\'"+t.getTimePlanned()+"\',workpackage_id=\'"+t.getWorkpackageId()
				+"\',assigned_user_id=\'"+t.getUserId()+"\' where task_id="+t.getId();
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Delete task
	 * @param t Task to delete
	 */
	public void deleteTask(Task t)
	{
		try
		{
			StatementExecutor.executeUpdate("DELETE FROM users_in_task WHERE task_id="+t.getId(), "Regular");
			StatementExecutor.executeUpdate("DELETE FROM task WHERE task_id="+t.getId(),"Regular");		
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Selects users role in project
	 * @param userId User Id
	 * @param projectId Project Id
	 * @return User role
	 */
	public String selectUserRoleInProject(long userId, long projectId)
	{
		String s="";
		try
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT role FROM user_in_project WHERE user_id="+userId+" AND project_id="+projectId,"Regular");
			res.next();
			s=res.getString("role");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		
		return s; 
	}
	
	/**
	 * Inserts user role for specific project
	 * @param userId User Id
	 * @param projectId Project Id
	 * @param role Role to set
	 */
	public void insertUserRoleInProject(long userId, long projectId, String role)
	{
		String statement="INSERT INTO user_in_project VALUES ("+userId+","+projectId+",'"+role+"')";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Updates user role for specific project
	 * @param userId User Id
	 * @param projectId Project Id
	 * @param role Role to update to
	 */
	public void updateUserRoleInProject(long userId, long projectId, String role)
	{
		String statement="UPDATE project SET role=\'"+role+"\' where project_id="+projectId+" AND userId="+userId;
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Deletes a user role for specific project
	 * @param userId User Id
	 * @param projectId Projects Id
	 */
	public void deleteUserRoleInProject(long userId, long projectId)
	{
		try
		{
			StatementExecutor.executeUpdate("DELETE FROM project WHERE user_id="+userId+" OR project_id="+projectId,"Regular");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Selects tPoint for heatmap
	 * @param projectId Project Id
	 * @return tPoint for Project
	 */
	public String selectTPoint(long projectId)
	{
		String s="";
		try
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT tpoint FROM heatmap WHERE project_id="+projectId,"Regular");
			res.next();
			s=res.getString("tpoint");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		
		return s; 
	}
	
	/**
	 * Inserts heatmap tPoint for a project
	 * @param projectId Project Id
	 * @param tPoint tPoint to set
	 */
	public void insertTPoint(long projectId, String tPoint)
	{
		String statement="INSERT INTO heatmap VALUES ('"+tPoint+"',"+projectId+")";
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Update heatmap tPoint for a project
	 * @param projectId Project Id
	 * @param tPoint tPoint to update to
	 */
	public void updateTPoint(long projectId, String tPoint)
	{
		String statement="UPDATE heatmap SET tpoint=\'"+tPoint+"\' where project_id="+projectId;
		
		try 
		{
			StatementExecutor.executeUpdate(statement,"Regular");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Deletes heatmap tPoint for a project
	 * @param projectId Project Id
	 */
	public void deleteTPoint(long projectId)
	{
		try
		{
			StatementExecutor.executeUpdate("DELETE FROM heatmap WHERE project_id="+projectId,"Regular");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Performs password check for user
	 * @param username User 
	 * @param password Password
	 * @return result of password check
	 */
	public boolean checkPassword(String username, String password)
	{
		String s="";
		try
		{
			ResultSet res=StatementExecutor.executeQuery("SELECT password FROM authentication WHERE username='"+username+"'","Password");
			res.next();
			s=res.getString("password");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		
		String pwHash=Utilities.createHash(password);
		
		return s.equals(pwHash); 
	}
	
	/**
	 * Saves password for user to password database
	 * @param username User
	 * @param password Password
	 */
	public void savePassword(String username, String password)
	{
		String pwHash=Utilities.createHash(password);
		
		try 
		{
			StatementExecutor.executeUpdate("INSERT INTO authentication VALUES (\'"+username+"\',\'"+pwHash+"\')","Password");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * Deletes password entry for user
	 * @param username username of user
	 */
	public void deletePassword(String username)
	{
		try
		{
			StatementExecutor.executeUpdate("DELETE FROM authentication WHERE username='"+username+"'", "Password");
		}
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
	}
	
	/**
	 * sums up time booked for workpackage
	 * @param workpackageId Workpackage Id
	 * @return sum of time booked
	 */
	public double selectTimeBookedForWorkpackage(long workpackageId)
	{
		String statement="SELECT sum(time_booked) as sum from task WHERE workpackage_id="+workpackageId;
		
		try 
		{
			ResultSet res=StatementExecutor.executeQuery(statement,"Regular");
			res.next();
			return res.getDouble("sum");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * sums up time booked for project
	 * @param projectId Project Id
	 * @return sum of time booked
	 */
	public double selectTimeBookedForProject(long projectId)
	{
		String statement="SELECT sum("
				+ "(SELECT sum(time_booked) as sum from task WHERE workpackage_id=workpackage.workpackage_id)"
				+ ") from workpackage where project_id="+projectId;
		try 
		{
			ResultSet res=StatementExecutor.executeQuery(statement,"Regular");
			res.next();
			return res.getDouble("sum");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * sums up time planned for workpackage
	 * @param workpackageId Workpackage Id
	 * @return sum of time planned
	 */
	public double selectTimePlannedForWorkpackage(long workpackageId)
	{
		String statement="SELECT sum(time_planned) as sum from task WHERE workpackage_id="+workpackageId;
		
		try 
		{
			ResultSet res=StatementExecutor.executeQuery(statement,"Regular");
			res.next();
			return res.getDouble("sum");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return 0;
	}
	
	/**
	 * sums up time planned for project
	 * @param projectId Project Id
	 * @return sum of time planned
	 */
	public double selectTimePlannedForProject(long projectId)
	{
		String statement="SELECT sum("
				+ "(SELECT sum(time_planned) as sum from task WHERE workpackage_id=workpackage.workpackage_id)"
				+ ") from workpackage where project_id="+projectId;
		try 
		{
			ResultSet res=StatementExecutor.executeQuery(statement,"Regular");
			res.next();
			return res.getDouble("sum");
		} 
		catch (SQLException e) 
		{
			Logger.log(e.getMessage());
		}
		return 0;
	}
	
}
