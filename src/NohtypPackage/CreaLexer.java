/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NohtypPackage;

import java.io.File;

/**
 *
 * @author Alfredo
 */
public class CreaLexer {

    
    public static void main(String[] args) {
        jflex.Main.generate(new File("src\\NohtypPackage\\archivo.flex"));
    }
    
}
