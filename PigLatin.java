import java.util.*;

public class PigLatin {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a phrase (no numbers) or type \"!quit\" to quit.");
        String word = scan.nextLine();
        while(!word.equals("!quit")) {
            if(word.length() <= 1) System.out.println("Must be two or more characters.");
            System.out.println(pigLatin(word));
            System.out.println("Enter a phrase or type \"!quit\" to quit.");
            word = scan.nextLine();
        }
    }

    private static String pigLatin(String word) {
        String translated = "";
        int i = 0;
        while(i < word.length()) {
            // deal with spaces and punctuation
            while(i < word.length() && !isLetter(word.charAt(i))) {
                translated += word.charAt(i);
                i++;
            }

            // stop if there are no more words in phrase
            if(i >= word.length()) break;

            // beginning of word
            int beginning = i;
            while(i < word.length() && isLetter(word.charAt(i))) {
                i++; // iterate over the letters
            }

            // finally at end of word
            int end = i;
            translated += pigWord(word.substring(beginning, end));
        }
        return translated;
    }

    private static boolean isLetter(char c) {
        if(c >= 'A' && c <= 'Z') {
            return true;
        } else if(c >= 'a' && c < 'z') {
            return true;
        } else return false;
    }

    private static String pigWord(String word) {
        int split = firstVowel(word);
        return word.substring(split) + "-" + word.substring(0, split) + "ay";
    }

    private static int firstVowel(String word) {
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < word.length(); i++) {
            if(vowels.contains(""+word.charAt(i))) return i;
        }
        return 0;
    }
}
