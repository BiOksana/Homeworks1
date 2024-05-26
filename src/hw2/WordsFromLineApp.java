package hw2;

public class WordsFromLineApp {
    public static void main(String[] args) {
        String[] givenStringsArray = {"anger", "awe", "joy", "love", "grief"};
        String str = "yliausoenvjw";//"abcdkasdfvkadf";//"griefgriefgrief";//"angerw";//
        System.out.println(getCountOfFeelings(givenStringsArray, str) + " feelings");
    }

    public static int getCountOfFeelings(String[] array, String s) {
        String result;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            result = "";
            String[] arrayOfArraysElement = array[i].split("");
            String temp = s;
            for (int j = 0; j < arrayOfArraysElement.length; j++) {
               if (temp.contains(arrayOfArraysElement[j])) {
                   int index = temp.indexOf(arrayOfArraysElement[j]);
                   temp = temp.substring(0, index) + temp.substring(index + 1);
                   result += arrayOfArraysElement[j];
               }
            }
            if(result.equals(array[i])) {
               count++;
                System.out.println("Feeling \"" + result + "\"");
            }
        }
        return count;
    }
}
