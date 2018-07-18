package Model;

import java.sql.Date;

/**
 * Transfer Object for Tasks
 * @author Raphael Albiez
 *
 */
public class Task {
	private long id;
	private String name;
	private String description;
	private Date deadline;
	private String status;
	private double timeBooked;
	private double timePlanned;
	private long workpackageId;
	private long userId;
	
	/**
	 * Creates new Task
	 * @param idp Task Id
	 * @param namep Name
	 * @param descriptionp Description
	 * @param deadlinep Deadline
	 * @param statusp Status
	 * @param timeBookedp Time booked
	 * @param timePlannedp Time planned
	 * @param workpackageIdp Workpackage Id
	 * @param userIdp User Id
	 */
	public Task(long idp, String namep, String descriptionp, Date deadlinep, String statusp, double timeBookedp, double timePlannedp, long workpackageIdp, long userIdp)
	{
		this.setId(idp);
		this.setName(namep);
		this.setDescription(descriptionp);
		this.setDeadline(deadlinep);
		this.setStatus(statusp);
		this.setTimeBooked(timeBookedp);
		this.setTimePlanned(timePlannedp);
		this.setWorkpackageId(workpackageIdp);
		this.setUserId(userIdp);
	}

	/**
	 * Returns Task Id
	 * @return Task Id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets Task Id
	 * @param id Task Id
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
	 * Returns Status
	 * @return Status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets Status
	 * @param status Status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Returns Time Booked
	 * @return Time Booked
	 */
	public double getTimeBooked() {
		return timeBooked;
	}

	/**
	 * Sets Time Booked
	 * @param timeBooked Time Booked
	 */
	public void setTimeBooked(double timeBooked) {
		this.timeBooked = timeBooked;
	}

	/**
	 * Returns Time Planned
	 * @return Time Planned
	 */
	public double getTimePlanned() {
		return timePlanned;
	}

	/**
	 * Sets Time Planned
	 * @param timePlanned Time Planned
	 */
	public void setTimePlanned(double timePlanned) {
		this.timePlanned = timePlanned;
	}

	/**
	 * Returns Workpackage Id
	 * @return Workpackage Id
	 */
	public long getWorkpackageId() {
		return workpackageId;
	}

	/**
	 * Sets Workpackage Id
	 * @param workpackageId Workpackage Id
	 */
	public void setWorkpackageId(long workpackageId) {
		this.workpackageId = workpackageId;
	}

	/**
	 * Returns User Id
	 * @return User Id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Sets User Id
	 * @param userId User Id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
