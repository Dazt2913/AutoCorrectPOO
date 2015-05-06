package autocorrectpoo;

import java.util.LinkedList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class AutorLab {
    private static AutorLab sAutorLab;
    private LinkedList<Autor> mAutoresLinkedList;
    private ObjectInputStream input;
    
    private AutorLab(){
        mAutoresLinkedList = new LinkedList<>();
        initObjectInputStream();
        addToAutoresLinkedList();
    }
    
    public static AutorLab get(){
        if(sAutorLab == null){
            sAutorLab = new AutorLab();
        }
        return sAutorLab;
    }
    
    private void initObjectInputStream(){
        try{
            input = new ObjectInputStream(new FileInputStream("src/res/autores.dat"));
        }
        catch(IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error loading authors.");
            System.exit(1);
        }
        finally{
        }
    }
    
    private void addToAutoresLinkedList(){
        if(input!=null){
            try{
                while(true){
                    mAutoresLinkedList.add((Autor)input.readObject());
                }
            }
            catch(EOFException e){
            }
            catch(IOException|ClassNotFoundException e){
            }
            finally{
            }
        }
    }
}