
public class Crime {

    public String csv;
    public String crimeid;
    public String month;
    public String reportedby;
    public String fallswithin;
    public String longitude;
    public String latitude;
    public String location;
    public String lsoaC;
    public String lsoaN;
    public String crimetype;
    public String outcome;
    public String context;
    public String xd;
    
   


    public void toCSVString() {
    	
    	System.out.printf( "|" + "%65s %8s %1s %19s %17s %25s %25s %25s %25s %25s %25s %25s %n" ,crimeid + "|" , month+ "|" , reportedby, "|" +fallswithin, "|" + longitude,latitude,location,lsoaC,lsoaN,crimetype,outcome,context );
    	
    	
        //return crimeid+", "+ month+", "+reportedby+", "+fallswithin+", "+longitude+", "+latitude+", "+location+", "+lsoaC+", "+lsoaN+", "+crimetype+", "+outcome+", "+context +", ";
        }
    
   

    public Crime(String csv) {
    	
    	
 

        String[]split = csv.split(",",12);
        
        for(int i = 0; i < split.length; ) {
        	
        	if(split[i] == null || split[i] == "" || split[i].isEmpty()) {
        		
        		split[i] = "TBD";
        	}
        	
        	i++;
        }
        
        crimeid=split[0];
        month=split[1];
        reportedby=split[2];
        fallswithin=split[3];
        longitude=split[4];
        latitude=split[5];
        location=split[6];
        lsoaC=split[7];
        lsoaN=split[8];
        crimetype=split[9];
        outcome=split[10];       
        context=split[11];
        
        
        


    }

}
