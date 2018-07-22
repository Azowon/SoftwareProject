package Model;

import java.sql.Date;
import java.util.List;

import Util.Settings;
import Util.SettingsFileNotExistingException;

public class testClassDeleteIfNecessary {

	public static void main(String[] args) {

		StatementCreator st=new StatementCreator();
		
		Project p= new Project(-1,"First","asdf",new Date(0));
		Project p2= new Project(-1,"Second","asdf",new Date(0));
		st.insertProject(p);
		st.insertProject(p2);
		}

}
