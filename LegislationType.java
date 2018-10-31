//import CrimeStopAndsearch.LegislationType;

public enum LegislationType {

		SECTION27("Aviation Security Act 1982 (section 27(1))"),
		SECTION23("Misuse of Drugs Act 1971 (section 23)"),
		SECTION1("Police and Criminal Evidence Act 1984 (section 1)"),
		SECTION2("Poaching Prevention Act 1862 (section 2)"),
		SECTION47("Firearms Act 1968 (section 47)"),
		SECTION60("Criminal Justice and Public Order Act 1994 (section 60)"),
		BLANK("TBD");
		private final String str;

		public String getStr() {
			return str;
		}

		private LegislationType(String aStr) {
			this.str = aStr;
		}

		public String toString() {
			return this.str;
		}
		
		public static LegislationType getFrom(String aStr) {
			for (LegislationType r : LegislationType.values())
			if (r.str.equals(aStr))
			return r;
			throw new IllegalArgumentException
			("Could not find a LegislationType :" + aStr);
			}
		
	}
