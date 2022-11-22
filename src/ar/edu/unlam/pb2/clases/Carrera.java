package ar.edu.unlam.pb2.clases;

public class Carrera extends Disciplina {

	private final Integer CONVERSION_A_KILOMETROS = 1000;
	// En carrera la distancia se mide en kilómetros
	
	public Carrera (Deportista quienRealizaLaActividad) {
		super(quienRealizaLaActividad);
	}
	
	public Integer getDistancia() {
		return distanciaActual/CONVERSION_A_KILOMETROS;
	}

	public Double getRitmo() {
		Integer tiempoEnMinutos = tiempoActual/60;
		Integer distanciaEnKilometros = distanciaActual/1000;
		return ((double)tiempoEnMinutos/distanciaEnKilometros);
	}
	
	public ZonasFrecuenciaCardiaca getZona() {
		if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona1Carrera()) {
			return ZonasFrecuenciaCardiaca.ZONA1;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona2Carrera() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona1Carrera()) {
			return ZonasFrecuenciaCardiaca.ZONA2;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona3Carrera() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona2Carrera()) {
			return ZonasFrecuenciaCardiaca.ZONA3;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona4Carrera() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona3Carrera()) {
			return ZonasFrecuenciaCardiaca.ZONA4;
		}
		else {
			return ZonasFrecuenciaCardiaca.ZONA5;
		}
	}
	
	public String toString() {
		return "Distancia recorrida: " + getDistancia()
		+ "Tiempo transcurrido: " + getTiempo()
		+ "Ritmo: " + getRitmo()
		+ getZona();
	}
}
