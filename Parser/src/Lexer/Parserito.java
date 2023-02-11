package Lexer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parserito {

	public ArrayList<String> crearLista() throws IOException{
	//crea una lista con todos los tokens del archivo
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
		//analiza el inicio, las variables y el orden en que esta la definicion de variables, procedimientos y el bloque de instrucciones
		String respuesta = "";
		int contadorCorchete = 0;
		int contadorPipe = 0;
		//System.out.println(tokensLista);

		ArrayList<String> vars = new ArrayList<String>(); //abajo hay una asignacion de variables y es una List
		
		int posVars = 0;
		boolean containsVar = tokensLista.contains("var");
		for(int v = 0; v < tokensLista.size(); v++){
			if(containsVar){
				if(tokensLista.get(v).equals("var") == true){
					posVars = tokensLista.indexOf("var");
				}
				if(v > posVars){
					
					if(tokensLista.get(v).contains("identificador") && (tokensLista.get(v+1).equals("comma") || tokensLista.get(v+1).equals("semicolon"))){
						vars.add(tokensLista.get(v));

					}
					else{
						respuesta = "NO";
					}
				}

			}
		}

		for(int i = 0; i < tokensLista.size(); i++){ //for(String i: tokensLista)
			
			if (tokensLista.get(i) == "corchetei"){
				contadorCorchete += 1;
			
			}
			else if (tokensLista.get(i) == "corcheted"){
				contadorCorchete -= 1;
			}

			if (i == 0 && tokensLista.get(i).equals("inicio")== false){ 
				 respuesta = "NO";
				 return respuesta;
			}
			if (tokensLista.contains("semicolon")== false) {
				respuesta = "NO";
				return respuesta;
			}
			if ((tokensLista.contains("corchetei") == false) || (tokensLista.contains("corcheted")== false)){
				respuesta = "NO";
				return respuesta;
			}
			
			if ((tokensLista.contains("var")) || i == 1 ) {
				// si contiene variables y estan en primero
				List<String> variables;
				int posVar = tokensLista.indexOf("var");
				if (tokensLista.get(i).equals("var") == true){
					// var está en la posición 1
						ArrayList<String> nombreVars;
						if (tokensLista.contains("funcion")== false){
							//no tiene declaracion de procedimientos
							int posFinVar = tokensLista.indexOf("corchetei");
							variables = tokensLista.subList(posVar + 1, posFinVar);
							if (variables.get(variables.size() - 1).equals("semicolon") == false){ // despues de definir variable no cierra con ;
								respuesta = "NO";
								return respuesta;
								}
							nombreVars = nombresVars(variables);
						} else if (tokensLista.contains("funcion")) {
							//tiene declaracion de procedimientos despues de declarar variables y antes del bloque de instrucciones
							int posCorcheted = tokensLista.indexOf("corcheted");
							int posCorchetei = tokensLista.indexOf("corchetei");
							int posFuncion = tokensLista.indexOf("funcion");
							if ((tokensLista.get(posCorcheted + 1)).equals("corchetei") == true){
								int posFinVar = tokensLista.indexOf("funcion");
								variables = tokensLista.subList(posVar + 1, posFinVar);
								if (variables.get(variables.size() - 1).equals("semicolon") == false){ 
									// despues de definir variable no cierra con ;
									respuesta = "NO";
									return respuesta;
									}
								nombreVars = nombresVars(variables);
							}else if (posCorchetei < posFuncion ){
								//hay procedimientos despues de un bloque de instrucciones
								respuesta = "NO";
								return respuesta;
							} else if (posCorchetei < posVar ){
								//hay decla despues de un bloque de instrucciones
								respuesta = "NO";
								return respuesta;
						}	
				} 						
			}else if ((i == 1 && tokensLista.get(i).equals("var") == false) && tokensLista.contains("var")){ // var está pero no en la posición 1
					respuesta = "NO";
					return respuesta;
			}
		}
			

			if (tokensLista.contains("funcion") == true){
				 // declaracion de procedimientos
				if (tokensLista.contains("var") == true){
					int posCorcheted = tokensLista.indexOf("corcheted");
					int posFuncion = tokensLista.indexOf("funcion");
					int posCorchetei = tokensLista.indexOf("corchetei");
					int posVar = tokensLista.indexOf("var");
					if ((tokensLista.get(posCorcheted + 1)).equals("corchetei") == true){
						respuesta = analizarProcs(tokensLista,posFuncion + 1);
					}else if (posCorchetei < posVar ){
						//hay declaraciones despues de un bloque de instrucciones
						respuesta = "NO";
						return respuesta;
					}else if (posCorchetei < posFuncion ){
						//hay procedimientos despues de un bloque de instrucciones
						respuesta = "NO";
						return respuesta;
					} else if ( posFuncion < posVar){
						// hay declaracion de variables despues de procedimientos
						respuesta = "NO";
						return respuesta;
					}
				} else if (tokensLista.contains("var") == false){
					int posCorcheted = tokensLista.indexOf("corcheted");
					int posFuncion = tokensLista.indexOf("funcion");
					int posCorchetei = tokensLista.indexOf("corchetei");
					 if (posCorchetei < posFuncion ){
						//hay procedimientos despues de un bloque de instrucciones
						respuesta = "NO";
						return respuesta;
					 } else if ((tokensLista.get(posCorcheted + 1)).equals("corchetei") == true){
						respuesta = analizarProcs(tokensLista,posFuncion + 1);
					 }
				}
		}
		int posCorcheted = tokensLista.indexOf("corcheted");
		if ((tokensLista.contains("var") == false) && (tokensLista.contains("funcion") == false) && ((tokensLista.get(posCorcheted + 1)).equals("corchetei") == true) ){
			respuesta = analizarBlock(tokensLista, vars);

			return respuesta;
		}

		if ((contadorCorchete != 0) || (contadorPipe != 0)){
			respuesta = "NO";
			return respuesta;
		}
	}
		return respuesta;
	
	}
	public ArrayList<String> nombresVars(List<String> lista){
		ArrayList<String> variables = new ArrayList<String>();
		for (int i = 0; i < lista.size();i++) {
			if (lista.get(i).equals("comma") != true) {
				variables.add(lista.get(i));
			}
		}
		return variables;
	}
   
    public void cargarDato() throws IOException{
        GeneradorTokens generador = new GeneradorTokens();
        generador.archivo(); // Cambiar ruta archivo
        
    }

	public String analizarProcs(ArrayList<String> tokensLista, int pos){
		//guarda en una lista, lista con todos los tokens por cada procedimiento definido
		String respuesta = "";
		int posProcs = tokensLista.indexOf("funcion");
		int posBlock;
		if ((tokensLista.get(pos) == "corcheted") && (tokensLista.get(pos+1) == "corchetei") ){
			posBlock = tokensLista.indexOf("corcheted");
			List<String> procs = tokensLista.subList(posProcs, posBlock);
			ArrayList<String> nameProcs = new ArrayList<String>();
			ArrayList<ArrayList<String>> procsLista = new ArrayList<ArrayList<String>>(); //lista con todos los procedimientos
			ArrayList<String> proc = new ArrayList<String>(); // lista con las tokens del procedimiento
			for (int i=0; i < procs.size(); i++){ //for (String i: procs)
				if ((procs.get(i).contains("identificador")) && ((procs.get(i-1).equals("pipeline")== false) || (procs.get(i-1).equals("comma")== false))){
					nameProcs.add(procs.get(i)); // lista con todos los nombres de los procedimientos
				}
				while (! nameProcs.contains(procs.get(i))){
					proc.add(procs.get(i));
				}
				procsLista.add(proc);	
			}

			for(int j=0; j < procsLista.size(); j++){
				System.out.println(procsLista.get(j));
				respuesta = analizarProc(procsLista.get(j));
			} 
		}
		return respuesta;
	}

	public  String analizarProc(ArrayList<String> procsLista){
		// analiza sintacticamente cada procedimiento
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
		String respuesta = "SI";
		
		
		
		return respuesta;
	}
	
	public String analizarBlock(ArrayList<String> procsLista, ArrayList<String> variables){
		String respuesta = "";
		int posicionCorcheteD = 0;
		int posicionFin = 0;


		for(int i = 0; i < procsLista.size(); i++){
			if (((procsLista.get(i).equals("corcheted") == true) && (procsLista.get(i+1).equals("corchetei")== true)) ||
			((procsLista.get(i).equals("inicio") == true) && (procsLista.get(i+1).equals("corchetei") == true)) ||
			((procsLista.get(i).equals("semicolon") == true) && (procsLista.get(i+1).equals("corchetei") == true))){
				// si un corchete derecho está seguido de uno izquierdo significa que el bloque de instrucciones inicia
				// o si esta ROBOT_R y despues corchete izquierdo
				// o si estan las variables declaradas finalizando con ; y despues corchete izquierdo
				posicionCorcheteD = i+1;
			}
			else {
				respuesta = "NO"; //si esto no se cumple la sintaxis no esta bien
			}
			if ((procsLista.get(i).equals("corchetei") == true) && (procsLista.get(i+1).equals("FIN") == true)){
				// si un corchete izquierdo está seguido de FIN significa que el bloque de instrucciones termina
				posicionFin = i;
			}
			else {
				respuesta = "NO"; // si no se cierr la sintaxis está mal
			}

		List<String> sublista = procsLista.subList(posicionCorcheteD, posicionFin); // se crea la sublista del bloque de instrucciones

		

		for(int j = 0; j < sublista.size(); j++){
			if(sublista.get(j).equals("instruccion1") == true){
				
				
				if(sublista.get(j+1).equals("colon") == true){
					if((sublista.get(j+2).equals("numero") == true) || (sublista.get(j+2).contains("identificador") == true && variables.contains(sublista.get(j+2)))){
						// se verifica si se le pasa un numero o una variable a la instruccion
						if((sublista.get(j+3).contains("identificador")== true) || (sublista.get(j+3).equals("instruccion1")==true) || (sublista.get(j+3).equals("instruccion2")) || (sublista.get(j+3).equals("corcheted"))){
							// despues del valor que se le pasa puede haber un proceso (identificador), una instruccion con 1 parametro, una instruccion con 2 parametros o un corchete derecho
							respuesta = "SI";
						}
					}


				}
			}
			else if(sublista.get(j).equals("instruccion2") == true){
				
				if(sublista.get(j+1).equals("colon") == true){
					if((sublista.get(j+2).equals("numero") == true) || (sublista.get(j+2).contains("identificador") == true && variables.contains(sublista.get(j+2)))){
						// se verifica si se le pasa un numero o una variable a la instruccion
						
						if((sublista.get(j+3).equals("numero") == true) || (sublista.get(j+3).contains("identificador") == true && variables.contains(sublista.get(j+3)))){
						
							if((sublista.get(j+4).contains("identificador")== true) || (sublista.get(j+4).equals("instruccion1")==true) || (sublista.get(j+4).equals("instruccion2")) || (sublista.get(j+3).equals("corcheted"))){
								// despues del valor que se le pasa puede haber un proceso (identificador), una instruccion con 1 parametro, una instruccion con 2 parametros o un corchete derecho
								respuesta = "SI";
							}
						}
					}


				}
				
			}
			else{
				respuesta = "NO";
			}

			
			

		}

		}


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

