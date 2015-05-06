package autocorrectpoo;

public class AutorLab {
    private static AutorLab sAutorLab;
    
    private AutorLab(){
    }
    
    public static AutorLab get(){
        if(sAutorLab == null){
            sAutorLab = new AutorLab();
        }
        return sAutorLab;
    }
}