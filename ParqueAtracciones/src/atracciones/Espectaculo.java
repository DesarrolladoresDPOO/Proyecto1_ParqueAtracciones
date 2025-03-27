package atracciones;

import java.time.LocalDateTime;
import java.util.Date;

public class Espectaculo {
	
	public String nombre;
	public Date fechaDisponible;
	public String horarios;
	public boolean fijaTemporada;
	
	// Getters y Setters
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaDisponible() {
		return fechaDisponible;
	}
	public void setFechaDisponible(Date fechaDisponible) {
		this.fechaDisponible = fechaDisponible;
	}
	public String getHorarios() {
		return horarios;
	}
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}
	public boolean isFijaTemporada() {
		return fijaTemporada;
	}
	public void setFijaTemporada(boolean fijaTemporada) {
		this.fijaTemporada = fijaTemporada;
	}
	
	// Constructor
	
	public Espectaculo(String nombre, Date fechaDisponible, String horarios, boolean fijaTemporada) {
		this.nombre = nombre;
		this.fechaDisponible = fechaDisponible;
		this.horarios = horarios;
		this.fijaTemporada = fijaTemporada;
	}
	
	// Comparamos la fecha de hoy para saber si el espectaculo se encuentra disponible
	
	public boolean estaDisponible(Temporada temporada) {
	    LocalDateTime fechaActual = LocalDateTime.now();
	    return fechaActual.isAfter(temporada.getFechaInicio()) && fechaActual.isBefore(temporada.getFechaFin());
	}
	
}
