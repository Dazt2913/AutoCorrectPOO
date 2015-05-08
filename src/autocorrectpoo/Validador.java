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
                String sc2 = scanner.next();
                list.add(sc2);
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
        double[] authors = new double[autor.size()];
        for (int i = 0; i < authors.length; i++) {
            authors[i] = 0;
        }
        for (int i = 0; i<codeList.size(); i++) {
            for (int j = 0; j<dictionaryList.size(); j++) {
                LinkedList<String> tempDic = (LinkedList)dictionaryList.get(j);
                if(tempDic.contains(codeList.get(i))) {
                    authors[j]++;
                }
            }
        }  
        LinkedList<String> finalAuthors = new LinkedList();
        for (int i = 0; i<autorNames.size(); i++) {
           double percentage = (100.0 * authors[i]) / codeList.size();
           authors[i] = percentage;
           String text = String.format("%s - %.1f", autorNames.get(i), percentage);
           text += "%";
           finalAuthors.add(text);
        }
        Collections.sort(finalAuthors);
        return finalAuthors;
    }
}
