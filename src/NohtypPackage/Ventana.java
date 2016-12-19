/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NohtypPackage;

import static NohtypPackage.Token.ERROR;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
/**
 *
 * 
 */
public class Ventana extends javax.swing.JFrame {
Thread hilo=new Thread(){
    @Override
   public void run(){
       int temp=0;
        while (true){
          //  nlineas.setText("");
            temp=txtCodigo.getText().split("\n").length;
            for(int i=0;i<temp;i++){}
         //       nlineas.setText(nlineas.getText()+(i+1)+"\n");
           try {
               synchronized(this){
               wait(100);}
           } catch (InterruptedException ex) {
               Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
};
AttributeSet reservado;
AttributeSet normal;
AttributeSet comentario;
AttributeSet numero;
StyleContext st;
DefaultStyledDocument sd;
Color texto,reser,num,comen;
TablaDS src;
String copia="";
Config con;
DefaultTableModel dinamica;
DefaultTableModel estatica;
TablaDS tablas = new TablaDS();
Tablas tables;
int cont=0;
long inicio,iniciol,finl,inicios,fins;
String nombre="",nombreasm="",nombrepath="";

public void lineas(){
    int temp=0;
// nlineas.setText("");
            temp=txtCodigo.getText().split("\n").length;
            for(int i=0;i<temp;i++){}
               // nlineas.setText(nlineas.getText()+(i+1)+"\n");
}

public static void error(String name){
ver=true;
//jTextArea2.setText("");
jTextArea2.setText(jTextArea2.getText()+name+"\n");
jTextArea2.setForeground(Color.red);
jTextArea2.setCaretPosition(0);

}
        List<Identificadores> tokenslist;
        public static boolean ver=false;
        
        
        
        
        
    public Ventana() {
        initComponents();
        this.setLocation(70,20);
        
        javax.swing.JScrollPane sp1= new javax.swing.JScrollPane(txtCodigo);
        TextLineNumber a=new TextLineNumber(txtCodigo);
        sp1.setRowHeaderView(a);
        sp1.setSize(980, 380);
        jPanel2.add(sp1);
        sp1.setLocation(20, 55);
        
    //    hilo.start();
        dinamica= new javax.swing.table.DefaultTableModel(new Object[] {"Cadena","Tipo","Atributo","Contexto"}, 0);
        inicio=iniciol=finl=inicios=fins=0;
        
        texto=Color.BLACK;
        reser=Color.magenta;
        src=new TablaDS();
        comen=Color.RED;
        num=Color.blue;
        con= new Config(this,true);
        
        st=StyleContext.getDefaultStyleContext();
        reservado=st.addAttribute(st.getEmptySet(), StyleConstants.Foreground, reser);
        normal=st.addAttribute(st.getEmptySet(), StyleConstants.Foreground, texto);
        comentario=st.addAttribute(st.getEmptySet(), StyleConstants.Foreground, comen);
        numero=st.addAttribute(st.getEmptySet(), StyleConstants.Foreground, num);
                estatica= src.TablaEstatica;
                estatica.addColumn("Tipo", new Object[]{"PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada",
        "PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada",
        "PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada",
        "PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada",
        "PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada","PalabraReservada"});
                
                
                
        sd=new DefaultStyledDocument(){
          

            @Override
           
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                
                try{
                super.insertString(offs, str, a); //To change body of generated methods, choose Tools | Templates.
               
                int inicio = PrimerBlanco(getText(0,this.getLength()), offs); //Ultimo espacio en blanco (enter,espacio,tabulador,etc)
                if (inicio < 0) 
                    inicio = 0;
                int fin=UltimoBlanco(getText(0,this.getLength()),offs+str.length());
                int index=inicio;
                int index2=inicio;
                
                int iGato=PrimerGato(getText(0,this.getLength()), offs);
                int uGato=Ultimoenter(getText(0,this.getLength()), offs);
                if(iGato<0)
                    iGato=0;
                
                int indexG1=iGato;
                int indexG2=iGato;
                
                while(index<=fin){
                    
                    if(index==fin || String.valueOf(getText(0,this.getLength()).charAt(index)).matches("\\W")){
                        if(validarPReservadas(getText(0,this.getLength()).substring(index2, index)))
                
                        setCharacterAttributes(index2, index - index2, reservado, false);
                        else
                            setCharacterAttributes(index2, index - index2, normal, false);
                                                if(getText(0,this.getLength()).substring(index2, index).matches("(\\s)*(\\d)*"))
                            setCharacterAttributes(index2, index - index2, numero, false); 
                        index2 = index;
                        
                    }
                    
                    
                    index++;
                }
                
                  while(indexG1<=uGato){
                    
                    if(indexG1==uGato || String.valueOf(getText(0,this.getLength()).charAt(indexG1)).matches("\\W")){
                        if(getText(0,this.getLength()).substring(indexG2, indexG1).matches("(#)+(\\w)*"))
                
                        setCharacterAttributes(indexG2, Ultimoenter(getText(0,getLength()),iGato)-indexG2, comentario, false);                       
                        
                        indexG2 = indexG1;
                        
                    }
                    
                    
                    indexG1++;
                }
                
                }
                catch(NullPointerException e){
                    System.out.println(e);
                }
                
                lineas();
            
            }
            
            
            
            /*
            @Override
            
            
            
            public void remove (int offs, int len) throws BadLocationException {
                try{
                super.remove(offs, len);

                String texto = getText(0, getLength());
                int inicio =PrimerBlanco(texto, offs);
                if (inicio < 0) inicio = 0;
                int fin = UltimoBlanco(texto, offs);
                
                int primerGato=PrimerGato(texto,offs);
                if (primerGato<0)
                    primerGato=0;
                int ultimoenter=Ultimoenter(texto,offs);
                    
                
                
                if (validarPReservadas(texto.substring(inicio, fin))) {
                    setCharacterAttributes(inicio, fin - inicio, reservado, false);
                } else {
                    setCharacterAttributes(inicio, fin - texto.length(), normal, false);
                }
                
                if(texto.substring(primerGato, ultimoenter).matches("(#)+(\\w| |#)*")){
                    setCharacterAttributes(primerGato, ultimoenter - primerGato, comentario, false);
                }
                else
                    setCharacterAttributes(offs, ultimoenter-offs, normal, false);
                
                if (texto.substring(inicio, fin).matches("(\\s)*(\\d)*")) {
                    setCharacterAttributes(inicio, fin - inicio, numero, false);
                } else {
                    setCharacterAttributes(inicio, fin - texto.length(), normal, false);
                }
                    lineas();}
                catch(Exception w){
                
                
                }
            } */

            
            
        };
        
        txtCodigo.setDocument(sd);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/projectavatar.png")));
        tables=new Tablas(this,true);
    }
      
    private boolean validarPReservadas(String texto){
        for(int i=0;i<33;i++){
           if(texto.matches("(\\s)*("+src.TablaEstatica.getValueAt(i, 0)+")")) 
            return true;
            
        }
        
        
        return false;
    }

    public void inTexto(String s){
        txtCodigo.setText(s);
    }
    
    public String obTexto(){
        return txtCodigo.getText();
    }
    
     private int PrimerBlanco (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int UltimoBlanco (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }
    
     private int PrimerGato(String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("#")) {
                break;
            }
            
        }
        return index;
    }
    
     private int Ultimoenter (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\n")) {
                break;
            }
            index++;
        }
        return index;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Codinter = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nohtyp [Beta] v3.0");
        setBackground(new java.awt.Color(153, 255, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save31 (1).png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file98.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/text70.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/right133.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectavatar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(39, 39, 39)
                .addComponent(jLabel7)
                .addGap(48, 48, 48)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nohtyp Compiler v1.0"));
        jPanel2.setForeground(new java.awt.Color(255, 0, 0));

        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane4.setViewportView(txtCodigo);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 205, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Resultados");

        Codinter.setEditable(false);
        Codinter.setBackground(new java.awt.Color(204, 204, 255));
        Codinter.setColumns(20);
        Codinter.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        Codinter.setRows(5);
        jScrollPane3.setViewportView(Codinter);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("Archivo");

        jMenuItem4.setText("Nuevo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Abrir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Guardar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Seleccionar todo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Copiar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Pegar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Análisis");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Revisar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Revisar y compilar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Configuración");

        jMenuItem9.setText("Colores");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void probarLexerFile() throws IOException{
        int contIDs=0;
        cont=0;
        dinamica.setRowCount(cont);
        tokenslist = new LinkedList<Identificadores>();
        File fichero = new File ("Codigo.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(fichero);
            writer.print(txtCodigo.getText());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
      Lexer lexer = new Lexer (reader);
        String resultado="";
        while (true){
            Token token=lexer.yylex();
            if (token == null){
                for(int i=0;i<tokenslist.size();i++){
                   
                }
              jTextArea1.setText("\n"+resultado+"\n");
                return;
            }
            switch (token){
                case PalabraReservada:
                    resultado=resultado+ "<PalabraReservada, "+lexer.lexeme +" >"+"\n";
                    dinamica.addRow(new Object[] {"<PalabraReservada, "+lexer.lexeme +" >","PalabraReservada",lexer.lexeme,""});
                    break;
                case operadoresAritmeticos:
                    resultado=resultado+ "<Operador Aritmetico, "+lexer.lexeme +" >"+"\n";
                    dinamica.addRow(new Object[] {"<Operador Aritmetico, "+lexer.lexeme +" >","Operador Aritmetico",lexer.lexeme,""});
                    cont++;
                    break;
                 case ERROR:
                    resultado=resultado+ "El Simbolo no se encuentra en el Alfabeto";
               
                    cont++;
                    break;
                case comentarios:
                    resultado=resultado+ "<Comentarios, "+lexer.yytext()+" > "+"\n";
                   
                    cont++;
                    break;
                case Lineascomentarios:
                    resultado=resultado+ "<Comentarios, "+lexer.yytext()+" > "+"\n";
                    
                    cont++;
                    break;
                case operadoresOperacion:
                    resultado=resultado+ "<Operador De Operacion, "+lexer.yytext()+" > "+"\n";
                   dinamica.addRow(new Object[] {"<Operador De Operacion, "+lexer.yytext()+" > ","Operador",lexer.lexeme,""});
                    cont++;
                    break;
                case operadoresAsignacion:
                    resultado=resultado+ "<Operador de Asignacion, "+lexer.yytext()+" > "+"\n";
                    dinamica.addRow(new Object[] {"<Operador de Asignacion, "+lexer.yytext()+" > ","Operador Asignacion",lexer.lexeme,""});
                    cont++;
                    break;
                case operadoresBit:
                    resultado=resultado+ "<Operador de Nivel de Bit, "+lexer.yytext()+" > "+"\n";
                     dinamica.addRow(new Object[] {"<Operador de Nivel de Bit, "+lexer.yytext()+" > ","Operador BIt",lexer.lexeme,""});
                    cont++;
                    break;
                case operadoresBoleanos:
                resultado=resultado+ "<Operador Booleano, "+lexer.yytext()+" > "+"\n";
                 dinamica.addRow(new Object[] {"<Operador Booleano, "+lexer.yytext()+" > ","Operador booleano",lexer.lexeme,""});
                    cont++;
                break;
                case operadoresAgrupacion:    
                resultado=resultado+ "<Operador Agrupacion, "+lexer.yytext()+" > "+"\n";
                dinamica.addRow(new Object[] {"<Operador Agrupacion, "+lexer.yytext()+" > ","Operador Agrupacion",lexer.lexeme,""});
                    cont++;
                break;
                case ID: {
                    contIDs++;
                    Identificadores tokenitem=new Identificadores();
                    tokenitem.nombre=lexer.lexeme;
                    tokenitem.ID=contIDs;
                    tokenslist.add(tokenitem);
                    resultado=resultado+ "<Identificador" + contIDs+","+lexer.yytext()+ "> "+"\n";
                    dinamica.addRow(new Object[] {"<Identificador" + contIDs+","+lexer.yytext()+ "> ","Identificador",lexer.lexeme,""});
                    cont++;
                    break;
                }
                case INT:
                    resultado=resultado+ "< Numero ," + lexer.yytext() + "> "+"\n";
                     dinamica.addRow(new Object[] {"< Numero ," + lexer.yytext() + "> ","Entero",lexer.lexeme,""});
                    cont++;
                    break;
                case REAL:
                    resultado=resultado+ "< Real ," + lexer.yytext() + "> "+"\n";
                     dinamica.addRow(new Object[] {"< Real ," + lexer.yytext() + "> ","Real",lexer.lexeme,""});
                    cont++;
                    break;
                default:
                    resultado=resultado+ "<"+ lexer.lexeme + "> ";
                    
                    cont++;
            }
    }
 }
 
 
 private String abrirArchivo() {
  String aux="";   
  String texto="";
  try
  {
   /**llamamos el metodo que permite cargar la ventana*/
   JFileChooser file=new JFileChooser();
   file.showOpenDialog(this);
   /**abrimos el archivo seleccionado*/
   File abre=file.getSelectedFile();
   nombre=abre.toString();
   /**recorremos el archivo, lo leemos para plasmarlo
   *en el area de texto*/
   if(abre!=null)
   {     
      FileReader archivos=new FileReader(abre);
      BufferedReader lee=new BufferedReader(archivos);
      while((aux=lee.readLine())!=null)
      {
         texto+= aux+ "\n";
      }
         lee.close();
    }    
   }
   catch(IOException ex)
   {
     JOptionPane.showMessageDialog(null,ex+"" +
           "\nNo se ha encontrado el archivo",
                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
    }
  return texto;//El texto se almacena en el JTextArea
}
 
 
  private void guardarasm(){
   
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File archivo =file.getSelectedFile();
  if(archivo !=null){
  nombreasm=archivo.toString();nombrepath=archivo.getAbsolutePath();}
  if(archivo !=null)
  {
         try {
             /*guardamos el archivo y le damos el formato directamente,
             * si queremos que se guarde en formato doc lo definimos como .doc*/
             FileWriter  save=new FileWriter(archivo+".asm");
             save.write(TablaDS.codasm);
             save.close();
             JOptionPane.showMessageDialog(null,
                     "El archivo se a guardado Exitosamente",
                     "Información",JOptionPane.INFORMATION_MESSAGE);
            
         } catch (IOException ex) {
             Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
  
 }
 
 
 private void guardar(){
   
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File archivo =file.getSelectedFile();
  if(archivo !=null)
  nombre=archivo.toString();
  if(archivo !=null)
  {
         try {
             /*guardamos el archivo y le damos el formato directamente,
             * si queremos que se guarde en formato doc lo definimos como .doc*/
             FileWriter  save=new FileWriter(archivo+".txt");
             save.write(txtCodigo.getText());
             save.close();
             JOptionPane.showMessageDialog(null,
                     "El archivo se a guardado Exitosamente",
                     "Información",JOptionPane.INFORMATION_MESSAGE);
            
         } catch (IOException ex) {
             Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
  
 }
 
 public void imprimir(String t){
     jTextArea1.setText(jTextArea1.getText()+t+"\n");     
 }
 
 public void compilar(){
     
     try {  
            Process p = Runtime.getRuntime().exec("ml  /c  /coff  /Cp /Fo "+nombreasm+" "+nombreasm+".asm");  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
     
      try {  
            Process p = Runtime.getRuntime().exec("link /SUBSYSTEM:console  /LIBPATH:c:\\masm32\\lib /OUT:"+nombreasm+".exe "+nombreasm+".obj");  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
 }
 
 private void checar(){
      iniciol=inicio=System.currentTimeMillis();
        jTextArea1.setText("");
        jTextArea2.setText("");
        ver=false;
        
        TablaDS.Crear();
        
    try {
        probarLexerFile();
    } catch (IOException ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    new CreaLexer(); 
        
        
        jTextArea2.setText("");
        File fichero = new File ("Codigo.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(fichero);
            writer.print(txtCodigo.getText());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    try {
        finl=inicios=System.currentTimeMillis();
        Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
        new Sintactico(new Lexer2(reader)).parse();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    Codinter.setText("");
    fins=System.currentTimeMillis();
    if(jTextArea2.getText().equals("")){
        TablaDS.cerox();
        TablaDS.cerocod();
        TablaDS.ceroy();
        jTextArea2.setText("0 errores detectados\n Ya puedes compilar tu código desarrollador ");
    }
 }
 
 
 private void guycomp(){
     iniciol=inicio=System.currentTimeMillis();
        jTextArea1.setText("");
        jTextArea2.setText("");
        ver=false;
        
        TablaDS.Crear();
        
    try {
        probarLexerFile();
    } catch (IOException ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    new CreaLexer(); 
        
        
        jTextArea2.setText("");
        File fichero = new File ("Codigo.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(fichero);
            writer.print(txtCodigo.getText());
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    try {
        finl=inicios=System.currentTimeMillis();
        Reader reader = new BufferedReader(new FileReader("Codigo.txt"));
        new Sintactico(new Lexer2(reader)).parse();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    Codinter.setText("");
    fins=System.currentTimeMillis();
    if(jTextArea2.getText().equals("")){
        if(!nombre.equals("")){
        TablaDS.cerox();
        TablaDS.cerocod();
        TablaDS.ceroy();
        jTextArea2.setText("Compilado sin errores en "+(System.currentTimeMillis()-inicio)+" milisegundos\nLexico: "+(finl-iniciol)+" milisegundos\nSintáctico: "+(fins-inicios)+" milisegundos");
        Reader reader;
        
    try {
        reader = new BufferedReader(new FileReader("Codigo.txt"));
        new Sintactico2(new Lexer2(reader)).parse(); //generar codigo intermedio
        
        TablaDS.ceroasm();
        
        reader = new BufferedReader(new FileReader("Codigo.txt"));
        new Sintactico3(new Lexer2(reader)).parse(); // generar código ensamblador
        
        TablaDS.comAsm(); //da el formato general al programa asm
        
        if(!nombre.equals("")){
            guardarasm();
            compilar();
            
            
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this, "Es necesario que guardes tu proyecto para generar el ejecutable");
        }
        
        
        
        System.out.println(TablaDS.codasm);
        
        
         Codinter.setText(TablaDS.codinter); //imprime código intermedio
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    } catch (Exception ex) {
        Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
         else{
            javax.swing.JOptionPane.showMessageDialog(this, "Es necesario que guardes tu proyecto para generar el ejecutable");
        }
    }
   
       String [] temp= txtCodigo.getText().split("\n");
    jTextArea2.setText(jTextArea2.getText()+"\nTotal filas analizadas: "+temp.length);
 }
 
 
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
txtCodigo.setSelectionStart(0);
txtCodigo.setSelectionEnd(txtCodigo.getText().length());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
copia=txtCodigo.getSelectedText();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
txtCodigo.setText(txtCodigo.getText()+copia);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
this.guardar();
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        txtCodigo.setText("");
        jTextArea1.setText("");
        jTextArea2.setText("");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        txtCodigo.setText(this.abrirArchivo());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
checar();         // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
guycomp();
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
   this.guardar();       // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

   txtCodigo.setText(this.abrirArchivo());  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked

        txtCodigo.setText("");
        jTextArea1.setText("");
        jTextArea2.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
guycomp();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
con.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Codinter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane txtCodigo;
    // End of variables declaration//GEN-END:variables
}
