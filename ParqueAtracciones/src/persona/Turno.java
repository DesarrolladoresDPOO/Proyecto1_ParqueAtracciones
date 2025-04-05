package persona;

import java.time.LocalTime;

public class Turno {
    private String tipo; // "Diurno" o "Nocturno"
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Turno(String tipo, LocalTime horaInicio, LocalTime horaFin) {
        this.tipo = tipo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return tipo + " (" + horaInicio + " - " + horaFin + ")";
    }
}
