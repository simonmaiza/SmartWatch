package ar.edu.unlam.pb2.clases;

public class Ciclismo extends Disciplina {

	private final Integer CONVERSION_A_KILOMETROS = 1000;
	private final Integer CONVERSION_A_HORAS = 3600;
	
	private Integer cadenciaActual;
	
	public Ciclismo(Deportista quienRealizaLaActividad) {
		super(quienRealizaLaActividad);
		
	}

	public Integer getDistancia() {
		return distanciaActual/CONVERSION_A_KILOMETROS;
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
	
	public Integer getVelocidad() {
		Double resultado = (Double.valueOf(getDistancia())/getHoras());
		return resultado.intValue();
	}
	
	private Double getHoras() {
		return (Double.valueOf(tiempoActual)/CONVERSION_A_HORAS);
	}
	
	public Integer getCadenciaActual() {
		return cadenciaActual;
	}

	public void setCadenciaActual(Integer cadenciaActual) {
		this.cadenciaActual = cadenciaActual;
	}
	
	public String toString() {
		return "Distancia recorrida: " + getDistancia() + " km"
		+ " Tiempo transcurrido: " + getTiempo()
		+ " Velocidad: " + getVelocidad() + " km/h"
		+ " Zona " + getZona()
		+ " Cadencia " + getCadenciaActual();
	}
}
