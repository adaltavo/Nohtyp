/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NohtypPackage;

/**
 *
 * @author Principal
 */
public class Nodo {
    
    Object valor;
    String tipo;
    String valorT="";
    Nodo izquierdo=null;
    Nodo derecho=null;
    String cadtemp="";
    
    Nodo(Object val, String tip, Object i, Object d){
        valor=val;
        tipo=tip;
        izquierdo= (Nodo)i;
        derecho=(Nodo)d;
    }
    
    public void modT(String a){
    this.valorT=a;
    }
      public void modV(String a){
    valor=a;
    }
    
    //////////////////////////////////////////////CAMBIAR TODOS LOS PRUEBA.* POR SU EQUIVALENTE EN CUP
    
    public static void postorden(Nodo a){
    if(a.izquierdo!=null)
        postorden(a.izquierdo);
    if(a.derecho!=null)
        postorden(a.derecho);
    if(a.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")){
        a.modT(a.valor+""); 
        a.modCadT(a.valorT);//////////////////////TablaDS
    }
    if(a.valor.toString().matches("\\-*[a-zA-Z_][a-zA-Z0-9_]*") && !(a.valor.toString().equalsIgnoreCase("and") || a.valor.toString().equalsIgnoreCase("or"))){
        a.modT("T"+TablaDS.x+"= "+a.valor); /*incrementar el valor de t aquí*/
        a.modCadT(a.valorT);//////////////////////TablaDS
        TablaDS.incx();

    }
     if(a.valor.toString().matches("\\+|\\*|\\/|\\-")){
         String t1[]=a.izquierdo.valorT.split("=");
         String t2[]=a.derecho.valorT.split("=");
         a.modT("T"+TablaDS.x+"= "+t1[0]+" "+ a.valor+ " "+t2[0] );
         
      if(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+") && a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+") )
                 a.modCadT(a.valorT);
                  else{
          
         if(a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+"))
                 a.modCadT(a.derecho.cadtemp+a.valorT);
         if(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+"))
                 a.modCadT(a.izquierdo.cadtemp+a.valorT);}

          if(!(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")) && !(a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")))
         a.modCadT(a.izquierdo.cadtemp+a.derecho.cadtemp+a.valorT);
      
          if(!a.valor.toString().equals("/"))
              if(a.izquierdo.tipo.equals("Integer") && a.derecho.tipo.equals("Integer"))
                  a.modTipo("Integer");
              else a.modTipo("Real"); else a.modTipo("Real");
         /*incrementar el valor de t aquí*/TablaDS.incx();
     }
     if(a.valor.toString().matches("<|>|>=|<=|!=|==")){
         String t1[]=a.izquierdo.valorT.split("=");
         String t2[]=a.derecho.valorT.split("=");
         a.modT("T"+TablaDS.x+"= "+t1[0]+" "+ a.valor+ " "+t2[0] );
         
         if(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+") && a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+") )
                 a.modCadT(a.valorT);
           
                  else{
          
         if(a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+"))
                 a.modCadT(a.derecho.cadtemp+a.valorT);
         if(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+"))
                 a.modCadT(a.izquierdo.cadtemp+a.valorT);}

          if(!(a.derecho.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")) && !(a.izquierdo.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")))
         a.modCadT(a.izquierdo.cadtemp+a.derecho.cadtemp+a.valorT);
         
         /*incrementar el valor de t aquí*/ TablaDS.incx();
     
     
     
     }
     
     if(a.valor.toString().matches("And|and|Or|or")){
         String t1[]=a.izquierdo.valorT.split("=");
         String t2[]=a.derecho.valorT.split("=");
         a.modT("T"+TablaDS.x+"= "+t1[0]+" "+ a.valor+ " "+t2[0] );
         a.modCadT(a.izquierdo.cadtemp+a.derecho.cadtemp+a.valorT);
         /*incrementar el valor de t aquí*/ TablaDS.incx();}
     
    //poner la cadena temporal aquí
     
     
    }
    
    public void modCadT(String a){cadtemp=cadtemp+a+"\n";}
    public void modTipo(String a){tipo=a;}
    
    
    public static void postordenasm(Nodo a){
    if(a.izquierdo!=null)
        postordenasm(a.izquierdo);
    if(a.derecho!=null)
        postordenasm(a.derecho);
    if(a.valor.toString().matches("\\-*[0-9]+|\\-*[0-9]+\\.[0-9]+")){
    //    a.modT(a.valor+""); 
        if(a.valor.toString().matches("\\-*[0-9]+"))
            //////////////////////////////////////////////////////////////////////////////////////////!!!!!!!!!!!!ADVERTENCIA!!!!!/////////////////////////////
             a.modCadT("push "+a.valor+"\nfild dword ptr [esp]"+"\n \n");//////////////////////CUIDADO CON EL POP AX, RECUERDALO, puede causarte problemas
        else
             a.modCadT("fld FP8("+a.valor+")\n");
    }
    if(a.valor.toString().matches("\\-*[a-zA-Z_][a-zA-Z0-9_]*") && !(a.valor.toString().equalsIgnoreCase("and") || a.valor.toString().equalsIgnoreCase("or"))){
        if(!a.valor.toString().equals("True") && !a.valor.toString().equals("False"))
        a.modT("lea eax, "+a.valor+"\n fld dword ptr [eax]\n"); /*incrementar el valor de t aquí*/
        a.modCadT(a.valorT);//////////////////////TablaDS
        TablaDS.incx();

    }
     if(a.valor.toString().matches("\\+|\\*|\\/|\\-")){
       //  String t1[]=a.izquierdo.valorT.split("=");
      //   String t2[]=a.derecho.valorT.split("=");
         if(a.valor.toString().matches("\\+"))
             a.modT("fadd\n");
         if(a.valor.toString().matches("\\*"))
             a.modT("fmul\n");
         if(a.valor.toString().matches("\\/"))
             a.modT("fdiv\n");
         if(a.valor.toString().matches("\\-"))
             a.modT("fsub\n");
         
         
         a.modCadT(a.izquierdo.cadtemp+a.derecho.cadtemp+a.valorT);
      
        // System.out.println(a.izquierdo.cadtemp);
         /*incrementar el valor de t aquí*/TablaDS.incx();
     }
     if(a.valor.toString().matches("<|>|>=|<=|!=|==")){

         String temp1=a.izquierdo.cadtemp;
         String temp2=a.derecho.cadtemp;
         a.modCadT(temp1+temp2);
         
         
         
     }
     
     if(a.valor.toString().matches("And|and|Or|or")){
         String t1[]=a.izquierdo.valorT.split("=");
         String t2[]=a.derecho.valorT.split("=");
         a.modT("T"+TablaDS.x+"= "+t1[0]+" "+ a.valor+ " "+t2[0] );
         a.modCadT(a.izquierdo.cadtemp+a.derecho.cadtemp+a.valorT);
         /*incrementar el valor de t aquí*/ TablaDS.incx();}
     
    //poner la cadena temporal aquí
     
     
    }
    
    public static String sacarCondicionFPU(){
        String temp="";
       
            temp="FCOMPP \nfstsw ax\nfwait\nsahf\n";
            return temp;
       
    }
    
     
    }
    
    
