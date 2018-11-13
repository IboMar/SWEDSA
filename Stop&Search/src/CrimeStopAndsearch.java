
/**
 * This will be the main class that we will use to output and manipulate data
 */
public class CrimeStopAndsearch {

	public String totalTempString;
	public int Successful;
	public int partially_successful;
	public int unsuccessful;
	public String ethnic;
	public final String SEP = ",";
	public String type;
	public String Date;
	public String Part_of_a_policing_operation;
	public String Policing_operation;
	public Float latitude;
	public Float longitude;
	public String Gender;
	public String Age_range;
	public String Self_defined_ethnicity;
	public String Officer_defined_ethnicity;
	public String Legislation;
	public String Object_of_search;
	public Boolean Outcome;
	public String Outcome_linked_to_object_of_search;
	public Boolean Removal_of_more_than_just_outer_clothing;
	public int total;
	
	public String toCSVString() {

		return type + ", " + Date + ", " + Part_of_a_policing_operation + ", " + Policing_operation + ", " + latitude
				+ " " + longitude + " " + Age_range + " " + Self_defined_ethnicity + " " + Officer_defined_ethnicity
				+ ", " + Legislation + ", " + Object_of_search + ", " + Outcome + ", "
				+ Outcome_linked_to_object_of_search + ", " + Removal_of_more_than_just_outer_clothing;

	}

	/**
	 * Constructor to hold each unique column from csv Doc into it's unique variable
	 * so that we can refer back to output or manipulate data
	 * 
	 * @param csv This will be a string from readnext line that splits by
	 */

	public CrimeStopAndsearch(String csv) {
		String[] csvParts = csv.split(SEP, -1);
		int i = 0;

		type = csvParts[i++];
		Date = csvParts[i++];
		Part_of_a_policing_operation = csvParts[i++];
		Policing_operation = csvParts[i++];
		if(csvParts[i] !=null && csvParts[i].length()>0) {
			
		latitude = Float.parseFloat(csvParts[i++]);}
		else {latitude = null; i++;}
		if(csvParts[i] !=null && csvParts[i].length()>0) {
			longitude = Float.parseFloat(csvParts[i++]);}
		else {longitude = null; i++;}
		Gender = csvParts[i++];
		Age_range = csvParts[i++];
		Self_defined_ethnicity = csvParts[i++];
		Officer_defined_ethnicity = csvParts[i++];
		Legislation = csvParts[i++];
		Object_of_search = csvParts[i++];
		if(csvParts[i] !=null && csvParts[i].length()>0) {
		Outcome = Boolean.parseBoolean(csvParts[i++]);
		}else {Outcome = null; i++;}
		
		Outcome_linked_to_object_of_search = csvParts[i++];
		if(csvParts[i] !=null && csvParts[i].length()>0) {
		Removal_of_more_than_just_outer_clothing = Boolean.parseBoolean(csvParts[i++]);
		}else {Removal_of_more_than_just_outer_clothing =null; i++;}
	}

	/**
	 * This will be the main class that we will use to output and manipulate data
	 */
	public CrimeStopAndsearch(String totalTemp, int temptotal) {
		totalTempString = totalTemp;
		total = temptotal;
	}
	
	
	public CrimeStopAndsearch(String legislationtemp, int successfultemp, int unsuccessfultemp, int partialtemp) {
		Legislation = legislationtemp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}

	public CrimeStopAndsearch(String ethictemp, String temp, int successfultemp, int unsuccessfultemp,
			int partialtemp) {
		ethnic = ethictemp;
		Legislation = temp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}


	public int getTotal() {
		return total;
	}
	public String highestTotalLeg() {
		return totalTempString + " : " + " Total: " + total;	
	}
	public String highestTotalethnic() {
		return totalTempString + " : " + " Total: " + total;	
	}
	
	public String highestSucessLeg() {
		return Legislation + " : " + " Successful: " + Successful + " partially successful: " + partially_successful
				+ " unsuccessful: " + unsuccessful;	
	}
	public String toString2() {
		return ethnic + " : " + Legislation + " Successful: " + Successful + " partially successful: " + partially_successful
				+ " unsuccessful: " + unsuccessful;
	}
	
	public String getDate() {
		return Date;
	}
	public int getSuccessful() {
		return Successful;
	}


}
