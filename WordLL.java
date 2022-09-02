// this class stores the mystery word as a variable and the guess history as another variable
public class WordLL {
	private Word mysteryWord;
	private LinearNode<Word> history;

// constructor creates a mystery word from a Word parameter
	public WordLL(Word mystery) {
		history = null;
		mysteryWord = mystery;
	
	}

// this method takes a guess parameter
// creates a node to store the guess in 
// adds it to the linked list of guess history\
// and returns true if the guess is the same as the mystery word
	public boolean tryWord(Word guess) {
		//guess.labelWord(mysteryWord);
		LinearNode<Word> guessNode = new LinearNode<Word> (guess);
// if history is empty - set history to the first guess
		if(history == null) {
			history = guessNode;
		}
// when history has a value - set the guess node to point to history
// then set history to now be the guess node
		else {
			guessNode.setNext(history);
			history = guessNode;
		}
		
		
// put the guess into the label word method to check if it is the same 
// return true if they are same and false if not
		if(guess.labelWord(mysteryWord) == true) {
			return true;
		}
		else {
			return false;
		}
		
	}
// this is a method for a string representation of the past guesses
// with most recent guess first
	public String toString() {
		String S = "";
		LinearNode<Word> current;
		//System.out.println("hello");
		current = history;
// loop through the linked list of guesses and add each one to the string
		while(current != null) {
			//System.out.println("hello");
			S += current.getElement().toString() +"\n";
			//System.out.println(current.getElement());

			current = current.getNext();
		}
// return the full string at the end
		return S;
		
	}

}
