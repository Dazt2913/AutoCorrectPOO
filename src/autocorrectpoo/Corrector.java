package autocorrectpoo;

public class Corrector {
    public static String corregirTexto(String texto){
        return new String();
    }
    
    private static String obtenerMathRating(String word){
        String currentWordSoundex = "" + word;
        switch(currentWordSoundex.substring(0, 1)){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                String st = currentWordSoundex.substring(1);
                st = st.replace("a", "");
                st = st.replace("e", "");
                st = st.replace("i", "");
                st = st.replace("o", "");
                st = st.replace("u", "");
                currentWordSoundex = currentWordSoundex.substring(0, 1) + st;
                break;

            default:
                currentWordSoundex = currentWordSoundex.replace("a", "");
                currentWordSoundex = currentWordSoundex.replace("e", "");
                currentWordSoundex = currentWordSoundex.replace("i", "");
                currentWordSoundex = currentWordSoundex.replace("o", "");
                currentWordSoundex = currentWordSoundex.replace("u", "");
                break;
        }
        
        char[] currentWordSoundexArray = currentWordSoundex.toCharArray();
        String currentWordSoundexNoRepeat = "";
        for(int i = 0; i < currentWordSoundexArray.length; i++){
            char currentChar = currentWordSoundexArray[i];
            if(i==0){
                currentWordSoundexNoRepeat += currentChar;
            }
            if(i!=0 && currentChar != currentWordSoundexArray[i-1]){
                currentWordSoundexNoRepeat += currentChar;
            }
        }
        
        if(currentWordSoundexNoRepeat.length()<=3){
                    currentWordSoundexNoRepeat += currentWordSoundexNoRepeat;
        }
        else{
           int i = currentWordSoundexNoRepeat.length();
           currentWordSoundexNoRepeat = 
                   currentWordSoundexNoRepeat.substring(0, 3) +
                   currentWordSoundexNoRepeat.substring(i-3);
        }
        
        return currentWordSoundexNoRepeat;
    }
}
