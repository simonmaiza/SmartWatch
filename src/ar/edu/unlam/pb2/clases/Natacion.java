package ar.edu.unlam.pb2.clases;

public class Natacion extends Disciplina {

	public Natacion(Deportista quienRealizaLaActividad) {
		super(quienRealizaLaActividad);
		// TODO Auto-generated constructor stub
	}

	public ZonasFrecuenciaCardiaca getZona() {
		if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona1Ciclismo()) {
			return ZonasFrecuenciaCardiaca.ZONA1;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona2Ciclismo() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona1Ciclismo()) {
			return ZonasFrecuenciaCardiaca.ZONA2;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona3Ciclismo() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona2Ciclismo()) {
			return ZonasFrecuenciaCardiaca.ZONA3;
		}
		else if(frecuenciaActual<=quienRealizaLaActividad.getMaximoZona4Ciclismo() && frecuenciaActual>quienRealizaLaActividad.getMaximoZona3Ciclismo()) {
			return ZonasFrecuenciaCardiaca.ZONA4;
		}
		else {
			return ZonasFrecuenciaCardiaca.ZONA5;
		}
	}

	public String toString() {
		return "Distancia recorrida: " + getDistancia() + " m"
		+ " Tiempo transcurrido: " + getTiempo()
		+ " Ritmo: " + getRitmoFormateado();
	}

	public Double getRitmo() {
		// Tiempo en minutos que se demora en hacer 100 m
		return ((100.0*tiempoActual/distanciaActual)/60);
	}
	
	private String getRitmoFormateado() {
		Integer minutos = 0, segundos = 0;
		Double decimalDeLosMinutos;
		minutos = getRitmo().intValue();
		decimalDeLosMinutos = getRitmo()-minutos;
		segundos = (int)(decimalDeLosMinutos*60);
		return String.format("%0" + 2 + "d", minutos) + ":" + String.format("%0" + 2 + "d", segundos);
	}
}
