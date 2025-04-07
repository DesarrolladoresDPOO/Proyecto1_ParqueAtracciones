package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import atracciones.Atraccion;
import atracciones.AtraccionCultural;
import atracciones.AtraccionMecanica;
import atracciones.Espectaculo;
import atracciones.Temporada;
import persona.Administrador;
import persona.Cajero;
import persona.Cocinero;
import persona.Empleado;
import persona.LugarServicio;
import persona.LugarTrabajo;
import persona.OperadorMecanico;
import persona.ServicioGeneral;
import persona.Turno;
import persona.Usuario;
import tiquetes.Cliente;
import tiquetes.Tiquete;
import tiquetes.TiqueteOro;
import tiquetes.TiqueteBasico;
import tiquetes.TiqueteFamiliar;
import tiquetes.TiqueteDiamante;
import java.util.ArrayList;
import java.util.List;

public class Principal {
	private BufferedReader br;
	private AtraccionCultural atraccionCultural;
	private AtraccionMecanica atraccionMecanica;
	private Espectaculo espectaculo;
	private Temporada temporada;
	private Administrador administrador;
	private Cajero cajero;
	private Cocinero cocinero;
	private Empleado empleado;
	private LugarServicio lugarServicio;
	private LugarTrabajo lugarTrabajo;
	private OperadorMecanico operadorMecanico;
	private ServicioGeneral servicioGeneral;
	private Turno turno;
	private Usuario usuario;
	
	
	private List<Empleado> empleados;
	private List<Cliente> clientes;

	public Principal() {
		
		// Creamos una instancia de todas las clases para probarlas
		atraccionCultural= new AtraccionCultural("Carrusel", 20, 2, true, "familiar", 5);
		atraccionMecanica= new AtraccionMecanica("MontanaRusa", 10, 4, true, "oro", 150, 190, 40, 90, "vertigo", "medio");
		LocalDateTime inicio1 = LocalDateTime.of(2025, 1, 10, 12, 00); // 10 de enero de 2025, 12:00
        LocalDateTime fin1 = LocalDateTime.of(2025, 3, 1, 12, 00); // 1 de marzo de 2025, 12:00
        temporada = new Temporada(inicio1, fin1);
        espectaculo = new Espectaculo("DesfileInvierno", temporada, "18:00 - 21:00", false);
        
        administrador = new Administrador("Juan123", "123", "Juan Carlos", 100);
        cajero= new Cajero("Pablo15", "123", "Pablo Mancera", 200, "taquilla", true);
        cocinero= new Cocinero("Paola25", "123", "Paola Suarez", 300, "cocina", true);
        lugarServicio= new LugarServicio("cocina");
        operadorMecanico= new OperadorMecanico("JuanPablo1", "123", "Juan Pablo Correa", 400, "MontanaRusa", true, atraccionMecanica);
        servicioGeneral= new ServicioGeneral("Ernesto1", "123", "Ernesto Lopez", 500, "baños");
        turno= new Turno("Apertura", LocalTime.of(8, 0), LocalTime.of(14, 0));
        
        empleados = new ArrayList<Empleado>();
        empleados.add(administrador);
        empleados.add(cajero);
        empleados.add(cocinero);
        empleados.add(operadorMecanico);
        empleados.add(servicioGeneral);
        
		// Activamos el Buffer Reader para leer informacion de la consola
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
			else if (op == 2) {
				System.out.println("Ingrese el tipo de usuario:");
				System.out.println("1. Empleado");
				System.out.println("2. Cliente");
				int tipoUsuario = Integer.parseInt(leerConsola());

				if (tipoUsuario == 1) {
					System.out.println("Ingrese el nombre del empleado:");
					String nombre = leerConsola();
					boolean encontrado = false;
					for (Empleado e : empleados) {
						if (e.getNombre().equalsIgnoreCase(nombre)) {
							encontrado = true;
							System.out.println("Ingrese la fecha (YYYY-MM-DD):");
							String fechaTexto = leerConsola();
							LocalDate fecha = LocalDate.parse(fechaTexto);
							Turno turno = e.consultarTurno(fecha);
							if (turno != null) {
								System.out.println("Turno para " + fecha + ": " + turno);
								System.out.println("Lugar de trabajo: " + e.getLugarTrabajo());
							} else {
								System.out.println("No tiene turno asignado para esa fecha.");
							}
							break;
						}
					}
					if (!encontrado) {
						System.out.println("Empleado no encontrado.");
					}
				}
				else if (tipoUsuario == 2) {
					System.out.println("Ingrese el nombre del cliente:");
					String nombreCliente = leerConsola();
					boolean encontrado = false;
					for (Cliente c : clientes) {
						if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
							encontrado = true;
							System.out.println("Tiquetes del cliente:");
							for (Tiquete t : c.getTiquetes()) {
								System.out.println("- Tipo: " + t.getTipo() + ", Usado: " + (t.isUsado() ? "Sí" : "No"));
							}
							break;
						}
					}
					if (!encontrado) {
						System.out.println("Cliente no encontrado.");
					}
				}
			}
			
			// Consultas relacionadas con el sistema de tiquetes
			else if (op == 3) {
				System.out.println("Menú de consulta de tiquetes");
				System.out.println("1. Ver todos los clientes registrados");
				System.out.println("2. Ver tiquetes de un cliente específico");
				int subop = Integer.parseInt(leerConsola());

				if (subop == 1) {
					if (clientes.isEmpty()) {
						System.out.println("No hay clientes registrados.");
					} else {
						System.out.println("Clientes registrados:");
						for (Cliente c : clientes) {
							System.out.println("- " + c.getNombre());
						}
					}
				} else if (subop == 2) {
					System.out.println("Ingrese el nombre del cliente:");
					String nombreCliente = leerConsola();
					boolean encontrado = false;
					for (Cliente c : clientes) {
						if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
							encontrado = true;
							List<Tiquete> tiquetes = c.getTiquetes();
							if (tiquetes.isEmpty()) {
								System.out.println("Este cliente no tiene tiquetes.");
							} else {
								System.out.println("Tiquetes de " + c.getNombre() + ":");
								for (Tiquete t : tiquetes) {
									System.out.println("- Tipo: " + t.getTipo() + ", Usado: " + (t.isUsado() ? "Sí" : "No"));
								}
							}
							break;
						}
					}
					if (!encontrado) {
						System.out.println("Cliente no encontrado.");
					}
				} else {
					System.out.println("Opción no válida.");
				}
			}
			else if (op == 4) {
				System.out.println("Ingrese el nombre del cliente que desea comprar un tiquete:");
				String nombreCliente = leerConsola();

				Cliente clienteEncontrado = null;
				for (Cliente c : clientes) {
					if (c.getNombre().equalsIgnoreCase(nombreCliente)) {
						clienteEncontrado = c;
						break;
					}
				}

				if (clienteEncontrado == null) {
					System.out.println("Cliente no encontrado. ¿Desea registrarlo? (s/n)");
					String respuesta = leerConsola();
					if (respuesta.equalsIgnoreCase("s")) {
						System.out.println("Ingrese login:");
						String login = leerConsola();
						System.out.println("Ingrese contraseña:");
						String password = leerConsola();
						clienteEncontrado = new Cliente(login, password, nombreCliente, null);
						clientes.add(clienteEncontrado);
						System.out.println("Cliente registrado exitosamente.");
					} else {
						System.out.println("Venta cancelada.");
						return;
					}
				}

				System.out.println("¿Desea agregar FastPass? (s/n)");
				boolean fastPass = leerConsola().equalsIgnoreCase("s");

				System.out.println("Seleccione el tipo de tiquete a comprar:");
				System.out.println("1. Básico");
				System.out.println("2. Familiar");
				System.out.println("3. Oro");
				System.out.println("4. Diamante");

				int tipo = Integer.parseInt(leerConsola());
				Tiquete nuevo = null;
				List<Atraccion> atraccionesVacias = new ArrayList<Atraccion>(); // Simulación por ahora

				if (tipo == 1) {
					nuevo = new TiqueteBasico(fastPass);
				} else if (tipo == 2) {
					nuevo = new TiqueteFamiliar(atraccionesVacias, fastPass);
				} else if (tipo == 3) {
					nuevo = new TiqueteOro(atraccionesVacias, fastPass);
				} else if (tipo == 4) {
					nuevo = new TiqueteDiamante(atraccionesVacias, fastPass);
				} else {
					System.out.println("Tipo de tiquete inválido.");
					return;
				}

				clienteEncontrado.usarTiquete(nuevo);
				System.out.println("Tiquete agregado exitosamente al cliente " + clienteEncontrado.getNombre());
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


