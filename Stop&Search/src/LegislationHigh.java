
public class LegislationHigh implements Comparable<LegislationHigh>{

	public String legislationNum;
	public int increment;

	public LegislationHigh(String legislationNum, int increment) {
		super();
		this.legislationNum = legislationNum;
		this.increment = increment;
	}
	
	public String getLegName() {
		return legislationNum;
	}
	public void setFruitName(String legislationNum) {
		this.legislationNum = legislationNum;
	}
	public int getLegHigh() {
		return increment;
	}
	public void setLegHigh(int quantity) {
		this.increment = quantity;
	}

	public int compareTo(LegislationHigh compareLegislationHigh) {
	
		int compareQuantity = ((LegislationHigh) compareLegislationHigh).getLegHigh(); 
		return this.increment - compareQuantity;
		
		
	}	
}
