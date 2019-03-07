import java.util.*;

class TrieNode{

	Map<Character, TrieNode> children;
	boolean endOfWord;
	int wordCount;

	TrieNode(){
		children = new HashMap<>();
		endOfWord = false;
		wordCount = 0;
	}
}

public class Trie{

	private TrieNode root;

	Trie(){
		root = new TrieNode();
	}	

	public void insert(String word){

		TrieNode current = this.root;

		for(char ch : word.toCharArray()){
			current.wordCount++;
			if(!current.children.containsKey(ch)){
				TrieNode newNode = new TrieNode();
				current.children.put(ch, newNode);
			}

			current = current.children.get(ch);
		}

		current.endOfWord = true;
	}

	public boolean checkIfExists(String word){
		TrieNode current = this.root;

		for(char ch : word.toCharArray()){
			if(current.children.containsKey(ch)){
				current = current.children.get(ch);
			}else{
				return false;
			}
		}

		return current.endOfWord;
	}


	public static void main(String [] args){
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("axyz");
		trie.insert("shashwat");
		trie.insert("sabkasaath");
		trie.insert("zoom");


		System.out.println(trie.checkIfExists("zoom"));
		System.out.println(trie.checkIfExists("puru"));
	}

}