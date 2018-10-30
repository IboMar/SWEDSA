

class objectStorage{
	public int Successful;
	public int partially_successful;
	public int unsuccessful;
	public String val;

	public String toString() {
		return "Legislation: " + val + " Successful: " + Successful + " partially successful: " + partially_successful + " unsuccessful: " + unsuccessful;
	}

	public objectStorage(String temp, int successfultemp, int unsuccessfultemp, int partialtemp) {
		val = temp;
		Successful = successfultemp;
		partially_successful = partialtemp;
		unsuccessful = unsuccessfultemp;
	}

	public int getSuccessful() {
		return Successful;
	}

	public void setSuccessful(int successful) {
		Successful = successful;
	}
}


