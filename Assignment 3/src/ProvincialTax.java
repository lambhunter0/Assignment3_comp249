
/**
 * The Class ProvincialTax, child of deductions.
 */
public class ProvincialTax extends Deductions{
	
	/* *
	 * 
	 * tax brackets: 16%, 20%, 24%, 25.75%
	 */
	public void calcTax(){
		if (this.getGross() <= 41495)
			this.setDeduction(this.getGross()*0.16);
		else if (this.getGross()> 41495 && this.getGross() <= 82985)
			this.setDeduction(this.getGross()*0.20);
		else if (this.getGross() > 82985 && this.getGross() <= 100970)
			this.setDeduction(this.getGross()*0.24);
		else if (this.getGross() > 100970)
			this.setDeduction(this.getGross()*0.2575);
	}
	
	/**
	 * Instantiates a new provincial tax object.
	 *
	 * @param d the annual gross salary
	 */
	public ProvincialTax(double d){
		this.setGross(d);
	}
}
