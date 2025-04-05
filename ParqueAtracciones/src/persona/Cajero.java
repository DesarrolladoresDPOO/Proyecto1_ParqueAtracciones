package persona;

import tiquetes.Taquilla;

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
    public boolean registrarVenta(Taquilla taquilla, String producto, double valor) {
        if (taquilla != null) {
            return taquilla.registrarVenta(producto, valor);
        }
        return false;
    }
}
