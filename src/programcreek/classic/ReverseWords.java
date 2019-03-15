package programcreek.classic;

//Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
// Given s = "the sky is blue",
// return "blue is sky the".
public class ReverseWords {
    private static void swap(char[] word, int i, int j) {
        char tmp = word[i];
        word[i] = word[j];
        word[j] = tmp;
    }

    private static void reverse(char[] words, int i, int j) {
        while(i < j) {
            swap(words, i, j);
            i++;
            j--;
        }
    }

    public static String reverseSentence(String sentence) {
        char[] wordsArr = sentence.toCharArray();

        int lo = 0;

        for(int i = 0; i < wordsArr.length; i++) {
            if(wordsArr[i] == ' ') {
                reverse(wordsArr, lo, i - 1);
                lo = i + 1;
            }
        }

        reverse(wordsArr, lo, wordsArr.length - 1);
        reverse(wordsArr, 0, wordsArr.length - 1);

        return new String(wordsArr);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseSentence(s));
    }
}
