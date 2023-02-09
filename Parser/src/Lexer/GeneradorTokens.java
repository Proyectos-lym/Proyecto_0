package Lexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;



public class GeneradorTokens { 
    
    public static void main(String[] args) throws IOException { //modificar main para dentro del parser
        archivo("D:/Lym/Proyecto_0/Parser/data/archivo.txt"); //cambiar ruta de archivo
    }
    public static void archivo(String ruta) throws IOException {
        
        BufferedReader bf = new BufferedReader(new FileReader(ruta));
        File archivo = new File("unificado.txt");
        String line;

        String codigo = "";
        while((line = bf.readLine()) != null){
            codigo +=  " " + line;
            
        }
        
        bf.close();

        PrintWriter escribir;

        try {
            escribir = new PrintWriter(archivo);
            escribir.print(codigo.toLowerCase());
            escribir.close();
        } catch (Exception e) {
            System.out.println("archivo no encontrado");
            e.printStackTrace();
            
        }
        try {
            Reader lector = new BufferedReader(new FileReader("unificado.txt")); 
            Lexer lexer = new Lexer(lector);
            String resultado = "";

            boolean iterador = true;
            File tokenfile = new File("tokens.txt");
            PrintWriter escribirToken;
            
            while (iterador){
                Tokens tokens = lexer.yylex();
                if (tokens == null){
                    resultado += "FIN";
                    try {
                        escribirToken = new PrintWriter(tokenfile);
                        escribirToken.print(resultado);
                        escribirToken.close();
                    } catch (Exception e) {
                        System.out.println("archivo no encontrado");
                        e.printStackTrace();
                        
                    }
                    return;
                }
                switch (tokens) {
                    case error:
                        resultado += "not found\n";
                        break;
                    case identificador: case instruccion1: case instruccion2: case condicion1: case condicion2:
                        resultado += lexer.lexeme + " " + tokens + "\n";
                        break;
                    default:
                        resultado += tokens  + "\n";
                        break;

                }
            }

        } catch (Exception e) {
            System.out.println("archivo no encontrado");
            e.printStackTrace(); 
        }
        
        
        
        
    }
    


    
}
