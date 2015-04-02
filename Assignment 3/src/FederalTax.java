
/**
 * The Class FederalTax, child of Deductions.
 */
public class FederalTax extends Deductions{
	
	/* *
	 * Tax brackets: 15%, 15%+22%, 15%+22%+26%, 15%+22%+26%+29%
	 * 
	 */
	public void calcTax(){
		if (this.getGross() <= 43953)
			this.setDeduction(this.getGross()*0.15);
		else if (this.getGross() > 43953 && this.getGross() <= 87907)
			this.setDeduction((43953*0.15)+(this.getGross()-43953)*0.22);
		else if (this.getGross() > 87907 && this.getGross() <= 136270)
			this.setDeduction((43953*0.15)+(43954*0.22)+(this.getGross()-43953-439554)*0.26);
		else if (this.getGross() > 136270)
			this.setDeduction((43953*0.15)+(43954*0.22)+(48363*0.26)+(this.getGross()-43953-439554-48363)*0.29);
	}
	
	/**
	 * Instantiates a new federal tax object.
	 *
	 * @param d the annual gross salary
	 */
	public FederalTax(double d){
		this.setGross(d);
	}

}
