// Program.java

// NOT TO BE MODIFIED (except if you are sure there is a bug!)

// Abstract syntax of JAY 

// Display methods are added to facilitate debugging and experimentation


import java.util.Vector;

public class Program {
	// Program = Declarations decpart ; Block body

	public Declarations decpart;
	public Block body;

	public String display() {
		int level = 0;
		Indenter indent = new Indenter(level);
		String s = indent.display("Abstract syntax of the JAY 2006 Program: ");
		String dec = decpart.display(level + 1);
		String bod = body.display(level + 1);
		String nl = "\n";
		return s + dec + bod + nl;
	}
}

class Indenter {
	// To help displaying the abstract tree using levels

	public int level;

	public Indenter(int nextlevel) {
		level = nextlevel;
	}

	public String display(String message) {
		// Displays a message on the next line at the current level
		String tab = "";
		String nl = "\n";
		for (int i = 0; i < level; i++)
			tab = tab + "  ";
		return nl + tab + message;
	}
}
class Declarations extends Vector {
	// Declarations = Declaration *
	//				  (a Vector of Declarations d1, d2, ..., dn)

	public String display(int level) {
		Indenter indent = new Indenter(level);
		String s = indent.display(getClass().toString().substring(6) + ": ");
		String s1 = indent.display("  Declarations = {");
		String s2 = "";
		for (int i = 0; i < size(); i++) {
			s2 = s2 + ((Declaration) elementAt(i)).display();
			if (i < size() - 1)
				s2 = s2 + ", ";
		}
		return s + s1 + s2 + "}";
	}
}

class Declaration {
	// Declaration = Variable v; Type t

	public Variable v;
	public Type t;

	public String display() {
		return "<" + v.id + ", " + t.id + ">";
	}
}

class Type {
	// Type = int | bool | undef

	public String id;

	final static String INTEGER = "int";
	final static String BOOLEAN = "bool";
	final static String UNDEFINED = "undef";

	public Type(String t) {
		id = t;
	}

	public boolean isBoolean() {
		return id.equals(BOOLEAN);
	}

	public boolean isInteger() {
		return id.equals(INTEGER);
	}

	public boolean isUndefined() {
		return id.equals(UNDEFINED);
	}
}

class Statement {
	// Statement = Skip | Block | Assignment | Conditional | Loop

	public String display(int level) {
		Indenter indent = new Indenter(level);
		return indent.display(getClass().toString().substring(6) + ": ");
	}
}

class Skip extends Statement {

	public String display(int level) {
		return super.display(level);
	}
}

class Block extends Statement {
	// Block = Statement*
	//		   (a Vector of members) 

	public Vector blockmembers = new Vector();

	public String display(int level) {
		String s = super.display(level);
		for (int i = 0; i < blockmembers.size(); i++)
			s = s + ((Statement) blockmembers.elementAt(i)).display(level + 1);
		return s;
	}
}

class Assignment extends Statement {
	// Assignment = Variable target; Expression source

	public Variable target;
	public Expression source;

	public String display(int level) {
		String s = super.display(level);
		String tar = target.display(level + 1);
		String sour = source.display(level + 1);
		return s + tar + sour;
	}
}

class Conditional extends Statement {
	// Conditional = Expression test; Statement thenbranch, elsebranch

	public Expression test;
	public Statement thenbranch, elsebranch;
	// elsebranch == null means "if... then" Statement

	public String display(int level) {
		String s = super.display(level);
		String cond = test.display(level + 1);
		String then = thenbranch.display(level + 1);
		String els = "";
		if (elsebranch != null)
			els = els + elsebranch.display(level + 1);
		return s + cond + then + els;
	}
}

class Loop extends Statement {
	// Loop = Expression test; Statement body

	public Expression test;
	public Statement body;

	public String display(int level) {
		String s = super.display(level);
		String t = test.display(level + 1);
		String b = body.display(level + 1);
		return s + t + b;
	}
}

class Expression {
	// Expression = Variable | Value | Binary | Unary

	public String display(int level) {
		Indenter indent = new Indenter(level);
		return indent.display(getClass().toString().substring(6) + ": ");
	}
}

class Variable extends Expression {
	// Variable = String id

	public String id;

	public boolean equals(Object obj) {
		String s = ((Variable) obj).id;
		return id.equalsIgnoreCase(s); // case-insensitive identifiers
	}

	public int hashCode() {
		return id.hashCode();
	}

	public String display(int level) {
		String s = super.display(level);
		return s + id;
	}
}

class Value extends Expression {
	// Value = int intValue | bool boolValue

	public Type type;

	public int intValue; // if the type is an int intValue is used otherwise
	// boolValue is used
	public boolean boolValue;

	public Value(int i) {
		type = new Type(Type.INTEGER);
		intValue = i;
	}

	public Value(boolean b) {
		type = new Type(Type.BOOLEAN);
		boolValue = b;
	}

	public Value() {
		type = new Type(Type.UNDEFINED);
	}

	public String display(int level) {
		String s = super.display(level);
		if (type.isInteger())
			s = s + intValue;
		else if (type.isBoolean())
			s = s + boolValue;
		return s;
	}
}

class Binary extends Expression {
	// Binary = Operator op; Expression term1, term2

	public Operator op;
	public Expression term1, term2;

	public String display(int level) {
		String s = super.display(level);
		String sop = op.display(level + 1);
		String t1 = term1.display(level + 1);
		String t2 = term2.display(level + 1);
		return s + sop + t1 + t2;
	}
}

class Unary extends Expression {
	// Unary = Operator op; Expression term

	public Operator op;
	public Expression term;

	public String display(int level) {
		String s = super.display(level);
		String sop = op.display(level + 1);
		String t = term.display(level + 1);
		return s + sop + t;
	}
}

class Operator {

	public String val; // value of the operator - one of the constant above

	// Operator = BooleanOp | RelationalOp | ArithmeticOp | Unary1Op
	// BooleanOp = && | ||
	final static String AND = "&&";
	final static String OR = "||";
	// RelationalOp = < | <= | == | <> | >= | >
	final static String LT = "<";
	final static String LE = "<=";
	final static String EQ = "==";
	final static String NE = "<>";
	final static String GT = ">";
	final static String GE = ">=";
	// ArithmeticOp = + | - | * | /
	final static String PLUS = "+";
	final static String MINUS = "-";
	final static String TIMES = "*";
	final static String DIV = "/";
	// UnaryOp = !    
	final static String NOT = "!";

	public Operator(String s) {
		val = s;
	}

	public boolean BooleanOp() {
		return val.equals(AND) || val.equals(OR);
	}

	public boolean RelationalOp() {
		return val.equals(LT)
			|| val.equals(LE)
			|| val.equals(EQ)
			|| val.equals(NE)
			|| val.equals(GT)
			|| val.equals(GE);
	}

	public boolean ArithmeticOp() {
		return val.equals(PLUS)
			|| val.equals(MINUS)
			|| val.equals(TIMES)
			|| val.equals(DIV);
	}

	public boolean UnaryOp() {
		return val.equals(NOT);
	}

	public String display(int level) {
		Indenter indent = new Indenter(level);
		return indent.display(getClass().toString().substring(6) + ": " + val);
	}
}
