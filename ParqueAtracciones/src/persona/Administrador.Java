package persona;

import java.time.LocalDate;

public class Administrador extends Empleado {

    public Administrador(String login, String password, String nombre, int Id) {
        super(login, password, nombre, Id, "Oficina");
    }

    //  Método para asignar un turno a otro empleado
    public void asignarTurno(Empleado empleado, LocalDate fecha, Turno turno) {
        empleado.asignarTurno(fecha, turno);
    }

    //  Método para cambiar información básica de un empleado
    public void cambiarInformacionEmpleado(Empleado empleado, String nuevoNombre, String nuevoLugarTrabajo) {
        empleado.setNombre(nuevoNombre);
        empleado.setLugarTrabajo(nuevoLugarTrabajo);
    }
}
