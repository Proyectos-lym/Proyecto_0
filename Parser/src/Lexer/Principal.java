package Lexer;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        String ruta = "D:/Lym/Proyecto_0/Parser/src/Lexer/lexer.flex"; //cambiar ruta de archivo
        leer(ruta);
    }
    public static void leer (String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}