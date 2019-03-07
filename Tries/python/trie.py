__author__ = "Shashwat Tiwari"
__email__  = "shashwat1791@gmail.com"


class TrieNode(object):

	def __init__(self):
		self.children = {}
		self.wordCount = 0
		self.endOfWord = False


class Trie(object):


	def __init__(self):
		self.root = TrieNode()


	def insert(self, word):

		current = self.root

		for ch in word:
			current.wordCount += 1
			if ch not in current.children:
				newNode = TrieNode()
				current.children[ch] = newNode

			current = current.children[ch]

		current.endOfWord = True


	def checkIfExits(self, word):

		current = self.root

		for ch in word:

			if ch in current.children:
				current = current.children[ch]
			else:
				return False

		return current.endOfWord

	def prefixSearch(self, prefix):

		current = self.root

		for ch in prefix:
			if ch in current.children:
				current = current.children[ch]
			else:
				return 0

		return current.wordCount


if __name__ == "__main__":
	trie = Trie() 
	trie.insert("abcd")
	trie.insert("axyc")
	trie.insert("abc")

	print trie.prefixSearch("ab")

