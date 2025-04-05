package persona;

import java.util.ArrayList;
import java.util.List;

public class OperadorMecanico extends Empleado {

    private List<AtraccionMecanica> atraccionesCapacitadas;

    public OperadorMecanico(String login, String password, String nombre, int id, String lugarTrabajo, boolean capacitacionInicial, AtraccionMecanica atraccionInicial) {
        super(login, password, nombre, id, lugarTrabajo);
        atraccionesCapacitadas = new ArrayList<>();
        
        // Si se indica que tiene una capacitación inicial, la agregamos
        if (capacitacionInicial && atraccionInicial != null) {
            atraccionesCapacitadas.add(atraccionInicial);
        }
    }

    public void agregarCapacitacion(AtraccionMecanica atraccion) {
        if (atraccion != null && !atraccionesCapacitadas.contains(atraccion)) {
            atraccionesCapacitadas.add(atraccion);
        }
    }

    public boolean puedeOperar(AtraccionMecanica atraccion) {
        return atraccionesCapacitadas.contains(atraccion);
    }
}
