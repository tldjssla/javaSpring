package logic;

public class User {
	private String userId;
	private String userName;
	private String password;
	private String postCode;
	private String address;
	private String email;
	private String job;
	private String birthday;

	public User() {
		super();
	}

	public User(String userId, String userName, String password, String postCode, String address, String email,
			String job, String birthday) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.postCode = postCode;
		this.address = address;
		this.email = email;
		this.job = job;
		this.birthday = birthday;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", postCode=" + postCode
				+ ", address=" + address + ", email=" + email + ", job=" + job + ", birthday=" + birthday + "]";
	}

}
