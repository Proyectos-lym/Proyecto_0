package Lexer;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		Parserito parser = new Parserito();
		parser.cargarDato();
		ArrayList<String> lista = parser.crearLista();
		System.out.println(parser.analizadorSintactico(lista));
		System.out.println("hola");
	}

}
