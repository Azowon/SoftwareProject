package Model;

import java.sql.Date;

/**
 * Transfer Object for Workpackages
 * @author Raphael Albiez
 *
 */
public class Workpackage {
	private long id;
	private String name;
	private String description;
	private Date deadline;
	private long projectId;
	
	/**
	 * Creates new Workpackage
	 * @param idp Workpackage Id
	 * @param namep Name
	 * @param descriptionp Description
	 * @param deadlinep Deadline
	 * @param projectIdp Project Id
	 */
	public Workpackage(long idp, String namep, String descriptionp, Date deadlinep, long projectIdp)
	{
		this.setId(idp);
		this.setName(namep);
		this.setDescription(descriptionp);
		this.setDeadline(deadlinep);	
		this.setProjectId(projectIdp);
	}

	/**
	 * Returns Workpackage Id
	 * @return Workpackage Id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets Workpackage Id
	 * @param id Workpackage Id
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

	/**
	 * Returns Project Id
	 * @return Project Id
	 */
	public long getProjectId() {
		return projectId;
	}

	/**
	 * Sets Project Id
	 * @param projectId Project Id
	 */
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
}
