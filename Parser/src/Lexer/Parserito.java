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
		BufferedReader tokens = new BufferedReader(new FileReader("../Proyecto_0/tokens.txt"));
		
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
		
		for(int i = 0; i < tokensLista.size(); i++){ //for(String i: tokensLista)
			if (tokensLista.get(i) == "corchetei"){
				contadorCorchete += 1;
			
			}
			else if (tokensLista.get(i) == "corcheted"){
				contadorCorchete -= 1;
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
				respuesta = analizarProcs(tokensLista,i);
				return respuesta;
				

				
			} else if ((i == 2 && tokensLista.get(i) != "funcion") && tokensLista.contains("funcion")){ // funcion está pero no en la posición 1
				respuesta = "NO";
				return respuesta; 
			

			}else if (i == 1 && tokensLista.get(i) == "corchetei"){

			} //es un instruction block
			

			// objeto: los nombres de los procedimientos definidos. La posicion en que termina la definicion. cantidad de parametros. Correcto.


		}	

		return respuesta;
	}
   
    public void cargarDato() throws IOException{
        GeneradorTokens generador = new GeneradorTokens();
        generador.archivo(); // Cambiar ruta archivo
        
    }

	public String analizarProcs(ArrayList<String> tokensLista, int pos){
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
		String respuesta = "";
		int posProcs = tokensLista.indexOf("funcion");
		int posBlock;
		if ((tokensLista.get(pos) == "corcheted") && (tokensLista.get(pos+1) == "corchetei")){
			posBlock = tokensLista.indexOf("corcheted");
			List<String> procs = tokensLista.subList(posProcs, posBlock);
			ArrayList<String> nameProcs = new ArrayList<String>();
			ArrayList<ArrayList<String>> procsLista = new ArrayList<ArrayList<String>>(); //lista con todos los procedimientos
			ArrayList<String> proc = new ArrayList<String>(); // lista con las tokens del procedimiento
			for (int i=0; i < procs.size(); i++){ //for (String i: procs)
				if ((procs.get(i).contains("identificador")) && ((procs.get(i-1)!= "pipeline") || (procs.get(i-1)!= "comma"))){
					nameProcs.add(procs.get(i)); // lista con todos los nombres de los procedimientos
				}
				while (! nameProcs.contains(procs.get(i))){
					proc.add(procs.get(i));
				}
				procsLista.add(proc);	
			}

			for(int j=0; j < procsLista.size(); j++){
				respuesta = analizarProc(procsLista.get(j));
			} 


		}
		return respuesta;
	}

	public  String analizarProc(ArrayList<String> procsLista){
		String respuesta = "";

		return respuesta;
	}
	
    /* public static void main(String[] args)throws IOException{ //modificar main para dentro del parser
        Parserito parser = new Parserito();
        parser.cargarDato();
		ArrayList<String> lista = crearLista();
		analizadorSintactico(lista);
        
    }
     */
}

