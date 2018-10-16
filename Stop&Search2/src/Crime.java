import java.util.List;

//Constructor to store all the data types that are read in from excel
public class Crime {

	public final String SEP = ",";
	public String csv;
	public String crimeid;
	public String month;
	public String reportedby;
	public String fallswithin;
	public Double longitude;
	public Double latitude;
	public String location;
	public String lsoaC;
	public String lsoaN;
	public String crimetype;
	public String outcome;
	public String context;
	//use this to print out crimes
	
	public Crime(String csvString) {
		String[] csvParts = csvString.split(SEP, -1);
		int idx = 0;
		crimeid = csvParts[idx++];
		month = csvParts[idx++];
		reportedby = csvParts[idx++];
		fallswithin = csvParts[idx++];
		longitude = Double.valueOf(csvParts[idx++]);
		latitude = Double.valueOf(csvParts[idx++]);
		location = csvParts[idx++];
		lsoaC = csvParts[idx++];
		lsoaN = csvParts[idx++];
		crimetype = csvParts[idx++];
		outcome = csvParts[idx++];
		context = csvParts[idx++];
	}

	public String toCSVString() {
		return crimeid + SEP + month + SEP + reportedby + SEP + fallswithin + SEP + longitude + SEP + latitude + SEP
				+ location + SEP + lsoaC + SEP + lsoaN + SEP + crimetype + SEP + outcome + SEP + context;
	}
	

}
