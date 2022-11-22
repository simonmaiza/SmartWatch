package ar.edu.unlam.pb2.clases;

public abstract class Disciplina {

	protected Integer distanciaActual; // expresada en metros
	protected Integer tiempoActual; // expresado en segundos
	protected Integer frecuenciaActual;
	protected Deportista quienRealizaLaActividad;
	private Boolean enPausa;
	
	public Disciplina(Deportista quienRealizaLaActividad) {
		distanciaActual = 0;
		tiempoActual = 0;
		frecuenciaActual = 0;
		this.quienRealizaLaActividad = quienRealizaLaActividad;
		enPausa = false;
	}
	
	public void pausarContinuar() {
		enPausa = !enPausa;
	}
	
	public void incrementarDistancia() {
		if(!enPausa) {
			distanciaActual++;
		}
	}

	public void incrementarTiempo() {
		if(!enPausa) {
			tiempoActual++;	
		}
	}
	
	public void setFrecuencia(Integer frecuenciaActual) {
		this.frecuenciaActual = frecuenciaActual;
	}

	public Integer getDistancia() {
		return this.distanciaActual;
	}
	
	public String getTiempo() {
		Integer horas = 0, minutos = 0, segundos = 0;
		Double decimalDeLasHoras, decimalDeLosMinutos;
		horas = tiempoActual/3600;
		decimalDeLasHoras = ((double)tiempoActual/3600)-horas ;
		minutos = (int) (decimalDeLasHoras * 60);
		decimalDeLosMinutos = (decimalDeLasHoras * 60) - minutos;
		segundos = (int)(decimalDeLosMinutos*60);
		return String.format("%0" + 2 + "d", horas) + ":" + String.format("%0" + 2 + "d", minutos) + ":" + String.format("%0" + 2 + "d", segundos);
	}
	
	public abstract ZonasFrecuenciaCardiaca getZona();
	
}
