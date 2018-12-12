package V1;

import java.util.ArrayList;
import java.util.List;

/**
 * This will be the main class that we will use to output and manipulate data usually will be within an arrayList
 * 
 */
public class CrimeStopAndSearch {

	public String CrimeType;
	public int Successful;
	public int partially_Successful;
	public int unSuccessful;
	public String ethnic;
	public final String sep = ",";
	public final String gap = " ";
	public String type;
	public String Date;
	public String Part_Of_a_Policing_Operation;
	public String Policing_Operation;
	public Float latitude;
	public Float longitude;
	public String Gender;
	public String Age_Range;
	public String Self_Defined_Ethnicity;
	public String Officer_Defined_Ethnicity;
	public String Legislation;
	public String Object_Of_Search;
	public String Outcome;
	public Boolean Outcome_Linked_To_Object_Of_Search;
	public Boolean Removal_Of_More_Than_Just_Outer_Clothing;
	public int total;
	
	/** This method is used to print out all attributes within the object usually used looping through the list and outputting data
	 */
	public String toCSVString() {

		String unfilteredCSV = type + sep + gap + Date + sep + gap + Gender + sep + gap + Part_Of_a_Policing_Operation + sep + gap + Policing_Operation + 
				sep + gap + latitude + gap + longitude + gap + Age_Range + gap + Self_Defined_Ethnicity + gap + Officer_Defined_Ethnicity
				+ sep + gap + Legislation + sep + gap + Object_Of_Search + sep + gap + Outcome + sep + gap
				+ Outcome_Linked_To_Object_Of_Search + sep + gap + Removal_Of_More_Than_Just_Outer_Clothing;
		
		  String filteredCSV = unfilteredCSV.replace("null", "Unspecified").replace(", ,", ", Unspecified,");

		return String.format("|%1$-26s|%2$-26s|%3$-12s|%4$-12s|%5$-12f|%6$-12f|%7$-8s|%8$-8s|%9$-58s|%10$-6s|%11$-50s|%12$-14s|%13$-34s|%14$-6b|%15$-6b|",
				type,Date,Part_Of_a_Policing_Operation,Policing_Operation,latitude,longitude,Gender,Age_Range,Self_Defined_Ethnicity,Officer_Defined_Ethnicity,
				Legislation,Object_Of_Search,Outcome,Outcome_Linked_To_Object_Of_Search,Removal_Of_More_Than_Just_Outer_Clothing);
	}
	
	/**
	 * Constructor to hold each unique column from csv Doc into it's unique variable
	 * so that we can refer back to output or manipulate data
	 * 
	 * @param csv This will be a string from readnext line that splits by
	 */

	public CrimeStopAndSearch(String csv) {
		String[] csvParts = csv.split(sep, -1);
		int i = 0;

		type = csvParts[i++];
		Date = csvParts[i++];
		Part_Of_a_Policing_Operation = csvParts[i++];
		Policing_Operation = csvParts[i++];
		if(csvParts[i] !=null && csvParts[i].length()>0) {
		latitude = Float.parseFloat(csvParts[i++]);}
		else {latitude = null; i++;}
		if(csvParts[i] !=null && csvParts[i].length()>0) {
			longitude = Float.parseFloat(csvParts[i++]);}
		else {longitude = null; i++;}
		Gender = csvParts[i++];
		Age_Range = csvParts[i++];
		Self_Defined_Ethnicity = csvParts[i++];
		Officer_Defined_Ethnicity = csvParts[i++];
		Legislation = csvParts[i++];
		Object_Of_Search = csvParts[i++];
		Outcome = csvParts[i++];
		if(csvParts[i] !=null && csvParts[i].length()>0) {
		Outcome_Linked_To_Object_Of_Search = Boolean.parseBoolean(csvParts[i++]);
		}else {Outcome_Linked_To_Object_Of_Search =null; i++;}
		if(csvParts[i] !=null && csvParts[i].length()>0) {
		Removal_Of_More_Than_Just_Outer_Clothing = Boolean.parseBoolean(csvParts[i++]);
		}else {Removal_Of_More_Than_Just_Outer_Clothing =null; i++;}
	}

	/**
	 * This constructor is used to create an object for the highest legislation.
	 * @param crime
	 * @param Counter
	 */
	public CrimeStopAndSearch(String Crime, int Counter) {
		CrimeType = Crime;
		total = Counter;
	}
	
	/**
	 * This constructor is used to construct an object for the highest successful legislation.
	 * @param legislationtemp
	 * @param successfultemp
	 * @param unSuccessfultemp
	 * @param partialtemp
	 */
	public CrimeStopAndSearch(String legTemp, int sucTemp, int unSucTemp, int partialTemp) {
		Legislation = legTemp;
		Successful = sucTemp;
		unSuccessful = unSucTemp;
		partially_Successful = partialTemp;
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
		return Legislation + " : " + " Successful: " + Successful + " partially successful: " + partially_Successful
				+ " unSuccessful: " + unSuccessful;	
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
