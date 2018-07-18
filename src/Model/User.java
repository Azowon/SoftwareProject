package Model;

/**
 * Tranfer Object for Users
 * @author Raphael Albiez
 *
 */
public class User {
	private long id;
	private String username;
	private String firstname;
	private String lastname;
	private String description;
	private String team;
	private String role;
	
	/**
	 * Creates a new User
	 * @param idp User Id
	 * @param usernamep Username
	 * @param firstnamep Firstname
	 * @param lastnamep Lastname
	 * @param descriptionp Description
	 * @param rolep User Role
	 * @param teamp Team
	 */
	public User(long idp, String usernamep, String firstnamep, String lastnamep, String descriptionp, String rolep, String teamp)
	{
		this.setId(idp);
		this.setUsername(usernamep);
		this.setFirstname(firstnamep);
		this.setLastname(lastnamep);
		this.setDescription(descriptionp);
		this.setTeam(teamp);
		this.setRole(rolep);
	}

	/**
	 * Returns User Id
	 * @return User Id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets User Id
	 * @param id User Id
	 */
	private void setId(long id) {
		this.id = id;
	}

	/**
	 * Returns Username
	 * @return Username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets Username
	 * @param username Username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Returns Firstname
	 * @return Firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets Firstname
	 * @param firstname Firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Returns Lastname
	 * @return Lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets Lastname
	 * @param lastname Lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * Returns Team
	 * @return Team
	 */
	public String getTeam() {
		return team;
	}

	/**
	 * Sets Team
	 * @param team Team
	 */
	public void setTeam(String team) {
		this.team = team;
	}

	/**
	 * Returns User Role
	 * @return User Role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets User Role
	 * @param role User Role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
