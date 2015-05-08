package autocorrectpoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Validador {
    
    private LinkedList<String> makeCodeArray(File file) {
        LinkedList<String> list = new LinkedList();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[\\W]+"); 
            while (scanner.hasNext()) {
                list.add(Autor.getWordCode(scanner.next().toLowerCase()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    private LinkedList<String> makeDicArray(Autor autor) {
        LinkedList<String> list = new LinkedList();
        try {
            Scanner scanner = new Scanner(autor.getDiccionario());
            scanner.useDelimiter("[\\W]+"); 
            while (scanner.hasNext()) {
                String sc1 = scanner.next();
                System.out.println("1-" + sc1);
                String sc2 = scanner.next();
                list.add(sc2);
                 System.out.println("2-" + sc2);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public LinkedList<String> Validate(LinkedList<Autor> autor, File file) {
        LinkedList dictionaryList = new LinkedList();
        LinkedList autorNames = new LinkedList();
        for (int i = 0; i<autor.size(); i++) {
            dictionaryList.add(makeDicArray(autor.get(i)));
            Autor aut = autor.get(i);
            autorNames.add(aut.getNombre());
        }
        LinkedList<String> codeList = makeCodeArray(file);
        LinkedList<Double> authorsMatch = new LinkedList();
        
            for (int j = 0; j<dictionaryList.size(); j++) {
            LinkedList<String> temp = (LinkedList)dictionaryList.get(j);
            System.out.println("t:" + temp.get(j));    
            if (codeList.contains(temp.get(j)) == true) {
                
                    if (authorsMatch.size()==0) {
                        authorsMatch.add(j, 1.0);
                    } else {
                        authorsMatch.add(j, j+1.0); 
                    }
             
            }
            }  
        LinkedList<String> finalAuthors = new LinkedList();
        for (int i = 0; i<autorNames.size(); i++) {
           double percentage = (100.0 * authorsMatch.get(i)) / codeList.size();
           System.out.println(authorsMatch.get(i));
           authorsMatch.add(i, percentage);
           String text = String.format("%s - %.2f", autorNames.get(i), percentage);
           finalAuthors.add(text);
        }
        Collections.sort(finalAuthors);
        return finalAuthors;
    }
}
