package NohtypPackage;


import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Principal
 */
public class TablaDS {
    public static DefaultTableModel Dinamico= new javax.swing.table.DefaultTableModel(new Object[]{"Nombre","tipo","valor","Direccion","linea"}, 0);
    public static DefaultTableModel Errores= new javax.swing.table.DefaultTableModel(new Object[][]{},new Object[]{});
    
    //Cosas para la generción de código intermedio
    static String codinter="",codasm="";
    static boolean prueba=true;
    DefaultTableModel TablaEstatica;
    static int x=1; //x es el contador para temporales
    static int y=1;//y es el contador para etiquetas
 public static void incx(){x+=1;}
 public static void cerox(){x=1;}
 public static void incy(){y+=1;}
 public static void ceroy(){y=1;}
 public static void cerocod(){codinter="";}
 public static void ceroasm(){codasm="";}
 
 
    TablaDS(){
        
        TablaEstatica=new javax.swing.table.DefaultTableModel(new Object [][]{
            {"False"},{"True"},{"and"},
            {"elif"},{"else"},{"for"},
           {"if"},{"in"},{"not"},{"or"},{"while"},{"input"},{"xinput"},{"str"},{"print"},{"range"},{"array"},{"xarray"}                                                                    
            }, new Object[]{"PReservadas"});
        
        
    }
    
    
    public static void comAsm(){
        String temp=".486\n.model flat, stdcall\noption casemap:none\ninclude \\masm32\\include\\masm32rt2.inc\n"
                + "include \\masm32\\include\\Fpu.inc \nincludelib \\masm32\\lib\\Fpu.lib\n.data\nrange dd 0,0,0\nxrange dd 0,0,0\n";
        String vars="";
        for(int i=0; i<Dinamico.getRowCount();i++){
            if(!Dinamico.getValueAt(i, 1).toString().equals("String"))
                 vars=vars+Dinamico.getValueAt(i, 0)+" dd 0,0,0,0,0,0,0,0,0,0,0,0 \n";
            else{
                if(!Dinamico.getValueAt(i, 2).toString().equals(""))
                    vars=vars+Dinamico.getValueAt(i, 0)+" db "+Dinamico.getValueAt(i, 2)+", 500 dup(0)\n";
                else
                    vars=vars+Dinamico.getValueAt(i, 0)+" db 0,500 dup(0) \n";
            }
        }
        vars=vars+".data?\n xinput db 500 dup(?)\n xarray dd 500 dup(?)\n";
        temp=temp+vars+".code\nstart:\n"+codasm+" printf(\"\\n\") \ninkey \" fin ejecucion \" \ninvoke ExitProcess,0 \nend start";
        codasm=temp;
        
    }
    
    
    public static void Crear(){
        Dinamico.setRowCount(0);
    }
    
    public static int Buscar(Object a){
        
      
        for(int i=0; i<Dinamico.getRowCount();i++){
            if(Dinamico.getValueAt(i, 0).equals(a))
                return i;
        }
        
        return -1;
    }
    
    public static String ObtenerTipo(Object x){
        Object temp=x;
        if(temp.toString().equalsIgnoreCase("True") || temp.toString().equalsIgnoreCase("False"))
            return "Boolean";
        
        int temp2=Buscar(temp);
        if (temp2==-1)return "";
        
        return Dinamico.getValueAt(temp2, 1).toString();
    }
    
    public static void ValidarTipo(Object x, int linea, String tipo){
        
        //if(!(tipo.equals("Integer") && (x.toString().matches("[0-9]*\\.[0-9]*") || x.toString().matches("[0-9]*") ))){
            
        int temp=Buscar(x);
        if (temp!=-1){
        if (Dinamico.getValueAt(temp, 1).equals(""))
            Ventana.error("Error en la linea "+linea+", la variable '"+x+"' no ah sido declarada");
        if(tipo.equals("Num")){
            if(!(Dinamico.getValueAt(temp, 1).equals("Integer") || Dinamico.getValueAt(temp, 1).equals("Real")))
              Ventana.error("Error en la linea "+linea+", la variable '"+x+"' no es compatible para la expresion!");
        
        }
        
       
        else
       {
        if(!Dinamico.getValueAt(temp, 1).equals(tipo))
            Ventana.error("Error en la linea "+linea+", la variable '"+x+"' no es compatible para la expresion");}
        
        }
        //}
    }
    
    public static void ValidarExTipo(Object x, int linea, String tipo){
        
       x=x.toString().replaceAll("\\+"," ");
        x=x.toString().replaceAll("-"," ");
        x=x.toString().replaceAll("\\*"," ");
        x=x.toString().replaceAll("/"," ");
        x=x.toString().replaceAll("\\(","");
        x=x.toString().replaceAll("\\)","");
        
        String[] temp=x.toString().split(" ");
        
        for(int i=0; i<temp.length;i++){
            if(!temp[i].matches("[0-9]*"))
            ValidarTipo(temp[i],linea,tipo);
        }
        
    }
    
    public static boolean Insertar(Object valor,String lugar,int linea, String param, String tipo){
         int temp=Buscar(valor);
        
        if(param.equals("id") && temp==-1){
            Dinamico.addRow(new Object[]{valor,"","","",linea}); return true;}
        
        temp=Buscar(lugar);
        
  
        if(param.equals("tipo")){
            if(Dinamico.getValueAt(temp, 1).equals(""))
            Dinamico.setValueAt(valor, temp, 1);
        
        }
        
        if (param.equals("valor")){
            
           if(valor!=null)
            if(!(valor.toString().equalsIgnoreCase("True") || valor.toString().equalsIgnoreCase("False")))
               
            if(valor.toString().matches("[a-zA-z]*")){
                int temp2=Buscar(valor);
                if (Dinamico.getValueAt(temp2, 2).equals(""))
                    Ventana.error("Error en la linea "+linea+", la variable '"+valor+"' no ah sido declarada");
                else{
                    if(Dinamico.getValueAt(temp, 2).equals("")){
                        Dinamico.setValueAt(Dinamico.getValueAt(temp2, 1), temp, 1); //Tipo de y asignado a x
                        Dinamico.setValueAt(Dinamico.getValueAt(temp2, 2), temp, 2); //Valor de y asignado a x
                        System.out.println("heuhuehue1");
                        ;
                            }
                    else{
                        ValidarTipo(valor,linea,Dinamico.getValueAt(temp, 1).toString());
                        if(!Ventana.ver){
                            Dinamico.setValueAt(Dinamico.getValueAt(temp2, 2), temp, 2);
                            System.out.println("heuhuehue2");
                            }
                            
                    
                    }
                }
                        
                        
            }
            
            
            else{
            if(Dinamico.getValueAt(temp, 2).equals(""))
            Dinamico.setValueAt(valor, temp, 2);
            else {
                
                if(tipo.equalsIgnoreCase("num") && (Dinamico.getValueAt(temp, 1).equals("Integer") || Dinamico.getValueAt(temp, 1).equals("Real") ))
                    Dinamico.setValueAt(valor, temp, 2);
                else
                if(Dinamico.getValueAt(temp, 1).equals(tipo)){
                Dinamico.setValueAt(valor, temp, 2);
                }
                else{
                    Ventana.error("Error en la linea "+linea+", los datos no son compatibles en la asignacion de '"+lugar+"'");
                    }
            }
                }
           
            else{
            if(Dinamico.getValueAt(temp, 2).equals(""))
            Dinamico.setValueAt(valor, temp, 2);
            else {
                
                if(tipo.equalsIgnoreCase("num") && (Dinamico.getValueAt(temp, 1).equals("Integer") || Dinamico.getValueAt(temp, 1).equals("Real") ))
                    Dinamico.setValueAt(valor, temp, 2);
                else
                if(Dinamico.getValueAt(temp, 1).equals(tipo)){
                Dinamico.setValueAt(valor, temp, 2);
                }
                else{
                    Ventana.error("Error en la linea "+linea+", los datos no son compatibles en la asignacion de '"+lugar+"'");
                    }
            }
                } 
            
        }
        
        if (param.equals("dir"))
            Dinamico.setValueAt(valor, temp, 3);
                
        
       return true;
        
    }
    
    
    
}
