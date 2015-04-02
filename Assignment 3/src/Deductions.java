
/**
 * The abstract Class Deductions.
 */
public abstract class Deductions {
	
	/** The deduction to the salary. */
	private double deduction;
	
	/** The annual gross of the employee. */
	private double annualGross;
	
	/**
	 * Sets the gross annual salary.
	 *
	 * @param sal the new gross
	 */
	public void setGross(double sal){
		this.annualGross = sal;
	}
	
	/**
	 * Sets the deduction to the salary.
	 *
	 * @param d the new deduction
	 */
	public void setDeduction(double d){
		this.deduction = d;
	}
	
	/**
	 * Gets the gross annual salary.
	 *
	 * @return the gross
	 */
	public double getGross(){
		return this.annualGross;
	}
	
	/**
	 * Gets the deduction tothe salary.
	 *
	 * @return the deduction
	 */
	public double getDeduction(){
		return this.deduction;
	}
	
	/**
	 * Calculates tax deductions, different depending on which class implements this abstract method.
	 */
	public abstract void calcTax();

}
