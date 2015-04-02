
/**
 * The Class RRQ, child of Deductions.
 */
public class RRQ extends Deductions{
	
	/* *
	 * 
	 * Tax : 5.175% until 2535.75$
	 */
	public void calcTax(){
		if (this.getGross()*0.05175 <= 2535.75)
			this.setDeduction(this.getGross()*0.05175);
		else this.setDeduction(2535.75);
	}
	
	/**
	 * Instantiates a new RRQ object.
	 *
	 * @param d the annual gross salary
	 */
	public RRQ(double d){
		this.setGross(d);
	}
}
