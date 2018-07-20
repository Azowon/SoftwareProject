package Model;

import java.util.List;

public class testClassDeleteIfNecessary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StatementCreator st=new StatementCreator();
		
		List<Project> tasks=st.selectProjects();
		for(Project t : tasks)
		{
			if(t.getId()==1)
				st.deleteProject(t);
		}
	}

}
