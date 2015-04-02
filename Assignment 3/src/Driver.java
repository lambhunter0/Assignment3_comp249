import java.util.*;
import java.io.*;
//George Theophanous
//7400578
/**
 * The Class Driver.
 */
public class Driver {
	
	/**
	 * The main method This program read in a file "payroll.txt" which contains employee information.
	 * An input is valid when the employee number, first name, last name, hourly wage fall into the correct criteria.
	 * Any one invalid element will cause a full line to be rejected and printed in the "error.txt" file.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args){
		PrintWriter write = null;
		PrintWriter errorWrite = null;
		ArrayList<Employee> myList = new ArrayList<Employee>();
		ArrayList<String> errorList = new ArrayList<String>();
		try (Scanner read = new Scanner(new FileInputStream("payroll.txt"))){
			long Num = 0;
			String first = null;
			String last = null;
			double hours = 0;
			double wage = 0;
			String errNum = null;
			String errFirst = null;
			String errLast = null;
			String errHours = null;
			String errWage = null;
			int counter = 0;
			//counter to know where I am so that my catch for input mismatch will work properly
			while (read.hasNext()){
				try{
					counter = 0;
					Num = read.nextLong();
					counter = 1;
					first = read.next();
					counter = 2;
					last = read.next();
					counter = 3;
					hours = read.nextDouble();
					counter = 4;
					wage = read.nextDouble();
					if (wage < 10.35)
						throw new MinimumWageException();
					else 
						myList.add(new Employee(first, last, Num, hours, wage));
				}
				
				catch(MinimumWageException w){
					errorList.add(Num+" "+first+" "+last+" "+hours+" "+wage);
				}
				
				catch (InputMismatchException w){
					switch(counter){
						case 0: {
							errNum = read.next();
							errFirst = read.next();
							errLast = read.next();
							errHours = read.next();
							errWage = read.next();
							errorList.add(errNum+" "+errFirst+" "+errLast+" "+errHours+" "+errWage);
							break;
						}
						case 1: {
							errNum =""+Num;
							errFirst = read.next();
							errLast = read.next();
							errHours = read.next();
							errWage = read.next();
							errorList.add(errNum+" "+errFirst+" "+errLast+" "+errHours+" "+errWage);
							break;
						}
						case 2: {
							errNum =""+Num;
							errFirst = ""+first;
							errLast = read.next();
							errHours = read.next();
							errWage = read.next();
							errorList.add(errNum+" "+errFirst+" "+errLast+" "+errHours+" "+errWage);
							break;
						}
						case 3: {
							errNum =""+Num;
							errFirst = ""+first;
							errLast =""+last;
							errHours = read.next();
							errWage = read.next();
							errorList.add(errNum+" "+errFirst+" "+errLast+" "+errHours+" "+errWage);
							break;
						}
						case 4: {
							errNum =""+Num;
							errFirst = ""+first;
							errLast =""+last;
							errHours =""+hours;
							errWage = read.next();
							errorList.add(errNum+" "+errFirst+" "+errLast+" "+errHours+" "+errWage);
							break;
						}
					}
						
				}
			//while bracket	
			}
			
		}
		catch (FileNotFoundException w){
			System.err.println("File not found.");
		}
		try {
			write = new PrintWriter(new FileOutputStream("report.txt"));
			errorWrite = new PrintWriter(new FileOutputStream("error.txt"));
			write.printf("Number"+"     "+"First Name"+"   "+"Last Name"+"    "+"Gross Sal"+"  "+"Deductions"+" "+"Net Sal"+"\n");
			write.println("----------------------------------------------------------------------");
			for(int i =0; i < myList.size();i++){
				myList.get(i).setAnualGross();
				myList.get(i).setWeeklyGross();
				myList.get(i).pt().calcTax();
				myList.get(i).ft().calcTax();
				myList.get(i).rrq().calcTax();
				myList.get(i).ei().calcTax();
				myList.get(i).qpip().calcTax();
				myList.get(i).addDeductions();
				myList.get(i).setNetSalary();
				write.printf("%-10s %-12s %-12s %-10.2f %-10.2f %-10.2f %n",myList.get(i).getEmployeeNumber(),myList.get(i).getFirst(),myList.get(i).getLast(),myList.get(i).getAnnualGross(),myList.get(i).getAllDeductions(),myList.get(i).getNetSalary());
			}
			
			errorWrite.println("The following inputs were invalid:");
			for(int i =0; i < errorList.size();i++){
				errorWrite.println(errorList.get(i));
			}
			
		}
		catch(FileNotFoundException w){
			System.err.println("You dun goofed");
		}
		finally{
			write.close();
			errorWrite.close();
		}
		System.out.println("Number of lines read: "+(myList.size()+errorList.size()));
		System.out.println("Number of lines kept: "+myList.size());
		System.out.println("Number of lines rejected: "+errorList.size());
	}
}
