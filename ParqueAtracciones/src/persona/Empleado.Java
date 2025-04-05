package persona;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public abstract class Empleado extends Usuario {

    private String nombre;
    private int Id;
    private Map<LocalDate, Turno> turnosAsignados = new HashMap<>();
    private String lugarTrabajo;
    
    //Constructor
    public Empleado(String login, String password, String nombre, int Id) {
        super(login, password);
        this.nombre = nombre;
        this.Id = Id;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    // Metodos para turnos
    public Turno consultarTurno(LocalDate fecha) {
        return turnosAsignados.get(fecha);
    }

    public void asignarTurno(LocalDate fecha, Turno turno) {
        turnosAsignados.put(fecha, turno);
    }
    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }
    public String getLugarTrabajo();
    return lugarTrabajo
}
