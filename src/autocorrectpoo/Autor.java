package autocorrectpoo;

import java.io.*;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.Serializable;

public class Autor implements Serializable{
    private String nombre;
    private File diccionario;
    private LinkedList<File> entradas;
    private int numDeArchivo;
        
    public Autor(String nombre){
        this.nombre = nombre;
        entradas = new LinkedList<File>();
        FormatterTool.initialize(getNombre());
        FormatterTool.closeFormatter();
        diccionario = new File("src/res/" + nombre + ".dat");
        numDeArchivo = 0;
        
    }
    
    public void addToEntries(File file) {
        getEntradas().add(file); 
        numDeArchivo++;
        //updateDictionary();
    }
    
    public void updateDictionary() {
        LinkedList<String> list = getDictionaryArray();
        for (File file : getEntradas()) {
            try {
               Scanner scanner = new Scanner(file);
               scanner.useDelimiter("[\\W]+"); 
                while (scanner.hasNext()) {
                        String next = scanner.next();
                        if (list.contains(next.toLowerCase()) != true) {
                            list.add(next.toLowerCase());
                        }
                        System.out.println(next);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        LinkedList<String> codeList = getCodeArray(list);
        openFile();
        System.out.println(list.size());
        modifyDictionary(list, codeList);
        closeFile();
    }
    
    public LinkedList<String> getDictionaryArray() { 
        LinkedList list = new LinkedList();
        try {
            Scanner scanner = new Scanner(getDiccionario());
            scanner.useDelimiter("[\\W]+"); 
            while (scanner.hasNext()) {
                list.add(scanner.next().toLowerCase());
                scanner.next();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public LinkedList<String> getCodeArray(LinkedList list) {
        LinkedList<String> codeList = new LinkedList();
        System.out.println(list.size());
        for (int i = 0; i<list.size(); i++) {
            codeList.add(getWordCode(list.get(i).toString()));
            System.out.println(getWordCode(list.get(i).toString()));
        }
        return codeList;
    }
    
    public static String getWordCode(String word) {
        String currentWord = word;
        String currentWordSoundex = "" + currentWord;
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
        } else{
            int i = currentWordSoundexNoRepeat.length();
            currentWordSoundexNoRepeat = currentWordSoundexNoRepeat.substring(0, 3) + currentWordSoundexNoRepeat.substring(i-3);
        }
                
        return currentWordSoundexNoRepeat;           
    }
    
    private void openFile() {
        try {
            FormatterTool.initialize(getNombre());
        }
        catch (SecurityException se) {
            System.out.println("Write permission denied. Terminating.");
            System.exit(1);
        }
    } 
    
    private void modifyDictionary(LinkedList<String> list, LinkedList<String> codeList) {
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            try {
                FormatterTool.getFormatter().format("%s %s\n", list.get(i), codeList.get(i));
            } catch (FormatterClosedException fce) {
                System.err.println("Error writing the file. Terminating.");
                break;
            } catch (NoSuchElementException nse) {
                System.err.println("Invalid input. Please try again.");
                break;
            }
        }
    }
    
    private void closeFile() {
        FormatterTool.closeFormatter();
    }
  
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the diccionario
     */
    public File getDiccionario() {
        return diccionario;
    }

    /**
     * @param diccionario the diccionario to set
     */
    public void setDiccionario(File diccionario) {
        this.diccionario = diccionario;
    }
    
        /**
     * @return the entradas
     */
    public LinkedList<File> getEntradas() {
        return entradas;
    }

    /**
     * @param aEntradas the entradas to set
     */
    public void setEntradas(LinkedList<File> aEntradas) {
        entradas = aEntradas;
    }
    
    public int getNumDeArchivo(){
        return numDeArchivo;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }
}
