
/**
 * The Class EI, child of Deductions.
 */
public class EI extends Deductions{
	
	/* *
	 * 1.53$ each 100$ salary until 743.58$
	 */
	public void calcTax(){
		if ((this.getGross()/100)-((this.getGross()/100)%1)*1.53 <= 743.58)
			this.setDeduction(((this.getGross()/100)-((this.getGross()/100)%1))*1.53);
		else if (((this.getGross()/100)-((this.getGross()/100)%1))*1.53 <= 743.58)
			this.setDeduction(743.58);
	}
	
	/**
	 * Instantiates a new EI object.
	 *
	 * @param d the annual gross salary
	 */
	public EI(double d){
		this.setGross(d);
	}
}
