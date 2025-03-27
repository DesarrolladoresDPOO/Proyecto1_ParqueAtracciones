package atracciones;

public class AtraccionCultural extends Atraccion{

	public int edadMinima;

	// Getters y setters
	
	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	// Constructor utilizando la superclase
	public AtraccionCultural(String nombre, int cupoMaximo, int empleadosEncargados, boolean disponibleClima,
			String nivelExclusividad, int edadMinima) {
		super(nombre, cupoMaximo, empleadosEncargados, disponibleClima, nivelExclusividad);
		this.edadMinima = edadMinima;
	}
	
	boolean respuesta;
	
	@Override
	public void aptaParaCliente(int edadUsuario) {
		if (edadUsuario < getEdadMinima()) {
			respuesta= false;
		}else {
			respuesta= true;
		}
	}

	public boolean isRespuesta() {
		return respuesta;
	}
	
}
