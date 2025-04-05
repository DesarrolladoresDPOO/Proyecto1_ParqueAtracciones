package tiquetes;

import java.util.ArrayList;
import java.util.List;
import persona.Cajero;

public class Taquilla {

    // Atributo
    private List<Cajero> cajeros;

    // Constructor
    public Taquilla(List<Cajero> cajerosIniciales) {
        this.cajeros = new ArrayList<Cajero>(cajerosIniciales);
    }

    // Getter
    public List<Cajero> getCajeros() {
        return cajeros;
    }

    // Método para asignar un nuevo cajero
    public void asignarCajero(Cajero cajero) {
        cajeros.add(cajero);
    }

	public boolean registrarVenta(String producto, double valor) {
		// TODO Auto-generated method stub
		return false;
	}
}