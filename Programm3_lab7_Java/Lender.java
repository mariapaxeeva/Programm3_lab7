import java.util.HashMap;

public class Lender implements Cloneable{
    private String typeLender;
    private String title;

    public Lender() {
        this.typeLender = "none";
        this.title = "none";
    }

    public Lender(String type) {
        this();
        this.typeLender = type;
    }

    public Lender(String type, String titleValue) {
        this.typeLender = type;
        this.title = titleValue;
    }

    public Object clone(){  
        try{  
            return super.clone();  
        }catch(Exception e){ 
            return null; 
        }
    }

    public String GetTypeLender() {
        return typeLender;
    }

    public void SetTypeLender(String type) {
        typeLender = type;
    }

    public String GetTitle() {
        return title;
    }

    public void SetTitle(String titleNew) {
        title = titleNew;
    }
}