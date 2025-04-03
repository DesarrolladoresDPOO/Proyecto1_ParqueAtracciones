package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import atracciones.AtraccionCultural;
import atracciones.AtraccionMecanica;
import atracciones.Espectaculo;
import atracciones.Temporada;

public class Principal {
	private BufferedReader br;
	private AtraccionCultural atraccionCultural;
	private AtraccionMecanica atraccionMecanica;
	private Espectaculo espectaculo;
	private Temporada temporada;

	public Principal() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
		int op;

		// Inciamos el menu principal de la aplicacion
		do {
			System.out.println("Digite:\n"
					+ "0. Salir\n"
					+ "1. Consultar requisito atraccion\n"
					+ "2. Consultar usuario\n"
					+ "3. Consultar tiquetes");
			op = Integer.parseInt(leerConsola());

			// Consultas relacionadas con las atracciones del parque
			if(op == 1) {
				System.out.println("Digite:\n"
						+ "0. Salir\n"
						+ "1. Consultar requisito atraccion\n"
						+ "2. Consultar disponibilidad atraccion o espectaculo\n");
				int consulta = Integer.parseInt(leerConsola());
				
				// Consulta de los requisitos de una atraccion
				if(consulta==1) {
					System.out.println("Menu para consultar si un usuario es apto para ingresar a una atraccion en especifico");
					System.out.println("Digite:\n"
							+ "0. Salir\n"
							+ "1. Atraccion Mecanica\n"
							+ "2. Atraccion Cultural\n");
					int tipoAtraccion = Integer.parseInt(leerConsola());
					if (tipoAtraccion==0) {
						op=0;
					}	
					
					// Criterios de una atraccion Mecanica
					else if(tipoAtraccion==1) {
						System.out.println("Ingrese el peso del usuario: ");
						int pesoUsr = Integer.parseInt(leerConsola());
						System.out.println("Ingrese la altura del usuario: ");
						int altUsr = Integer.parseInt(leerConsola());
						System.out.println("Ingrese las restricciones de salud del usuario: ");
						String restrUsr = leerConsola();
						atraccionMecanica.aptaParaCliente(altUsr, pesoUsr, restrUsr);
						if (atraccionMecanica.isRespuesta()==false) {
							System.out.println("El usuario dado no cumple con los requisitos para entrar a la atraccion");
						}
						else if (atraccionMecanica.isRespuesta()==true) {
							System.out.println("El usuario dado puede ingresar a la atraccion");
						}
					}
					
					// Criterios de una atraccion cultural
					else if (tipoAtraccion==2) {
						System.out.println("Ingrese la edad del usuario a consultar: ");
						int edad = Integer.parseInt(leerConsola());
						atraccionCultural.aptaParaCliente(edad);
						if (atraccionCultural.isRespuesta()==false) {
							System.out.println("El usuario dado no cumple con la edad minima para ingresar a la atraccion");
						}
						else if (atraccionCultural.isRespuesta()==true) {
							System.out.println("El usuario dado puede ingresar a la atraccion");
						}
					}
				}
				
				// Consulta del estado de una atraccion o espectaculo
				else if (consulta==2) {
					System.out.println("Menu para consultar el estado de una atraccion o espectaculo segun la temporada y clima");
					System.out.println("Digite:\n"
							+ "0. Salir\n"
							+ "1. Atraccion Mecanica\n"
							+ "2. Atraccion cultural\n"
							+ "3. Espectaculo");
					int u = Integer.parseInt(leerConsola());
					if (u==0) {
						op=0;
					
					// Estado Atraccion Mecanica
					}else if (u==1) {
						boolean condicion= atraccionMecanica.estaDisponible(temporada);
						if (condicion == true) {
							System.out.println("La atraccion mecanica se encuentra disponible");
						}
						else if (condicion == false) {
							System.out.println("La atraccion mecanica no se encuentra disponible");
						}
						
					// Estado Atraccion Cultural
					}else if (u==2) {
						boolean condicion= atraccionCultural.estaDisponible(temporada);
						if (condicion == true) {
							System.out.println("La atraccion cultural se encuentra disponible");
						}
						else if (condicion == false) {
							System.out.println("La atraccion cultural no se encuentra disponible");
						}
						
					// Estado Espectaculo
					}else if (u==3) {
						boolean condicion= espectaculo.estaDisponible();
						if (condicion == true) {
							System.out.println("El espectaculo se va a realizar");
						}
						else if (condicion == false) {
							System.out.println("El espectaculo no se va a realizar");
						}
					}
				}
			}
			
			// Consultas relacionadas con los usuarios del parque
			else if (op==2) {

			}
			
			// Consultas relacionadas con el sistema de tiquetes
			else if (op==3) {

			}

		}while(op != 0);
		try {
			this.br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String leerConsola() {
		String dato = null;
		try {
			dato = this.br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dato;
	}

	public static void main(String[] args) {
		new Principal();
	}
}
