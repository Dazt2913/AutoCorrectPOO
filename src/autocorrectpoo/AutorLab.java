/*
    Singleton to manage all the authors and its files
*/

package autocorrectpoo;

import java.util.LinkedList;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;

public class AutorLab {
    private static AutorLab sAutorLab;
    private LinkedList<Autor> mAutoresLinkedList;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    private AutorLab(){
        mAutoresLinkedList = new LinkedList<>();
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
    
    private void initObjectOutputStream(){
        try{
            output = new ObjectOutputStream(new FileOutputStream("src/res/autores.dat"));
        }
        catch(IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error uploading authors.");
            System.exit(1);
        }
        finally{
        }
    }
    
    private void closeFile(ObjectInputStream i){
        try{
            if(i != null){
                i.close();
            }
        }
        catch(IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error");
            System.exit(1);
        }
        finally{
        }
    }
    private void closeFile(ObjectOutputStream o){
        try{
            if(o != null){
                o.close();
            }
        }
        catch(IOException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Error");
            System.exit(1);
        }
        finally{
        }
    }
    
    private void addToAutoresLinkedList(){
        initObjectInputStream();
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
                closeFile(input);
            }
        }
        
        if(mAutoresLinkedList.size()==0){
            mAutoresLinkedList.add(new Autor("[sin autor]"));
        }
    }
    
    public void modificarAutoresDeArchivo(Autor[] nuevosAutores){
        if(nuevosAutores != null){
            initObjectOutputStream();
            if(output != null){
                try{
                    LinkedList<Autor> nuevaLinkedList = new LinkedList<>();

                    for(Autor a: nuevosAutores){
                        nuevaLinkedList.add(a);
                        output.writeObject(a);
                    }

                    mAutoresLinkedList = nuevaLinkedList;
                }
                catch(IOException e){
                    javax.swing.JOptionPane.showMessageDialog(null, "Error saving authors");
                    System.exit(1);
                }
                finally{
                    closeFile(output);
                }
            }
        }
    }
    
    public Autor[] getAutores(){
        Autor[] autores = new Autor[mAutoresLinkedList.size()];
        for(int i=0; i<autores.length; i++){
            autores[i] = (Autor)mAutoresLinkedList.get(i);
        }
        return autores;
    }
}