package atracciones;

public class AtraccionMecanica extends Atraccion{
	
	private int minimoAltura;
	private int maximoAltura;
	private int minimoPeso;
	private int maximoPeso;
	private String restriccionesSalud;
	private String nivelRiesgo;
	
	// Getters y setters

	public int getMinimoAltura() {
		return minimoAltura;
	}

	public void setMinimoAltura(int minimoAltura) {
		this.minimoAltura = minimoAltura;
	}

	public int getMaximoAltura() {
		return maximoAltura;
	}

	public void setMaximoAltura(int maximoAltura) {
		this.maximoAltura = maximoAltura;
	}

	public int getMinimoPeso() {
		return minimoPeso;
	}

	public void setMinimoPeso(int minimoPeso) {
		this.minimoPeso = minimoPeso;
	}

	public int getMaximoPeso() {
		return maximoPeso;
	}

	public void setMaximoPeso(int maximoPeso) {
		this.maximoPeso = maximoPeso;
	}

	public String getRestriccionesSalud() {
		return restriccionesSalud;
	}

	public void setRestriccionesSalud(String restriccionesSalud) {
		this.restriccionesSalud = restriccionesSalud;
	}

	public String getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	// Constructor utilizando la superclase
	public AtraccionMecanica(String nombre, int cupoMaximo, int empleadosEncargados, boolean disponibleClima,
			String nivelExclusividad, int minimoAltura, int maximoAltura, int minimoPeso, int maximoPeso,
			String restriccionesSalud, String nivelRiesgo) {
		super(nombre, cupoMaximo, empleadosEncargados, disponibleClima, nivelExclusividad);
		this.minimoAltura = minimoAltura;
		this.maximoAltura = maximoAltura;
		this.minimoPeso = minimoPeso;
		this.maximoPeso = maximoPeso;
		this.restriccionesSalud = restriccionesSalud;
		this.nivelRiesgo = nivelRiesgo;
	}

	@Override
	public void aptaParaCliente() {
		
	}
	
}
