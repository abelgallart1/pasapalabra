/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasapalabra;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.FileDialog;
import java.io.IOException;
import java.io.*;
import loquendo.tts.engine.TTSException;
import loquendo.tts.engine.TTSReader;
import loquendo.tts.engine.TTSSession;


/**
 *
 * @author abel
 */
public class PasaPalabra extends javax.swing.JFrame {

    /**
     * Creates new form NewApplication
     */
    
    java.util.Timer tiempo=new java.util.Timer();
    java.util.Timer boca=new java.util.Timer();
    java.util.Timer oido=new java.util.Timer();
    
    int segundos=0;
    TimerTask  timerTask,habla,olle;
    
    String []letras ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o",
                       "p","q","r","s","t","u","v","w","x","y","z"};
    Hashtable diccionario=new Hashtable();
    ArrayList errores=new ArrayList();
    ArrayList aciertos=new ArrayList();
    ArrayList jugada=new ArrayList();
    ArrayList palabras=new ArrayList();
    public FileDialog fd=new FileDialog(this,"",FileDialog.LOAD);
    public ReconocimientoVoz escuchar;
   
    public TTSSession hSession = null; 
        
    public TTSReader hReader = null;

       ArrayList Da=new ArrayList();
       ArrayList Db=new ArrayList();
       ArrayList Dc=new ArrayList();
       ArrayList Dd=new ArrayList();
       ArrayList De=new ArrayList();
       ArrayList Df=new ArrayList();
       ArrayList Dg=new ArrayList();
       ArrayList Dh=new ArrayList();
       ArrayList Di=new ArrayList();
       ArrayList Dj=new ArrayList();
       ArrayList Dk=new ArrayList();
       ArrayList Dl=new ArrayList();
       ArrayList Dm=new ArrayList();
       ArrayList Dn=new ArrayList();
       ArrayList Dñ=new ArrayList();
       ArrayList Do=new ArrayList();
       ArrayList Dp=new ArrayList();
       ArrayList Dq=new ArrayList();
       ArrayList Dr=new ArrayList();
       ArrayList Ds=new ArrayList();
       ArrayList Dt=new ArrayList();
       ArrayList Du=new ArrayList();
       ArrayList Dv=new ArrayList();
       ArrayList Dw=new ArrayList();
       ArrayList Dx=new ArrayList();
       ArrayList Dy=new ArrayList();
       ArrayList Dz=new ArrayList();
   
       ArrayList LETRAS=new ArrayList();
     
       int cursor=0;   
       Palabra palabra;
      
    public PasaPalabra() {
        initComponents();
        setLocationRelativeTo(null);
  
         try { hSession = new TTSSession();
               hReader = new TTSReader(hSession);
	       hReader.setAudio("LTTS7AudioBoard", null, 32000, "linear", 2);
	       hReader.loadPersona("Carmen",null,null);
		
              } catch (Exception e) {e.printStackTrace();} 

        
        
        
         LETRAS.add(0,A);
         LETRAS.add(1,B);
         LETRAS.add(2,C);
         LETRAS.add(3,D);
         LETRAS.add(4,E);
         LETRAS.add(5,F);
         LETRAS.add(6,G);
         LETRAS.add(7,H);
         LETRAS.add(8,I);
         LETRAS.add(9,J);
         LETRAS.add(10,K);
         LETRAS.add(11,L);
         LETRAS.add(12,M);
         LETRAS.add(13,N);
         LETRAS.add(14,Ñ);
         LETRAS.add(15,O);
         LETRAS.add(16,P);
         LETRAS.add(17,Q);
         LETRAS.add(18,R);
         LETRAS.add(19,S);
         LETRAS.add(20,T);
         LETRAS.add(21,U);
         LETRAS.add(22,V);
         LETRAS.add(23,W);
         LETRAS.add(24,X);
         LETRAS.add(25,Y);
         LETRAS.add(26,Z);
         
          Scanner scanner=null;
        while(scanner==null){
          try { 
              
            fd.setVisible(true);
            scanner = new Scanner(new BufferedReader(new FileReader(fd.getDirectory()+fd.getFile())));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PasaPalabra.class.getName()).log(Level.SEVERE, null, ex);
        
         }
        }
        
          
              
              
         while (scanner.hasNextLine()) {
          String aux = scanner.nextLine();
          aux=aux.replaceAll("Ã³", "ó");
          aux=aux.replaceAll("Ã­","í");
          aux=aux.replaceAll("Ã©","é");
          aux=aux.replaceAll("Ãº","ú");
          aux=aux.replaceAll("ú","u");
          aux=aux.replaceAll("Ã¼","ü");
          aux=aux.replaceAll("Ã","á");
          
          aux=aux.replaceAll("�","ñ");
          if (aux!="")   
              
            {
               String[] arr = aux.split(". ",2);
               String  aux1=""; 
                
              for(int i=1;i<arr.length;i++) aux1+=arr[i];
            
                  
              if (arr.length!=0&&arr[0].length()!=0) {diccionario.put(arr[0], aux1);
                                    
              
                               }
            }
        
        }
        
    
       Enumeration en=diccionario.keys();
       while(en.hasMoreElements()){
       String aux=(String)en.nextElement();
      
       
       if (aux.startsWith("a")) Da.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("b")) Db.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("c")) Dc.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("d")) Dd.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("e")) De.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("f")) Df.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("g")) Dg.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("h")) Dh.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("i")) Di.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("j")) Dj.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("k")) Dk.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("l")) Dl.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("m")) Dm.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("n")) Dn.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("ñ")) Dñ.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("o")) Do.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("p")) Dp.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("q")) Dq.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("r")) Dr.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("s")) Ds.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("t")) Dt.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("u")) Du.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("v")) Dv.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("w")) Dw.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("x")) Dx.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("y")) Dy.add(new Palabra(aux,(String)diccionario.get(aux)));
       if (aux.startsWith("z")) Dz.add(new Palabra(aux,(String)diccionario.get(aux)));
       
       
       }
        
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Z = new javax.swing.JButton();
        A = new javax.swing.JButton();
        B = new javax.swing.JButton();
        C = new javax.swing.JButton();
        D = new javax.swing.JButton();
        E = new javax.swing.JButton();
        F = new javax.swing.JButton();
        G = new javax.swing.JButton();
        H = new javax.swing.JButton();
        I = new javax.swing.JButton();
        J = new javax.swing.JButton();
        K = new javax.swing.JButton();
        L = new javax.swing.JButton();
        M = new javax.swing.JButton();
        N = new javax.swing.JButton();
        Ñ = new javax.swing.JButton();
        O = new javax.swing.JButton();
        P = new javax.swing.JButton();
        Q = new javax.swing.JButton();
        R = new javax.swing.JButton();
        S = new javax.swing.JButton();
        T = new javax.swing.JButton();
        U = new javax.swing.JButton();
        V = new javax.swing.JButton();
        W = new javax.swing.JButton();
        X = new javax.swing.JButton();
        Y = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setMinimumSize(new java.awt.Dimension(650, 670));
        setPreferredSize(new java.awt.Dimension(650, 670));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Z.setText("Z");
        Z.setContentAreaFilled(false);
        jPanel1.add(Z, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 50, 40));

        A.setText("A");
        A.setContentAreaFilled(false);
        jPanel1.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        B.setText("B");
        B.setBorderPainted(false);
        B.setContentAreaFilled(false);
        jPanel1.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 50, 40));

        C.setText("C");
        C.setContentAreaFilled(false);
        jPanel1.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 50, 40));

        D.setText("D");
        D.setContentAreaFilled(false);
        jPanel1.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 50, 40));

        E.setText("E");
        E.setContentAreaFilled(false);
        jPanel1.add(E, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 50, 40));

        F.setText("F");
        F.setContentAreaFilled(false);
        jPanel1.add(F, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 50, 40));

        G.setText("G");
        G.setContentAreaFilled(false);
        jPanel1.add(G, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 50, 40));

        H.setText("H");
        H.setContentAreaFilled(false);
        jPanel1.add(H, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 50, 40));

        I.setText("I");
        I.setContentAreaFilled(false);
        jPanel1.add(I, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 50, 40));

        J.setText("J");
        J.setContentAreaFilled(false);
        jPanel1.add(J, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 50, 40));

        K.setText("K");
        K.setContentAreaFilled(false);
        jPanel1.add(K, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 50, 40));

        L.setText("L");
        L.setContentAreaFilled(false);
        jPanel1.add(L, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 50, 40));

        M.setText("M");
        M.setContentAreaFilled(false);
        jPanel1.add(M, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 50, 40));

        N.setText("N");
        N.setContentAreaFilled(false);
        jPanel1.add(N, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 50, 40));

        Ñ.setText("Ñ");
        Ñ.setContentAreaFilled(false);
        jPanel1.add(Ñ, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 50, 40));

        O.setText("O");
        O.setContentAreaFilled(false);
        jPanel1.add(O, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 50, 40));

        P.setText("P");
        P.setContentAreaFilled(false);
        jPanel1.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 50, 40));

        Q.setText("Q");
        Q.setContentAreaFilled(false);
        jPanel1.add(Q, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 50, 40));

        R.setText("R");
        R.setContentAreaFilled(false);
        jPanel1.add(R, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 50, 40));

        S.setText("S");
        S.setContentAreaFilled(false);
        jPanel1.add(S, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 40));

        T.setText("T");
        T.setContentAreaFilled(false);
        jPanel1.add(T, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 50, 40));

        U.setText("U");
        U.setContentAreaFilled(false);
        jPanel1.add(U, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 50, 40));

        V.setText("V");
        V.setContentAreaFilled(false);
        jPanel1.add(V, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 40));

        W.setText("W");
        W.setContentAreaFilled(false);
        jPanel1.add(W, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 50, 40));

        X.setText("X");
        X.setContentAreaFilled(false);
        jPanel1.add(X, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 50, 40));

        Y.setText("Y");
        Y.setContentAreaFilled(false);
        jPanel1.add(Y, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 50, 40));

        jLabel1.setFont(new java.awt.Font("Vladimir Script", 3, 36)); // NOI18N
        jLabel1.setText("PASA  PALABRA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 340, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 70, 30));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 160, -1));

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 501, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jEditorPane1.setEditable(false);
        jEditorPane1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 640, 135));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Comenzar");
        jButton2.setActionCommand("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, 100, 30));

        jButton1.setText("PasoPalabra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 140, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
          
          
        for(int i=0;i<LETRAS.size();i++) ((javax.swing.JButton)LETRAS.get(i)).setContentAreaFilled(false);
         
        jTextField1.setText("");
        aciertos=new ArrayList();
        errores=new ArrayList();
        jugada=new ArrayList();
        palabras=new ArrayList();
        
        palabras.add(Da.get((int)(Da.size()*random.nextFloat())));
        palabras.add(Db.get((int)(Db.size()*random.nextFloat())));
        palabras.add(Dc.get((int)(Dc.size()*random.nextFloat())));
        palabras.add(Dd.get((int)(Dd.size()*random.nextFloat())));
        palabras.add(De.get((int)(De.size()*random.nextFloat())));
        palabras.add(Df.get((int)(Df.size()*random.nextFloat())));
        palabras.add(Dg.get((int)(Dg.size()*random.nextFloat())));
        palabras.add(Dh.get((int)(Dh.size()*random.nextFloat())));
        palabras.add(Di.get((int)(Di.size()*random.nextFloat())));
        palabras.add(Dj.get((int)(Dj.size()*random.nextFloat())));
        palabras.add(Dk.get((int)(Dk.size()*random.nextFloat())));
        palabras.add(Dl.get((int)(Dl.size()*random.nextFloat())));
        palabras.add(Dm.get((int)(Dm.size()*random.nextFloat())));
        palabras.add(Dn.get((int)(Dn.size()*random.nextFloat())));
        palabras.add(Dñ.get((int)(Dñ.size()*random.nextFloat())));
        palabras.add(Do.get((int)(Do.size()*random.nextFloat())));
        palabras.add(Dp.get((int)(Dp.size()*random.nextFloat())));
        palabras.add(Dq.get((int)(Dq.size()*random.nextFloat())));
        palabras.add(Dr.get((int)(Dr.size()*random.nextFloat())));
        palabras.add(Ds.get((int)(Ds.size()*random.nextFloat())));
        palabras.add(Dt.get((int)(Dt.size()*random.nextFloat())));
        palabras.add(Du.get((int)(Du.size()*random.nextFloat())));
        palabras.add(Dv.get((int)(Dv.size()*random.nextFloat())));
        palabras.add(Dw.get((int)(Dw.size()*random.nextFloat())));
        palabras.add(Dx.get((int)(Dx.size()*random.nextFloat())));
        palabras.add(Dy.get((int)(Dy.size()*random.nextFloat())));
        palabras.add(Dz.get((int)(Dz.size()*random.nextFloat())));
               
        
        try {
            FileWriter writer=new FileWriter (fd.getDirectory()+"gramatica.txt");
              
     
     
            writer.write("#JSGF V1.0;"+"\n");
            writer.write("grammar sentence;"+"\n");
            writer.write("\n");
            writer.write("public <sentence> ="+"\n");
            
            for(int i=0;i<palabras.size();i++)
            {writer.write("[<dato"+i+">]"+"\n");
            
            }
           writer.write("[<dato"+palabras.size()+">]"+";\n");
           
           
           writer.write("\n\n");
           writer.write("<dato"+0+">="+"pasopalabra"+";\n");

           for(int i=1;i<=palabras.size();i++)
           {writer.write("<dato"+i+">="+((Palabra)palabras.get(i-1)).nom+";\n");
            
            }            
           
                                             
           writer.close();
         
        } catch (IOException ex) {ex.printStackTrace();}
        
       
        
        if (timerTask!=null) {timerTask.cancel();segundos=0;}
        
        
        ((javax.swing.JButton)LETRAS.get(cursor)).setContentAreaFilled(false);
        cursor=0;        
         
        
        timerTask = new TimerTask() {public void run(){
                                                       jLabel2.setText(segundos+"");
                                                       segundos++;          
                                                       }};
              
        tiempo.scheduleAtFixedRate(timerTask,0,1000);  
              
        jEditorPane1.setText("Con la letra "+letras[cursor]);
        palabra=(Palabra)palabras.get(cursor);
        jEditorPane1.setText(jEditorPane1.getText()+"\n"+palabra.sig);
                                            
         
       ((javax.swing.JButton)LETRAS.get(cursor)).setContentAreaFilled(true);
       ((javax.swing.JButton)LETRAS.get(cursor)).setBackground(Color.WHITE);
       
        
      
      if (habla!=null) {habla.cancel();}
      
       habla = new TimerTask() {public void run(){ 
          
         try { String aux=jEditorPane1.getText().split("3")[0];
               hReader.read(aux, false, false);
            } catch (Exception ex) {ex.printStackTrace();}
         }};
       
      boca.scheduleAtFixedRate(habla,0,30000);   
      
            
    
     if (olle!=null) {olle.cancel();}
    
      escuchar = new ReconocimientoVoz(this,"gramatica.txt");
      
      olle= new TimerTask() {public void run(){ escuchar.reconocerVoz();}};  
         
      oido.scheduleAtFixedRate(olle,0,2000000000);   
      
    
      
      jButton2.setVisible(false);
       // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
//
    Random random=new Random();
  
    public void paso(){
            if  (timerTask==null) return;
            boca.purge();
            
           
    /////fin del rosco     //////////////////////////////////   
   if (jugada.size()==27) {
              
             if (timerTask!=null) {timerTask.cancel();}
             String aux="Ya has completado el rosco, \n"
                     + "en un tiempo de "+segundos+" segundos ,\n"+
                     "Has tenido "+aciertos.size()+ " aciertos, y \n"
                        +errores.size()+" errores; \n";
            
            for(int i=0;i<errores.size();i++) 
                aux+="Con la letra "+((Palabra)errores.get(i)).nom.charAt(0)+","
                      +((Palabra)errores.get(i)).nom+" ;\n";
            
            String aux1=aux.replaceAll("\n","");
         
            if (habla!=null)  {habla.cancel();}
            
            habla = new TimerTask() {public void run(){ 
                        
                 try { hReader.read(aux1, false, false);} catch (Exception ex) {ex.printStackTrace();}
             }};
         
           boca.scheduleAtFixedRate(habla,0,30000);   
                
                 
            javax.swing.JOptionPane.showMessageDialog
              (null,aux,"Fin del juego",javax.swing.JOptionPane.OK_OPTION);
             
                try {
                    dispose();
                    boca.cancel();
                    oido.cancel();
                    tiempo.cancel();
                   
                    boca.purge();
                    oido.purge();
                    tiempo.purge();
                } catch (Throwable ex) {ex.printStackTrace();}
            
            new PasaPalabra().setVisible(true);
    }
 ///////////////////////////////////////////////////////////////////////         
                                   
                
       do { cursor++;
        if (cursor==letras.length) 
            
        {    for(int i=0;i<LETRAS.size();i++) 
             {if (!jugada.contains(i))
              ((javax.swing.JButton)LETRAS.get(i)).setContentAreaFilled(false);  
        
              }   
            cursor=0;
        
        
        }
        
        }  while (jugada.contains(cursor));

                  
          
         ((javax.swing.JButton)LETRAS.get(cursor)).setContentAreaFilled(true);
         ((javax.swing.JButton)LETRAS.get(cursor)).setBackground(Color.WHITE);
       
        
        jEditorPane1.setText("Con la letra "+letras[cursor]);
        palabra=(Palabra)palabras.get(cursor);
        jEditorPane1.setText(jEditorPane1.getText()+"\n"+palabra.sig);
       
       
        
        if (habla!=null)  {habla.cancel();}
                 
         habla = new TimerTask() {public void run(){                 
           
                  String aux=jEditorPane1.getText().split("3")[0];          
                  try { hReader.read(aux, false, false);} catch (Exception ex) { ex.printStackTrace();}
        }};
         
         boca.scheduleAtFixedRate(habla,0,30000);   
        
        jEditorPane1.validate();
        jScrollPane1.validate();

                }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        paso();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
public void ok(){
 if (habla!=null) habla.cancel();
       

 if(palabra.nom.equals(jTextField1.getText())){
                ((javax.swing.JButton)LETRAS.get(cursor)).setContentAreaFilled(true);
                ((javax.swing.JButton)LETRAS.get(cursor)).setBackground(Color.GREEN);
                 
                try { hReader.read("correcto", false, false);} catch (TTSException ex) {ex.printStackTrace();}
                 aciertos.add(palabra); jugada.add(cursor);
            }
  
 else if (jTextField1.getText()!=""){
               ((javax.swing.JButton)LETRAS.get(cursor)).setContentAreaFilled(true);
               ((javax.swing.JButton)LETRAS.get(cursor)).setBackground(Color.RED);
               try {hReader.read("incorrecto", false, false);} catch(Exception ex) {ex.printStackTrace();}
                 errores.add(palabra); jugada.add(cursor);
            }
         
 paso();
}
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            ok();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasaPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasaPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasaPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasaPalabra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasaPalabra().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A;
    private javax.swing.JButton B;
    private javax.swing.JButton C;
    private javax.swing.JButton D;
    private javax.swing.JButton E;
    private javax.swing.JButton F;
    private javax.swing.JButton G;
    private javax.swing.JButton H;
    private javax.swing.JButton I;
    private javax.swing.JButton J;
    private javax.swing.JButton K;
    private javax.swing.JButton L;
    private javax.swing.JButton M;
    private javax.swing.JButton N;
    private javax.swing.JButton O;
    private javax.swing.JButton P;
    private javax.swing.JButton Q;
    private javax.swing.JButton R;
    private javax.swing.JButton S;
    private javax.swing.JButton T;
    private javax.swing.JButton U;
    private javax.swing.JButton V;
    private javax.swing.JButton W;
    private javax.swing.JButton X;
    private javax.swing.JButton Y;
    private javax.swing.JButton Z;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    private javax.swing.JButton Ñ;
    // End of variables declaration//GEN-END:variables

}
