import javafx.util.converter.IntegerStringConverter;

import java.io.CharArrayReader;
import java.util.Arrays;

/**
 * Created by Kyle Alex on 8/13/2017.
 */
public class All_Java_Questions {



    public static void main(String [] args){
        intFlip(1234567);
        findOneOfChar ("Ssittp");
        removeWord("duck", 'k');
        wordFlip("Buck rodgers");



    }


     //method flips a string into in the reverse
    public static void wordFlip(String word) {


        //Method prints word in reverse by going in a loop grabbing the character starting from the end of the sting
        for (int j = 0; j < word.length(); j++) {

            System.out.print(word.substring(word.length()-j -1, word.length() -j -1 +1 ));


        }





    }
    //Method removes a single character from a string and prints out the new string

    public static void removeWord(String word, char removeChar){
        char[] result = word.toCharArray();
        char [] compare = new char[word.length()];
       //Turns string into an array and sends it into a loop adding each character into an index
        for(int x = 0, j = 0; x< word.length(); x++){
            //when character that will be removed is reached it will skip it while maintaining the index of the new char array
            if(result[x] != removeChar){

                compare[j] = result[x];

                j++;



            }





        }

       System.out.println(String.valueOf(compare));




    }


    public static void findOneOfChar(String word){
        //Method counts number of ocurrences of a single char within a string if there is only one instance of the char it will print it
        String testWord = word.toLowerCase();
        char[] result = testWord.toCharArray();

        //Holds resultsFound variable that will reset with each iteration of i
        loop:for(int i = 0; i< word.length(); i++){

          int resultsFound = 0;

            for(int j = 0; j< word.length(); j++){

               //if statements checks to see if char array index of i matches with the char value of index of j
                if (String.valueOf(result[j]).contains(String.valueOf(result[i]))){

                    // when condition is met int variable is increased by one
                    resultsFound+=1;


                }
                //if statement checks once loop is done to see if the result counter only equals 1
                if(resultsFound == 1 && j == word.length()-1){


                    System.out.println("There is only "+  "one " + String.valueOf(result[i]));
                 //when condition is met loop is terminated
                 break loop;

























}}}}public static int intFlip(int number){
       //Method flips an integer
        //Intial string which converts integer into a string
        String flip = Integer.toString(number);
        //new string that reverses string
        String flipIndex = new String();
        // By using the substring method to get individual string vales the characters can easily be added
        for(int x = 0; x< flip.length(); x ++){
           // to work backwards always go -1 for first value -x for second to have it only return one value
            flipIndex += flip.substring(flip.length()-1 -x, flip.length() -x);
        }
          //Convert string into int using parse int within the Integer class covered in detail in OCA manual
        int reverseNumber = Integer.parseInt(flipIndex);
        System.out.println(reverseNumber);





        return reverseNumber;
    }}




