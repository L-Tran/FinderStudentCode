public class TSTNode {
    // Instance variables
    private String isWord;
    private TSTNode[] children;
    private char letter;

    // Constructor
    public TSTNode(char c) {
        letter = c;
        // Each node has 3 children for each direction
        children = new TSTNode[3];
        isWord = null;
    }

    // Getters & Setters
    public TSTNode[] getChildren() {
        return children;
    }

    public String isWord() {
        return isWord;
    }

    public char getLetter() {
        return letter;
    }

    public void setWord(String word) {
        isWord = word;
    }
}
