// this class letter is a class for an individual letter in the game of Wordle
// it holds variables for the letter itself and its label
// which can be set to unset, unused, used or correct
public class Letter {
	private char letter;
	private int label;
	private int unset = -1;
	private int unused = 0;
	private int used = 1;
	private int correct = 2;
	
// this constructor creates a new Letter object from a character parameter
// it starts the label as unset and sets the letter to the parameter of c
	public Letter(char c) {
		label = unset;
		letter = c;
	}

// private helped method to return the letter
	private char getLetter() {
		return letter;
	}

// this method checks if the input paremeter for otherObject is a Letter
// then it compares the letter attributes of the two objects
	public boolean equals(Object otherObject) {
		if(otherObject.getClass() == this.getClass()) {
			if(this.getLetter() == ((Letter) otherObject).getLetter()) {
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
	
// this decorator assigns a symbol to each label attribute
	public String decorator() {
// if the label is used we decorate with plus signs
		if(label == used) {
			return "+";
		}
// if the label is unused we decorate with minus signs
		else if(label == unused) {
			return "-";
		}
// if the label is used we decorate with exclamation point
		else if(label == correct) {
			return "!";
		}
// else decorate with spaces
		else {
			return " ";
		}
	}

// return a string of the letter surrounded by its decoration
	public String toString() {
		return decorator() + letter + decorator();
	}
	
// sets label to unused
	public void setUnused() {
		label = unused;
	}
// sets label to used	
	public void setUsed() {
		label = used;
	}
// sets label to correct	
	public void setCorrect() {
		label = correct;
	}
// checks if label is unused and returns true if it is unused	
	public boolean isUnused() {
		if(label == unused) {
			return true;
		}
		else {
			return false;
		}
	}

// this method returns an array of Letter objects given a String parameter
	public static Letter[] fromString(String S) {
// make a new array of length of string
		Letter[] lettersList = new Letter[S.length()];
// loop through
		for(int i = 0; i < S.length(); i++ ) {
// create new Letter objects and assign them to the array
			Letter newLetter = new Letter(S.charAt(i));
			lettersList[i] = newLetter;
		}
		return lettersList;
	}

}
