package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import tiquetes.EntradaIndividual;
import tiquetes.Taquilla;
import tiquetes.Tiquete;
import tiquetes.TiqueteOro;
import tiquetes.TiqueteTemporada;
import tiquetes.VentaOnline;
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
	private LugarServicio lugarServicio;
	private OperadorMecanico operadorMecanico;
	private ServicioGeneral servicioGeneral;
	private Turno turnoDiurno;
	private Turno turnoNocturno;
	private Cliente cliente;
	private Cliente cliente2;
	private EntradaIndividual entradaIndividual;
	private Taquilla taquilla;
	private Tiquete tiquete;
	private TiqueteBasico tiqueteBasico;
	private TiqueteDiamante tiqueteDiamante;
	private TiqueteFamiliar tiqueteFamiliar;
	private TiqueteOro tiqueteOro;
	private TiqueteTemporada tiqueteTemporada;
	private VentaOnline ventaOnline;

	private List<Empleado> empleados;
	private List<Cliente> clientes;
	private List<Tiquete> tiquetes;
	private List<Tiquete> tiquetes2;
	private List<Atraccion> atraccionesDiamante;
	private List<Atraccion> atraccionesFamiliares;

	public Principal() {

		// Creamos una instancia de todas las clases para probarlas
		atraccionCultural = new AtraccionCultural("Carrusel", 20, 2, true, "familiar", 5);
		atraccionMecanica = new AtraccionMecanica("MontanaRusa", 10, 4, true, "oro", 150, 190, 40, 90, "vertigo",
				"medio");
		LocalDateTime inicio1 = LocalDateTime.of(2025, 1, 10, 12, 00); // 10 de enero de 2025, 12:00
		LocalDateTime fin1 = LocalDateTime.of(2025, 3, 1, 12, 00); // 1 de marzo de 2025, 12:00
		temporada = new Temporada(inicio1, fin1);
		espectaculo = new Espectaculo("DesfileInvierno", temporada, "18:00 - 21:00", false);

		// Turno diurno: 2 de abril de 2025, de 8:00 AM a 4:00 PM
		LocalDateTime inicioDiurno = LocalDateTime.of(2025, 4, 2, 8, 0);
		LocalDateTime finDiurno = LocalDateTime.of(2025, 4, 2, 16, 0);
		turnoDiurno = new Turno("Diurno", inicioDiurno, finDiurno);

		// Turno nocturno: 2 de abril de 2025, de 6:00 PM a 3 de abril de 2025, 2:00 AM
		LocalDateTime inicioNocturno = LocalDateTime.of(2025, 4, 2, 18, 0);
		LocalDateTime finNocturno = LocalDateTime.of(2025, 4, 3, 2, 0);
		turnoNocturno = new Turno("Nocturno", inicioNocturno, finNocturno);

		// Fecha en que se asignaran los turnos
		LocalDate fechaTurno = LocalDate.of(2025, 4, 2); // 2 de abril de 2025

		// Creamos las instancias de los empleados
		administrador = new Administrador("Juan123", "123", "Juan Carlos", 100, "Administracion", turnoDiurno);
		cajero = new Cajero("Pablo15", "123", "Pablo Mancera", 200, "Taquilla", turnoDiurno, true);
		cocinero = new Cocinero("Paola25", "123", "Paola Suarez", 300, "Cocina", turnoDiurno, true);
		lugarServicio = new LugarServicio("cocina");
		operadorMecanico = new OperadorMecanico("JuanPablo1", "123", "Juan Pablo Correa", 400, "MontanaRusa", true, atraccionMecanica, turnoDiurno);
		servicioGeneral = new ServicioGeneral("Ernesto1", "123", "Ernesto Lopez", 500, "Baños", turnoNocturno);

		// Asignamos turnos a los empleados
		administrador.asignarTurno(fechaTurno, turnoDiurno);
		cajero.asignarTurno(fechaTurno, turnoDiurno);
		cocinero.asignarTurno(fechaTurno, turnoDiurno);
		operadorMecanico.asignarTurno(fechaTurno, turnoDiurno);
		servicioGeneral.asignarTurno(fechaTurno, turnoNocturno);

		empleados = new ArrayList<Empleado>();
		empleados.add(administrador);
		empleados.add(cajero);
		empleados.add(cocinero);
		empleados.add(operadorMecanico);
		empleados.add(servicioGeneral);
		
		// Creamos las instancias de un cliente y los tiquetes
		atraccionesDiamante = new ArrayList<Atraccion>();
		atraccionesDiamante.add(atraccionMecanica);
		
		tiqueteDiamante= new TiqueteDiamante(atraccionesDiamante, true);
		tiquetes= new ArrayList<Tiquete>();
		tiquetes.add(tiqueteDiamante);
		
		clientes= new ArrayList<Cliente>();
		cliente= new Cliente("Felipe1", "123", "Felipe Garcia", tiquetes);
		clientes.add(cliente);
		
		atraccionesFamiliares = new ArrayList<Atraccion>();
		atraccionesFamiliares.add(atraccionCultural);
		
		tiqueteFamiliar= new TiqueteFamiliar(atraccionesFamiliares, true);
		tiquetes2= new ArrayList<Tiquete>();
		tiquetes2.add(tiqueteDiamante);
		tiquetes2.add(tiqueteFamiliar);
		
		cliente2= new Cliente("Juan05", "123", "Juan Jimenez", tiquetes2);
		clientes.add(cliente2);
		
		

		// Activamos el Buffer Reader para leer informacion de la consola
		this.br = new BufferedReader(new InputStreamReader(System.in));
		int op;

		// Inciamos el menu principal de la aplicacion
		do {
			System.out.println("Digite:\n" + "0. Salir\n" + "1. Consultar requisito atraccion\n"
					+ "2. Consultas Trabajadores\n" + "3. Consultar tiquetes\n"+ "4. Comprar tiquetes");
			op = Integer.parseInt(leerConsola());

			// Consultas relacionadas con las atracciones del parque
			if (op == 1) {
				System.out.println("Digite:\n" + "0. Salir\n" + "1. Consultar requisito atraccion\n"
						+ "2. Consultar disponibilidad atraccion o espectaculo\n");
				int consulta = Integer.parseInt(leerConsola());

				// Consulta de los requisitos de una atraccion
				if (consulta == 1) {
					System.out.println(
							"Menu para consultar si un usuario es apto para ingresar a una atraccion en especifico");
					System.out.println(
							"Digite:\n" + "0. Salir\n" + "1. Atraccion Mecanica\n" + "2. Atraccion Cultural\n");
					int tipoAtraccion = Integer.parseInt(leerConsola());
					if (tipoAtraccion == 0) {
						op = 0;
					}

					// Criterios de una atraccion Mecanica
					else if (tipoAtraccion == 1) {
						System.out.println("Ingrese el peso del usuario: ");
						int pesoUsr = Integer.parseInt(leerConsola());
						System.out.println("Ingrese la altura del usuario: ");
						int altUsr = Integer.parseInt(leerConsola());
						System.out.println("Ingrese las restricciones de salud del usuario: ");
						String restrUsr = leerConsola();
						atraccionMecanica.aptaParaCliente(altUsr, pesoUsr, restrUsr);
						if (atraccionMecanica.isRespuesta() == false) {
							System.out
							.println("El usuario dado no cumple con los requisitos para entrar a la atraccion");
						} else if (atraccionMecanica.isRespuesta() == true) {
							System.out.println("El usuario dado puede ingresar a la atraccion");
						}
					}

					// Criterios de una atraccion cultural
					else if (tipoAtraccion == 2) {
						System.out.println("Ingrese la edad del usuario a consultar: ");
						int edad = Integer.parseInt(leerConsola());
						atraccionCultural.aptaParaCliente(edad);
						if (atraccionCultural.isRespuesta() == false) {
							System.out.println(
									"El usuario dado no cumple con la edad minima para ingresar a la atraccion");
						} else if (atraccionCultural.isRespuesta() == true) {
							System.out.println("El usuario dado puede ingresar a la atraccion");
						}
					}
				}

				// Consulta del estado de una atraccion o espectaculo
				else if (consulta == 2) {
					System.out.println(
							"Menu para consultar el estado de una atraccion o espectaculo segun la temporada y clima");
					System.out.println("Digite:\n" + "0. Salir\n" + "1. Atraccion Mecanica\n"
							+ "2. Atraccion cultural\n" + "3. Espectaculo");
					int u = Integer.parseInt(leerConsola());
					if (u == 0) {
						op = 0;

						// Estado Atraccion Mecanica
					} else if (u == 1) {
						boolean condicion = atraccionMecanica.estaDisponible(temporada);
						if (condicion == true) {
							System.out.println("La atraccion mecanica se encuentra disponible");
						} else if (condicion == false) {
							System.out.println("La atraccion mecanica no se encuentra disponible");
						}

						// Estado Atraccion Cultural
					} else if (u == 2) {
						boolean condicion = atraccionCultural.estaDisponible(temporada);
						if (condicion == true) {
							System.out.println("La atraccion cultural se encuentra disponible");
						} else if (condicion == false) {
							System.out.println("La atraccion cultural no se encuentra disponible");
						}

						// Estado Espectaculo
					} else if (u == 3) {
						boolean condicion = espectaculo.estaDisponible();
						if (condicion == true) {
							System.out.println("El espectaculo se va a realizar");
						} else if (condicion == false) {
							System.out.println("El espectaculo no se va a realizar");
						}
					}
				}
			}

			// Consultas relacionadas con los usuarios del parque
			else if (op == 2) {
				System.out.println("Ingrese la opcion a realizar:");
				System.out.println("0. Salir");
				System.out.println("1. Consultar turno Empleado");
				System.out.println("2. Registrar Empleado");
				System.out.println("3. Ver Empleados actuales");
				int tipoUsuario = Integer.parseInt(leerConsola());
				if (tipoUsuario == 0) {
					op = 0;
				}else if (tipoUsuario == 1) {
					System.out.println("Ingrese el nombre del empleado para verificar si tiene turnos:");
					String nombre = leerConsola();
					boolean encontrado = false;

					for (Empleado e : empleados) {
						if (e.getNombre().equalsIgnoreCase(nombre)) {
							encontrado = true;

							System.out.println("Ingrese la fecha para consultar si tiene turno (YYYY-MM-DD):");
							System.out.println("Probar con 2025-04-02");
							String fechaTexto = leerConsola();
							try {
								LocalDate fecha = LocalDate.parse(fechaTexto);
								Turno turno = e.consultarTurno(fecha);

								if (turno != null) {
									System.out.println("Se encontro un turno para el empleado dado");
									System.out.println("Turno asignado para " + fecha + ":");
									System.out.println("Tipo: " + turno.getTipo());
									DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
									System.out.println("Inicio: " + turno.getHoraInicio().format(formatoHora));
									System.out.println("Fin: " + turno.getHoraFin().format(formatoHora));
									System.out.println("Lugar de trabajo: " + e.getLugarTrabajo());
								} else {
									System.out.println("No tiene turno asignado para esa fecha.");
								}
							} catch (Exception ex) {
								System.out.println("Fecha inválida. Asegúrate de usar el formato YYYY-MM-DD.");
							}
							break;
						}
					}

					if (!encontrado) {
						System.out.println("Empleado no encontrado.");
						System.out.println("Empleado no encontrado. ¿Desea registrarlo? (s/n)");
						String respuesta = leerConsola();
						if (respuesta.equalsIgnoreCase("s")) {
							System.out.println("Ingrese login:");
							String login = leerConsola();
							System.out.println("Ingrese contraseña:");
							String password = leerConsola();
							System.out.println("Seleccione el tipo de empleado que se va a registrar:");
							System.out.println("1. Cajero");
							System.out.println("2. Cocinero");
							System.out.println("3. Operador Mecanico");
							System.out.println("4. Servicio General");

							int tipo = Integer.parseInt(leerConsola());
							LocalDate fechaTurnoNuevoEmpleado = LocalDate.of(2025, 4, 2); // 2 de abril de 2025
							
							if (tipo == 1) {
								Cajero empleadoEncontrado = new Cajero(login, password, nombre, 1, "Taquilla", turnoDiurno, true);
								empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
								empleados.add(empleadoEncontrado);
							} else if (tipo == 2) {
								Cocinero empleadoEncontrado= new Cocinero(login, password, nombre, 1, "Cocina", turnoDiurno, true);
								empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
								empleados.add(empleadoEncontrado);
							} else if (tipo == 3) {
								OperadorMecanico empleadoEncontrado= new OperadorMecanico(login, password, nombre, 1, "MontanaRusa", true, atraccionMecanica, turnoDiurno);
								empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
								empleados.add(empleadoEncontrado);
							} else if (tipo == 4) {
								ServicioGeneral empleadoEncontrado= new ServicioGeneral(login, password, nombre, 1, "Baños", turnoDiurno);
								empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
								empleados.add(empleadoEncontrado);
							} else {
								System.out.println("Tipo de empleado inválido.");
								return;
							}
							System.out.println("Empleado registrado exitosamente.");
						} else {
							System.out.println("Proceso cancelado.");
							return;
						}
					}
				} else if (tipoUsuario == 2) {
					System.out.println("Ingrese el nombre:");
					String nombre = leerConsola();
					System.out.println("Ingrese login:");
					String login = leerConsola();
					System.out.println("Ingrese contraseña:");
					String password = leerConsola();
					System.out.println("Seleccione el tipo de empleado que se va a registrar:");
					System.out.println("1. Cajero");
					System.out.println("2. Cocinero");
					System.out.println("3. Operador Mecanico");
					System.out.println("4. Servicio General");

					int tipo = Integer.parseInt(leerConsola());
					LocalDate fechaTurnoNuevoEmpleado = LocalDate.of(2025, 4, 2); // 2 de abril de 2025
					
					if (tipo == 1) {
						Cajero empleadoEncontrado = new Cajero(login, password, nombre, 1, "Taquilla", turnoDiurno, true);
						empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
						empleados.add(empleadoEncontrado);
					} else if (tipo == 2) {
						Cocinero empleadoEncontrado= new Cocinero(login, password, nombre, 1, "Cocina", turnoDiurno, true);
						empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
						empleados.add(empleadoEncontrado);
					} else if (tipo == 3) {
						OperadorMecanico empleadoEncontrado= new OperadorMecanico(login, password, nombre, 1, "MontanaRusa", true, atraccionMecanica, turnoDiurno);
						empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
						empleados.add(empleadoEncontrado);
					} else if (tipo == 4) {
						ServicioGeneral empleadoEncontrado= new ServicioGeneral(login, password, nombre, 1, "Baños", turnoDiurno);
						empleadoEncontrado.asignarTurno(fechaTurnoNuevoEmpleado, turnoDiurno);
						empleados.add(empleadoEncontrado);
					} else {
						System.out.println("Tipo de empleado inválido.");
						return;
					}
					System.out.println("Empleado registrado exitosamente.");
				}else if (tipoUsuario == 3) {
					if (empleados.isEmpty()) {
						System.out.println("No hay empleados registrados.");
					} else {
						System.out.println("Empleados registrados:");
						for (Empleado e : empleados) {
							System.out.println("- " + e.getNombre());
						}
					}
				}
			}

			// Consultas relacionadas con el sistema de tiquetes
			else if (op == 3) {
				System.out.println("Menú de consulta de tiquetes");
				System.out.println("0. Salir");
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
									System.out.println(
											"- Tipo: " + t.getTipo() + ", Usado: " + (t.isUsado() ? "Sí" : "No"));
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
			} else if (op == 4) {
				ArrayList<Tiquete> tiqueteCliente = new ArrayList<Tiquete>();
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
						clienteEncontrado = new Cliente(login, password, nombreCliente, tiqueteCliente);
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
				List<Atraccion> atraccionesVacias = new ArrayList<Atraccion>(); // Simulación por ahora
				Tiquete nuevo;
				if (tipo == 1) {
					nuevo = new TiqueteBasico(fastPass);
					tiqueteCliente.add(nuevo);
				} else if (tipo == 2) {
					nuevo = new TiqueteFamiliar(atraccionesVacias, fastPass);
					tiqueteCliente.add(nuevo);
				} else if (tipo == 3) {
					nuevo = new TiqueteOro(atraccionesVacias, fastPass);
					tiqueteCliente.add(nuevo);
				} else if (tipo == 4) {
					nuevo = new TiqueteDiamante(atraccionesVacias, fastPass);
					tiqueteCliente.add(nuevo);
				} else {
					System.out.println("Tipo de tiquete inválido.");
					return;
				}
				

				// clienteEncontrado.usarTiquete(nuevo);
				System.out.println("Tiquete agregado exitosamente al cliente " + clienteEncontrado.getNombre());
			}

		} while (op != 0);
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