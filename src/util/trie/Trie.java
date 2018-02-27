package util.trie;

import java.util.Scanner;
//https://practice.geeksforgeeks.org/problems/trie-insert-and-search/0
//https://practice.geeksforgeeks.org/problems/phone-directory/0
class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;
	
	TrieNode(){
		this.children = new TrieNode[26];
		this.isEndOfWord = false;
	}
}
public class Trie {
	static TrieNode root;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int t = 0; t < testCases; t++) {
			int nOfWords = in.nextInt();
			String[] words = new String[nOfWords];
			for(int i = 0; i < nOfWords; i++) {
				words[i] = in.next();
			}
			String search = in.next();
			root = new TrieNode();
			insert(words);
			System.out.println(search(search) ? 1 : 0);
			phoneDirectory(search);
		}	
	}

	private static boolean search(String search) {
		TrieNode node = root;
		for(int i = 0; i < search.length(); i++) {
			int index = search.charAt(i) - 'a';
			if(node.children[index] == null) {
				return false;
			}
			node = node.children[index];
		}
		return node.isEndOfWord;
	}

	private static void insert(String[] words) {
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			TrieNode node = root;
			for(int j = 0; j < word.length(); j++) {
				int index = word.charAt(j) - 'a';
				if(node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				node = node.children[index];
			}
			node.isEndOfWord = true;
		}
	}
	
	private static void phoneDirectory(String word) {
		TrieNode node = root;
		String prefix = "";
		boolean wordPresent = true;
		for(int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if(node.children[index] == null) {
				System.out.println(0);
				wordPresent = false;
				continue;
			}
			if(wordPresent) {
				prefix += (char)('a'+ index);
				printAllWordsWithPrefix(node.children[index], prefix);
				System.out.println();
				node = node.children[index];
			}else {
				System.out.println(0);
			}
		}
	}

	private static void printAllWordsWithPrefix(TrieNode node, String prefix) {
		if(node.isEndOfWord) {
			System.out.print(prefix + " ");
		}
		for(int i = 0; i < 26; i++) {
			if(node.children[i] != null) {
				printAllWordsWithPrefix(node.children[i], prefix + (char)('a'+ i));
			}
		}
	}
}
