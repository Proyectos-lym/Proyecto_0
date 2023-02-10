package Lexer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parserito {
	public ArrayList<String> crearLista() throws IOException{
	ArrayList<String> tokensList = new ArrayList<String>();
	try {
		BufferedReader tokens = new BufferedReader(new FileReader("../Proyecto_0/Parser/tokens.txt"));
		
		String line;
		while ((line = tokens.readLine()) != null){
			tokensList.add(line);
		}
		tokens.close();
	} catch (Exception e) {
		System.out.println("archivo no encontrado");
        e.printStackTrace();
	}	
	return tokensList;
	}

	public String analizadorSintactico(ArrayList<String> tokensLista){
		String respuesta = "";
		int contadorCorchete = 0;
		int contadorPipe = 0;
		
		for(int i = 0; i < tokensLista.size(); i++){
			if (tokensLista.get(i) == "corchetei"){
				contadorCorchete += 1;
			
			}
			else if (tokensLista.get(i) == "corcheted"){
				contadorCorchete -= 1;
			}

			
			if (tokensLista.get(i) == "corcheted" && tokensLista.get(i+1) == "corchetei"){
				int posBlock = tokensLista.indexOf(i+1); //crear un metodo para sacar la posicion de fin de procs e inicio de block instruction
					
			}

			if (i == 0 && tokensLista.get(i) != "inicio"){ 
				 respuesta = "NO";
				 return respuesta;
			}
			
			if (i == 1 && tokensLista.get(i) == "var") // declaracion de variables  
			// var está en la posición 1
			{
				ArrayList<String> variables = new ArrayList<String>();
				while(tokensLista.get(i) != "funcion"){
					if (tokensLista.get(i) != "comma"){
						variables.add(tokensLista.get(i)); //lista con todas las variables definidas
					}
				}
				if (variables.get(variables.size() - 1) != "semicolon"){ // despues de definir variable no cierra con ;
					respuesta = "NO";
					return respuesta;
				}
			} else if ((i == 1 && tokensLista.get(i) != "var") && tokensLista.contains("var")){ // var está pero no en la posición 1
				respuesta = "NO";
				return respuesta;
			}
			 if ((tokensLista.contains("var") == false) && (i == 1 && tokensLista.get(i) == "funcion")){ // declaracion de procedimientos
				// La posición 1 es procs
				List<String> procs = tokensLista.subList(i, posBlock);
				

				
			} else if ((i == 2 && tokensLista.get(i) != "funcion") && tokensLista.contains("funcion")){ // funcion está pero no en la posición 1
				respuesta = "NO";
				return respuesta; 
			

			}else if (i == 1 && tokensLista.get(i) == "corchetei"){

			} //es un instruction block
			

			// objeto: los nombres de los procedimientos definidos. La posicion en que termina la definicion. cantidad de parametros. Correcto.


		}	

		return respuesta;
	}
   
    private void cargarDato() throws IOException{
        GeneradorTokens generador = new GeneradorTokens();
        generador.archivo(); // Cambiar ruta archivo
        
    }

	public String analizarProcs(){
		// identificador
		// corchetei
		// pipeline
		// parametros (opcionales) identificador
		// pipeline
		// reservadaCond || reservadaBlock
		// colon
		// condicion1 || condicion2 
		// cond1: cardinalidades / condicion2: n (identificador) ,  (comma) (cardinalidades || direccion)
		// reservadaBlock
		// corchetei
		// instruccion1 || instruccion2 || nop
		// instruccion1: identificador / instruccion2: identificador||numero, identificador||numero
		//corcheted

		

	}
	
    public static void main(String[] args)throws IOException{ //modificar main para dentro del parser
        Parserito parser = new Parserito();
        parser.cargarDato();
        
    }
}

