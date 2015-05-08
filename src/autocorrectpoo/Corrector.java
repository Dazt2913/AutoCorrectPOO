package autocorrectpoo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;

public class Corrector {
    public static String corregirTexto(String texto){
        try{
            String propuesta = "";
            String dictionary = "";
            
            Scanner sc = new Scanner(new File("src/res/diccionario.dat"));
            
            while(sc.hasNext()){
                String currentWordWithMathRating = sc.nextLine();
                dictionary += currentWordWithMathRating + "\n";
            }
            
            sc.close();
            sc = new Scanner(texto);
            
            while(sc.hasNext()){
                String currentWord = sc.next();
                
                if(!searchInDictionary(dictionary, currentWord)){
                    String[] proposals = proposal(dictionary, currentWord);
                    propuesta += currentWord + ": ";
                    for(int i = 0; i < proposals.length; i++){
                        propuesta += proposals[i] + ", ";
                    }
                    propuesta += "\n";
                }
            }
            
            return propuesta;
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        finally{
            
        }
        
        return null;
    }
    
    public static String obtenerMathRating(String word){
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
    
    private static boolean searchInDictionary(String dictionary, String word){
        Scanner scDictionary = new Scanner(dictionary);
        while(scDictionary.hasNext()){
            String dictionaryCurrentWord = scDictionary.next();
            String dictionaryCurrentMathRating = scDictionary.next();
            
            word = word.toLowerCase();
            if(word.equals(dictionaryCurrentWord)){
                scDictionary.close();
                return true;
            }
        }
        return false;
    }
    
    private static String[] proposal(String dictionary, String word){
        Scanner scDictionary = new Scanner(dictionary);
        String wordMathRating = obtenerMathRating(word);
        ArrayList<String> proposals = new ArrayList<>(0);
        while(scDictionary.hasNext()){
            String dictionaryCurrentWord = scDictionary.next();
            String dictionaryCurrentMathRating = scDictionary.next();
            
            if(wordMathRating.equals(dictionaryCurrentMathRating)){
                proposals.add(dictionaryCurrentWord);
            }
        }
        String[] value = new String[proposals.size()];
        for(int i = 0; i < value.length; i++){
            value[i] = proposals.get(i);
        }
        
        return value;
    }
    
    public static void agregarPalabraADiccionario(String palabra){
        try{
            String dictionary = "";
            
            Scanner sc = new Scanner(new File("src/res/diccionario.dat"));
            
            while(sc.hasNext()){
                String currentWordWithMathRating = sc.nextLine();
                dictionary += currentWordWithMathRating + "\n";
            }
            
            sc.close();
            
            String mathRating = obtenerMathRating(palabra);
            dictionary += palabra + " " + mathRating + "\n";
            
            
            Formatter writeNewDictionary = new Formatter("src/res/diccionario.dat");
            
            writeNewDictionary.format(dictionary);
            writeNewDictionary.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        finally{
            
        }
    }
}
