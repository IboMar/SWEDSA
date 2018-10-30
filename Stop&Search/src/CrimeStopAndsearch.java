


public class CrimeStopAndsearch {


	
	public final String SEP = ",";
	public String type;
	public String Date;
	// public String month;
	public String Part_of_a_policing_operation;
	public String Policing_operation;
	public String latitude;
	public String longitude;
	public String Gender;
	public String Age_range;
	public String Self_defined_ethnicity;
	public String Officer_defined_ethnicity;
	public String Legislation;
	public String Object_of_search;
	public String Outcome;
	public String Outcome_linked_to_object_of_search;
	public String Removal_of_more_than_just_outer_clothing;

	public String toCSVString() {

		return type + ", " + Date + ", " + Part_of_a_policing_operation + ", " + Policing_operation + ", " + latitude
				+ " " + longitude + " " + Age_range + " " + Self_defined_ethnicity + " " + Officer_defined_ethnicity
				+ ", " + Legislation + ", " + Object_of_search + ", " + Outcome + ", "
				+ Outcome_linked_to_object_of_search + ", " + Removal_of_more_than_just_outer_clothing;

	}

	public CrimeStopAndsearch(String csv) {
		String[] csvParts = csv.split(SEP, -1);
		int i = 0;

		type = csvParts[i++];
		Date = csvParts[i++];
		Part_of_a_policing_operation = csvParts[i++];
		Policing_operation = csvParts[i++];
		latitude = csvParts[i++];
		longitude = csvParts[i++];
		Gender = csvParts[i++];
		Age_range = csvParts[i++];
		Self_defined_ethnicity = csvParts[i++];
		Officer_defined_ethnicity = csvParts[i++];
		Legislation = csvParts[i++]; 
		Object_of_search = csvParts[i++];
		Outcome = csvParts[i++];
		Outcome_linked_to_object_of_search = csvParts[i++];
		Removal_of_more_than_just_outer_clothing = csvParts[i++];
	}
	
	
	
	

}
