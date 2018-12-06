package V2;
/**
 * This will be the main class that we will use to output and manipulate data usually will be within an arrayList
 */
public class CrimeStopAndsearch {

	public String CrimeType;
	public int Successful;
	public int partially_successful;
	public int unsuccessful;
	public String ethnic;
	public final String sep = ",";
	public final String gap = " ";
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
	
	/** This method is used to print out all attributes within the object usually used looping through the list and outputting data
	 */
	public String toCSVString() {
		String unfilteredCSV = type + sep + gap + Date + sep + gap + Gender + sep + gap + Part_of_a_policing_operation + sep + gap + Policing_operation + sep + gap + latitude
				+ gap + longitude + gap + Age_range + gap + Self_defined_ethnicity + gap + Officer_defined_ethnicity
				+ sep + gap + Legislation + sep + gap + Object_of_search+ sep + gap + Outcome + sep + gap
				+ Outcome_linked_to_object_of_search + sep + gap + Removal_of_more_than_just_outer_clothing;
		 String filteredCSV = unfilteredCSV.replace("null", "Unspecified").replace(", ,", ", Unspecified,");

		return String.format("|%1$-26s|%2$-26s|%3$-12s|%4$-12s|%5$-12f|%6$-12f|%7$-8s|%8$-8s|%9$-58s|%10$-6s|%11$-50s|%12$-14s|%13$-32s|%14$-6b|%15$-6b|",
				type,Date,Part_of_a_policing_operation,Policing_operation,latitude,longitude,Gender,Age_range,Self_defined_ethnicity,Officer_defined_ethnicity,
				Legislation,Object_of_search,Outcome,Outcome_linked_to_object_of_search,Removal_of_more_than_just_outer_clothing);

	}

	/**
	 * Constructor to hold each unique column from csv Doc into it's unique variable
	 * so that we can refer back to output or manipulate data
	 * 
	 * @param csv This will be a string from readnext line that splits by
	 */

	public CrimeStopAndsearch(String csv) {
		String[] csvParts = csv.split(sep, -1);
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
	 * This constructor is used to create an object for the highest legislation.
	 * @param crime
	 * @param Counter
	 */
	public CrimeStopAndsearch(String Crime, int Counter) {
		CrimeType = Crime;
		total = Counter;
	}
	
	/**
	 * This constructor is used to construct an object for the highest successful legislation.
	 * @param legislationtemp
	 * @param successfultemp
	 * @param unsuccessfultemp
	 * @param partialtemp
	 */
	public CrimeStopAndsearch(String legislationtemp, int successfultemp, int unsuccessfultemp, int partialtemp) {
		Legislation = legislationtemp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}


	/** used in comparator to compare total crimes
	 * @return total int counter of crimes
	 */
	public int getTotal() {
		return total;
	}
	/** used to print out highest total crimes
	 * @return CrimeType String of this current crime type, total int counter of crimes
	 */
	public String highestTotal() {
		return CrimeType + " : " + " Total: " + total;	
	}
	
	/** used to print out the highest successful legislation
	 * @return A String ready to display highest successful Legislation
	 */
	public String highestSucessLeg() {
		return Legislation + " : " + " Successful: " + Successful + " partially successful: " + partially_successful
				+ " unsuccessful: " + unsuccessful;	
	}
	
	
	/** used in comparator to compare dates
	 * @return Date String
	 */
	public String getDate() {
		return Date;
	}
	/** used in comparator to compare successful crimes
	 * @return Successful int
	 */
	public int getSuccessful() {
		return Successful;
	}
	/** used in comparator to compare Legislation
	 * @return Legislation String
	 */
	public String getLegislation() {
		return Legislation;
	}

}
