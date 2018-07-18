package Model;

import java.sql.Date;

/**
 * Transfer Object for Projects
 * @author Raphael Albiez
 *
 */
public class Project {
	private long id;
	private String name;
	private String description;
	private Date deadline;
	
	/**
	 * Creates new Project
	 * @param idp Project Id
	 * @param namep Name
	 * @param descriptionp Description
	 * @param deadlinep Deadline
	 */
	public Project(long idp, String namep, String descriptionp, Date deadlinep)
	{
		this.setId(idp);
		this.setName(namep);
		this.setDescription(descriptionp);
		this.setDeadline(deadlinep);	
	}

	/**
	 * Returns Project Id
	 * @return Project Id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets Project Id
	 * @param id Project Id
	 */
	private void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns Name
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets Name
	 * @param name Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns Description
	 * @return Description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets Description
	 * @param description Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns Deadline
	 * @return Deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Sets Deadline
	 * @param deadline Deadline
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
}
