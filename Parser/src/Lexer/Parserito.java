package Lexer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parserito {
   
    private void cargarDato() throws IOException{
    	String ruta = input("Ingrese la ruta del archivo: ");
        GeneradorTokens generador = new GeneradorTokens();
        generador.archivo(ruta); // Cambiar ruta archivo
        
    }
    public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	
	}
    public static void main(String[] args)throws IOException{ //modificar main para dentro del parser
        Parserito parser = new Parserito();
        parser.cargarDato();
        
    }
}

