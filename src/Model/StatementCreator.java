package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			ResultSet res=StatementExecutor.execute("SELECT * FROM users");
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM users_in_task, users WHERE users_in_task.user_id= users.user_id AND task_id="+taskId);
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM users WHERE "+condition);
			
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
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM users WHERE user_id="+u.getId());
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM project");
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM project WHERE "+condition);
			
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
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM project WHERE project_id="+p.getId());
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM workpackage");
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM workpackage WHERE "+condition);
			
			while(res.next())
			{
				workpackages.add(new Workpackage(
						res.getLong("workpackaget_id"),
						res.getString("name"),
						res.getString("description"),
						res.getDate("deadline"),
						res.getLong("project_id")
						));
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM project WHERE workpackage_id="+w.getId());
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM task");
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM users in_task, task WHERE users_in_task.task_id=task.task_id AND users_in_task.user_id="+userId);
			
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
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT * FROM task WHERE "+condition);
			
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
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM project WHERE task_id="+t.getId());
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT role FROM user_in_project WHERE user_id="+userId+" AND project_id="+projectId);
			res.next();
			s=res.getString("role");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM project WHERE user_id="+userId+" AND project_id="+projectId);
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			ResultSet res=StatementExecutor.execute("SELECT tpoint FROM heatmap WHERE project_id="+projectId);
			res.next();
			s=res.getString("tpoint");
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute(statement);
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
			StatementExecutor.execute("DELETE FROM heatmap WHERE project_id="+projectId);
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	
}
