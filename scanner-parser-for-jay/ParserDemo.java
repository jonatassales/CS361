public class ParserDemo {

	private static String file1 = "your-file-path";

	public static void main(String[] args) {
		TokenStream tStream = new TokenStream(file1);
		ConcreteSyntax cSyntax = new ConcreteSyntax(tStream);
		Program p = cSyntax.program();
		System.out.println(p.display());
	}

}
