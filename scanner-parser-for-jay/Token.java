public class Token {

	private String type; // Token type
	// Identifier, Keyword, Literal,
	// Separator, Operator, or Other
	private String value; // Token value

	/**
	 * @param value
	 *            . Set the value of a Token.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return Returns the value of a Token.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param type
	 *            . Set the type of a Token.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return Returns the type of a Token.
	 */
	public String getType() {
		return type;
	}

	public String toString() {
		return " - Type: " + this.getType() + " - Value: " + this.getValue();
	}

}
