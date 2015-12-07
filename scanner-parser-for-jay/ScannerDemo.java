public class ScannerDemo {

	private static String file1 = "your-file-path";

	private static int counter = 1;

	public static void main(String args[]) {

		TokenStream ts = new TokenStream(file1);

		System.out.println(file1);

		while (!ts.isEndofFile()) {
			System.out.println("Token " + counter + ts.nextToken());
			counter++;
		}
	}
}
