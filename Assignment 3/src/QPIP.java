
/**
 * The Class QPIP, child of Deductions.
 */
public class QPIP extends Deductions{
	
	/* *
	 * 0.559% until 385.71$
	 * 
	 */
	public void calcTax(){
		if (this.getGross()*0.00559 <= 385.71)
			this.setDeduction(this.getGross()*0.00559);
		else if (this.getGross()*0.00559 > 385.71)
			this.setDeduction(385.71);
	}
	
	/**
	 * Instantiates a new QPIP object.
	 *
	 * @param d the annual gross salary
	 */
	public QPIP(double d){
		this.setGross(d);
	}
}
