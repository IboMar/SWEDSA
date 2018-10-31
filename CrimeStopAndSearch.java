
public class CrimeStopAndSearch {


	
	public final String spe = ",";
	public final String gap = " ";
	public String type;
	public String date;
	// public String month;
	public String PartOf_policing_Operation;
	public String policing_Operation;
	public String latitude;
	public String longitude;
	public String gender;
	public String age_Range;
	public String self_Defined_Ethnicity;
	public String officer_Defined_Ethnicity;
	public String legislation;
	public String object_Of_Search;
	public String outcome;
	public boolean outcome_Search; // changed variable name, outcome_search_LinkedTo_ObjectOf_Search
	public String removal; 	// changed variable name, Removal_Of_MoreThan_just_Outer_Clothing

	public String toCSVString() {

		return type + spe + gap + date + spe + gap + PartOf_policing_Operation + spe + gap + policing_Operation + spe + gap + latitude
				+ gap + longitude + gap + age_Range + gap + self_Defined_Ethnicity + gap + officer_Defined_Ethnicity
				+ spe + legislation + spe + object_Of_Search + spe + outcome + spe
				+ outcome_Search + spe + removal;

	}

	public CrimeStopAndSearch(String csv) {
		String[] csvParts = csv.split(spe, -1);
		int i = 0;

		type = csvParts[i++];
		date = csvParts[i++];
		PartOf_policing_Operation = csvParts[i++];
		policing_Operation = csvParts[i++];
		latitude = csvParts[i++];
		longitude = csvParts[i++];
		gender = csvParts[i++];
		age_Range = csvParts[i++];
		self_Defined_Ethnicity = csvParts[i++];
		officer_Defined_Ethnicity = csvParts[i++];
		legislation = csvParts[i++]; 
		object_Of_Search = csvParts[i++];
		outcome = csvParts[i++];
		if(csvParts[i].equalsIgnoreCase("true") || csvParts[i].equalsIgnoreCase("false")) 
		{
			outcome_Search = true;
			
		}else if(csvParts[i] == null) {
			outcome_Search = false;
			
		}
		i++;
		removal = csvParts[i++];
	}
	

}
