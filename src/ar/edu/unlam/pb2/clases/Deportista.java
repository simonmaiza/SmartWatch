package ar.edu.unlam.pb2.clases;

public class Deportista {

	private String nombre;
	private Integer edad;
	private Double pesoActual;
	private Double alturaActual;
	private Integer pasosDiarios;

	// Zonas
	private Integer maximoZona1Carrera;
	private Integer maximoZona2Carrera;
	private Integer maximoZona3Carrera;
	private Integer maximoZona4Carrera;
	
	private Integer maximoZona1Ciclismo;
	private Integer maximoZona2Ciclismo;
	private Integer maximoZona3Ciclismo;
	private Integer maximoZona4Ciclismo;
	
	public Deportista(String nombre, Integer edad, Double pesoActual, Double altura) {
		this.setNombre(nombre);
		this.edad = edad;
		this.pesoActual = pesoActual;
		this.alturaActual = altura;
		this.pasosDiarios = 0;
	}

	public void setMaximoZona1Carrera(Integer maximoZona1) {
		this.maximoZona1Carrera = maximoZona1;
	}
	
	public void setMaximoZona2Carrera(Integer maximoZona2) {
		this.maximoZona2Carrera = maximoZona2;
	}
	
	public void setMaximoZona3Carrera(Integer maximoZona3) {
		this.maximoZona3Carrera = maximoZona3;
	}
	
	public void setMaximoZona4Carrera(Integer maximoZona4) {
		this.maximoZona4Carrera = maximoZona4;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(Double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public Double getAltura() {
		return alturaActual;
	}

	public void setAltura(Double altura) {
		this.alturaActual = altura;
	}

	public Integer getMaximoZona1Carrera() {
		return maximoZona1Carrera;
	}

	public Integer getMaximoZona2Carrera() {
		return maximoZona2Carrera;
	}

	public Integer getMaximoZona3Carrera() {
		return maximoZona3Carrera;
	}

	public Integer getMaximoZona4Carrera() {
		return maximoZona4Carrera;
	}
	
	public void darUnPaso() {
		pasosDiarios++;
	}
	
	public void resetPasosDiarios() {
		pasosDiarios=0;
	}

	public Integer getPasosDiarios() {
		return pasosDiarios;
	}

	public Integer getMaximoZona1Ciclismo() {
		return maximoZona1Ciclismo;
	}

	public void setMaximoZona1Ciclismo(Integer maximoZona1Ciclismo) {
		this.maximoZona1Ciclismo = maximoZona1Ciclismo;
	}

	public Integer getMaximoZona2Ciclismo() {
		return maximoZona2Ciclismo;
	}

	public void setMaximoZona2Ciclismo(Integer maximoZona2Ciclismo) {
		this.maximoZona2Ciclismo = maximoZona2Ciclismo;
	}

	public Integer getMaximoZona3Ciclismo() {
		return maximoZona3Ciclismo;
	}

	public void setMaximoZona3Ciclismo(Integer maximoZona3Ciclismo) {
		this.maximoZona3Ciclismo = maximoZona3Ciclismo;
	}

	public Integer getMaximoZona4Ciclismo() {
		return maximoZona4Ciclismo;
	}

	public void setMaximoZona4Ciclismo(Integer maximoZona4Ciclismo) {
		this.maximoZona4Ciclismo = maximoZona4Ciclismo;
	}
}
