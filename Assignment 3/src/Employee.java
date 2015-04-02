
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The employee number. */
	private long employeeNumber;
	
	/** The hours worked in a week. */
	private double hours;
	
	/** The hourly wage. */
	private double wage;
	
	/** The annual gross salary. */
	private double annualGross;
	
	/** The weekly gross salary. */
	private double weeklyGross;
	
	/** The provincial tax deduction. */
	private ProvincialTax pt;
	
	/** The federal tax deduction. */
	private FederalTax ft;
	
	/** The RRQ tax deduction. */
	private RRQ rrq;
	
	/** The EI tax deduction. */
	private EI ei;
	
	/** The QPIP tax deduction. */
	private QPIP qpip;
	
	/** The total tax deductions. */
	private double allDeductions;
	
	/** The net salary. */
	private double netSalary;
	
	/**
	 * Get the provincial tax object.
	 *
	 * @return the provincial tax
	 */
	public ProvincialTax pt(){
		return this.pt;
	}
	
	/**
	 * Get the Federal tax object.
	 *
	 * @return the federal tax
	 */
	public FederalTax ft(){
		return this.ft;
	}
	
	/**
	 * Get the RRQ object.
	 *
	 * @return the rrq
	 */
	public RRQ rrq(){
		return this.rrq;
	}
	
	/**
	 * get the EI object.
	 *
	 * @return the ei
	 */
	public EI ei(){
		return this.ei;
	}
	
	/**
	 * Ge thte QPIP object.
	 *
	 * @return the qpip
	 */
	public QPIP qpip(){
		return this.qpip;
	}
	
	/**
	 * Gets the net salary.
	 *
	 * @return the net salary
	 */
	public double getNetSalary(){
		return this.netSalary;
	}
	
	/**
	 * Sets the net salary from the annual gross salary and from the tax deductions.
	 */
	public void setNetSalary(){
		this.netSalary = this.annualGross - this.allDeductions;
	}
	
	/**
	 * Gets the total tax deductions.
	 *
	 * @return all deductions
	 */
	public double getAllDeductions(){
		return this.allDeductions;
	}
	
	/**
	 * Calculates the total tax deductions.
	 */
	public void addDeductions(){
		this.allDeductions = this.pt.getDeduction()+this.ft.getDeduction()+this.rrq.getDeduction()+this.ei.getDeduction()+this.qpip.getDeduction();
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param name the new first
	 */
	public void setFirst(String name){
		this.firstName = name;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param name the new last
	 */
	public void setLast(String name){
		this.lastName = name;
	}
	
	/**
	 * Sets the employee number.
	 *
	 * @param number the new employee number
	 */
	public void setEmployeeNumber(long number){
		this.employeeNumber = number;
	}
	
	/**
	 * Sets the hours worked in a week.
	 *
	 * @param h the new hours
	 */
	public void setHours(double h){
		this.hours = h;
	}
	
	/**
	 * Sets the hourly wage.
	 *
	 * @param w the new wage
	 */
	public void setWage(double w){
		this.wage =w;
	}
	
	/**
	 * Sets the anual gross salary.
	 */
	public void setAnualGross(){
		this.annualGross = this.getHours()*this.getWage()*52;
		this.pt = new ProvincialTax(annualGross);
		this.ft = new FederalTax(annualGross);
		this.ei = new EI(annualGross);
		this.qpip = new QPIP(annualGross);
		this.rrq = new RRQ(annualGross);
	}
	
	/**
	 * Sets the weekly gross salary.
	 */
	public void setWeeklyGross(){
		this.weeklyGross = this.getHours()*this.getWage();
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first
	 */
	public String getFirst(){
		return this.firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last
	 */
	public String getLast(){
		return this.lastName;
	}
	
	/**
	 * Gets the employee number.
	 *
	 * @return the employee number
	 */
	public long getEmployeeNumber(){
		return this.employeeNumber;
	}
	
	/**
	 * Gets the hours worked in a week.
	 *
	 * @return the hours
	 */
	public double getHours(){
		return this.hours;
	}
	
	/**
	 * Gets the hourly wage.
	 *
	 * @return the wage
	 */
	public double getWage(){
		return this.wage;
	}
	
	/**
	 * Gets the weekly gross salary.
	 *
	 * @return the weekly gross salary
	 */
	public double getWeeklyGross(){
		return this.weeklyGross;
	}
	
	/**
	 * Gets the annual gross salary.
	 *
	 * @return the annual gross salary
	 */
	public double getAnnualGross(){
		return this.annualGross;
	}
	
	/* *
	 * 
	 * toString 
	 */
	public String toString(){
		String res = "";
		res += this.employeeNumber+"\t"+this.firstName+"\t"+this.lastName+"\t"+this.annualGross+"\t"+this.allDeductions+"\t"+this.netSalary;
		return res;
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param first the first name
	 * @param last the last name
	 * @param num the employee number
	 * @param hours the hours worked in a week
	 * @param wage the hourly wage
	 */
	public Employee(String first, String last, long num, double hours, double wage){
		this.firstName = first;
		this.lastName = last;
		this.employeeNumber = num;
		this.hours = hours;
		this.wage = wage;
	}
}
