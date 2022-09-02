// this class is a subclass of the letter class that adds more functionality
// it allows us to use a string instead of char which provides more flexibility
// here we have new variables such as content, family, related and SINGLETON
public class ExtendedLetter extends Letter {
	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;

// this constructor allows a string as parameter and sets the value to that string
// it also sets the related value to start at false and the family value to SINGLETON
	public ExtendedLetter(String S) {
		super('c');
		content = S;
		related = false;
		family = SINGLETON;
	}
// this overloaded method is same as above but uses a fam input parameter to set the family value
	public ExtendedLetter(String S, int fam) {
		super('c');
		content = S;
		related = false;
		family = fam;
	}

// this method compares two objects of extended letter
// returning true only if the other param is an instance of extended letter and
// if the contents are the same
// it also sets this.relate to true if the two have the same family
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) {
			if(this.family == ((ExtendedLetter)other).family) {
				this.related = true;
			}
			if(this.content == ((ExtendedLetter) other).content) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;	
		}
	}

// this method returns a string representation of the class
// if the string is unused and related it returns the content separated by periods
// else it returns the content separated by decorators like normal
	public String toString() {
		if(this.isUnused() && this.related == true) {
			return "." + this.content + ".";
		}
		else {
			return decorator() + this.content + decorator();

		}
	}
// this method creates an array using content and codes parameters
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
// if codes is null it sets the ith letter to extended letter with the ith content
		if(codes == null) {
			for(int i = 0; i < letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
		}
// else it sets the ith letter to extended letter with ith content and codes parameters
		else {
			for(int i = 0; i < letters.length; i++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		return letters;
	}
}
