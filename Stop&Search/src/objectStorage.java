

class objectStorage{
	public int Successful;
	public int partially_successful;
	public int unsuccessful;
	public String val;
	public String ethic;

	public String toString() {
		return "" + val + " Successful: " + Successful + " partially successful: " + partially_successful + " unsuccessful: " + unsuccessful;
	}
	public String toString2() {
		return ethic+  " : " + val + " Successful: " + Successful + " partially successful: " + partially_successful + " unsuccessful: " + unsuccessful;
	}

	public objectStorage(String temp, int successfultemp, int unsuccessfultemp, int partialtemp) {
		val = temp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}
	
	public objectStorage(String ethictemp, String temp, int successfultemp, int unsuccessfultemp, int partialtemp) {
		ethic=ethictemp;
		val = temp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}

	public int getSuccessful() {
		return Successful;
	}
	
	public int getTotal() {
		return Successful + unsuccessful + partially_successful;
	}

	public void setSuccessful(int successful) {
		Successful = successful;
	}
}


