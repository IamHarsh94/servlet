package jdbcOperations;

public class EmployeeData {

	private String Fname;
	private String Lname;
	private String Email;
	private int Password;
	private float salary;
	
	public EmployeeData(){
		
	}

	public EmployeeData(String fname, String lname, String email, int password, float salary) {
		super();
		Fname = fname;
		Lname = lname;
		Email = email;
		Password = password;
		this.salary = salary;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
