// this class represents a word comprised of letters represented by letter objects
// it has a private variable called first letter that is a linear node of class letter
public class Word {
	private LinearNode<Letter> firstLetter;

// constructor takes an array of letters and creates a linked list
	public Word(Letter[] letters) {
// first letter in the list is first letter of the array
		firstLetter = new LinearNode<Letter>(letters[0]);
		LinearNode<Letter> next = new LinearNode<Letter>(letters[1]);
		LinearNode<Letter> current = new LinearNode<Letter>();
		LinearNode<Letter> tempNode = new LinearNode<Letter>();

		firstLetter.setNext(next);
		current = firstLetter.getNext();
// loop through the full array and connect each letter to the linked list
		for(int i = 2; i < letters.length; i++) {
		
			next = new LinearNode<Letter>(letters[i]);
			current.setNext(next);
			tempNode = current.getNext();
			current = tempNode;

		}
	}

// this method creates a string representation of a Word object
// loops through the linked list adding each node to the back of the string
	public String toString() {
		String s = "Word: ";
		LinearNode<Letter> curr = firstLetter;
		while(curr != null) {
			s += curr.getElement();
			s += " ";
			curr = curr.getNext();
		}
		return s;
// returns a completed string at the end 	
	}
	
// this method takes a mystery word as a parameter and updates the labels for each letter based on the myster word
	public boolean labelWord(Word mystery) {
		LinearNode<Letter> thisLetter = this.firstLetter;
		LinearNode<Letter> mysteryLetter = mystery.firstLetter;
		int thisCount = 0;
		int mysteryCount = 0;
		int correctCount = 0;

// loop through the THIS letters
		while(thisLetter != null) {
			
// loop through the mystery letter
			while(mysteryLetter != null) {
				
// if the letters equal and they are in the same spot
// set the label to correct
				if(thisLetter.getElement().equals(mysteryLetter.getElement()) && thisCount == mysteryCount) {
					Letter elem = thisLetter.getElement();
					
					elem.setCorrect();
					
					correctCount++;
					
					mysteryLetter = mysteryLetter.getNext();
					break;
				}
// if the letters equal and they are not in the same spot
// set the label to used
				else if(thisLetter.getElement().equals(mysteryLetter.getElement()) && thisCount != mysteryCount) {
					Letter elem = thisLetter.getElement();
					elem.setUsed();
					System.out.println(elem);
					mysteryLetter = mysteryLetter.getNext();
					break;

				}
				
// else set label to unused
				else {
					Letter elem = thisLetter.getElement();
					elem.setUnused();
					System.out.println(elem);

					mysteryLetter = mysteryLetter.getNext();

				}
				mysteryCount++;
			}
			
			mysteryCount = 0;
			mysteryLetter = mystery.firstLetter;
			

			thisCount++;
			
			thisLetter = thisLetter.getNext();
		}
// if the the letter is not zero and the the number of correct letters is same as the guess size
// then it is correct and return true
		if (thisCount != 0 && thisCount == correctCount) {
			return true;
		}
		else {
			return false;
		}
	}

}
