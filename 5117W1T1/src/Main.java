
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        Crime[] crimeArray = new Crime[100];

        try {
        	
            FileReader fr = new FileReader("data/crimedata.csv");
            BufferedReader br=new BufferedReader(fr);
            String tempdata;
            int i = 0 ;


            while((tempdata=br.readLine()) != null ){
            	
        	
                crimeArray[i] = new Crime(tempdata);
                
                		
                
                i++;

            }
           
            
            for(int q = 0; q < i;) {
            	crimeArray[q].toCSVString();
            	
            	q++;
            }
            	



            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        



        }




}