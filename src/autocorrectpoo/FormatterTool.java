package autocorrectpoo;

import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class FormatterTool{
    private static Formatter formatter;
    
    public static void initialize(String nombre){
        try{
            formatter = new Formatter("src/res/" + nombre + ".dat");
        }
        catch(FileNotFoundException e){
            
        }
    }
    
    public static void closeFormatter(){
        if(formatter!=null){
                 formatter.close();
            }
    }
    public static Formatter getFormatter(){
        return formatter;
    }
    
    public static String fileToString(File file){
        try{
            Scanner input = new Scanner(file);
            String output = "";
            
            while(input.hasNext()){
                output += input.next() + " ";
            }
            input.close();
            return output;
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
        }
        return null;
    }
}
