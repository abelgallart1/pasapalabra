
package pasapalabra;

import java.io.FileReader;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.*;

public class ReconocimientoVoz extends ResultAdapter implements Runnable {

    PasaPalabra p;
    public Recognizer reconocedorVoz;
    String palabra="";
    String gramatica;
    public ReconocimientoVoz(PasaPalabra p,String gramatica  ) {this.p= p;this.gramatica=gramatica;}

   @Override
    public void resultAccepted(ResultEvent re) {
            
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            
           
            for (int i = 0; i < tokens.length; i++) {
                palabra = tokens[i].getSpokenText();
               
                System.out.println(palabra);
                p.jTextField1.setText(palabra);
               
                if (palabra.equals("pasopalabra")){p.paso();}
                
                else{ p.ok();}
                
            }
        } catch (Exception ex) {ex.printStackTrace();}
    }

    public void reconocerVoz() {
        
                
        
        try {
            
            reconocedorVoz = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            reconocedorVoz.allocate();

            FileReader file = new FileReader(p.fd.getDirectory()+this.gramatica);
            
            RuleGrammar reglaGramatica = reconocedorVoz.loadJSGF(file);
            
           reconocedorVoz.addResultListener(new ReconocimientoVoz(p,this.gramatica));
           reconocedorVoz.commitChanges();
           reconocedorVoz.requestFocus();
       
           
        
        } catch (Exception e) {System.out.println("Error en " + e.toString());}
    }

    @Override
    public void run() {this.reconocerVoz();}
}
