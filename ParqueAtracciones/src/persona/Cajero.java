package persona;

import java.util.ArrayList;
import java.util.List;


public class Cajero extends Empleado {
	private boolean Capacitacion;

	public Cajero(String login, String password, String nombre, int Id, String lugarTrabajo, boolean capacitacion) {
		super(login, password, nombre, Id);
		this.Capacitacion = capacitacion;
	}
	
	public Boolean getCapacitacion() {
		return Capacitacion;
	}
	
	public void setCapacitacion(Boolean capacitado) {
		this.Capacitacion = capacitado;
	}
	
	private List<String> ventas = new ArrayList<>();

	public boolean registrarVenta(String producto, double valor) {
	    ventas.add("Producto: " + producto + ", Valor: " + valor);
	    return true;
	}

}
