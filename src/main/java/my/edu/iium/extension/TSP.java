package my.edu.iium.extension;

public class TSP {
	private static boolean TSPperformed = false;

	protected static void performAlgo() {
		TSPperformed = false;
	}

	protected static boolean isTSPperformed() {
		return TSPperformed;
	}
}