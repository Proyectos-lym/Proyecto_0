package Lexer;

import java.io.File;

public class Principal {
    public static void main(String[] args) {
        String ruta = "src/Lexer/lexer.flex";
        leer(ruta);
    }
    public static void leer (String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}