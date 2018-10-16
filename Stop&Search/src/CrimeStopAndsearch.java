

public class CrimeStopAndsearch {

	public String csv;
	public String type;
	public String Date;
	public String month;
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

		return type + " " + Date + " " + month + " " + Part_of_a_policing_operation + " " + Policing_operation + " "
				+ latitude + " " + longitude + " " + Age_range + " " + Self_defined_ethnicity + " "
				+ Officer_defined_ethnicity + " " + Legislation + " " + Object_of_search + " " + Outcome + " "
				+ Outcome_linked_to_object_of_search + " " + Removal_of_more_than_just_outer_clothing;

	}

	public CrimeStopAndsearch(String csv) {
		String[] split = csv.split(",", 15);
		for (int i = 0; i < split.length;) {
			if (split[i] == null || split[i] == "" || split[i].isEmpty()) {

				split[i] = "TBD";
			}
			i++;
		}
		type = split[0];
		Date = split[1];
		month = split[2];
		Part_of_a_policing_operation = split[3];
		Policing_operation = split[4];
		latitude = split[5];
		longitude = split[6];
		Age_range = split[7];
		Self_defined_ethnicity = split[8];
		Officer_defined_ethnicity = split[9];
		Legislation = split[10];
		Object_of_search = split[11];
		Outcome = split[12];
		Outcome_linked_to_object_of_search = split[13];
		Removal_of_more_than_just_outer_clothing = split[14];
	}

}
