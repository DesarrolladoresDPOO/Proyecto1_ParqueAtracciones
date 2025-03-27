package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
	private static BufferedReader br;
	
	public Principal() {
		
	}
	
	public static String leerConsola() {
		String dato = null;
		try {
			dato = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dato;
	}
	
	public static void main(String[] args) {
		new Principal();
	}
}
