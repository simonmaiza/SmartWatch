package ar.edu.unlam.pb2.clases;

import java.util.ArrayList;

public class Reloj {

	private Byte horas;
	private Byte minutos;
	private Byte segundos;
	private ArrayList<Deportista> historialUsuarios;
	private ArrayList<Disciplina> actividades;
	private Disciplina actividadEnCurso;

	public Reloj() {
		horas = 0;
		minutos = 0;
		segundos = 0;
		this.historialUsuarios = new ArrayList<Deportista>();
		this.actividades = new ArrayList<Disciplina>();
	}
	
	public void setHoraActual(String horaActual) {
		String hora[] = horaActual.split(":");
		horas = Byte.parseByte(hora[0]);
		minutos = Byte.parseByte(hora[1]);
		segundos = Byte.parseByte(hora[2]);
	}

	public String toString() {
		if(actividadEnCurso==null) {
			return String.format("%0" + 2 + "d", horas) + ":" + String.format("%0" + 2 + "d", minutos) + ":" + String.format("%0" + 2 + "d", segundos);

		}
		else {
			return actividadEnCurso.toString();
		}
	}
	
	public void enviarPulsoTiempo() {
		actualizarHora();
		actualizarActividadActual();
	}
	
	private void actualizarHora() {
		if(segundos!=59) {
			segundos++;
		}
		else {
			segundos=0;
			if(minutos!=59) {
				minutos++;
			}
			else {
				minutos=0;
				if(horas!=23) {
					horas++;
				}
				else {
					horas=0;
					getUsuarioActual().resetPasosDiarios();
				}
			}
		}
	}
	
	private void actualizarActividadActual() {
		if(actividadEnCurso!=null) {
			actividadEnCurso.incrementarTiempo();
		}
	}
	
	public void enviarPulsoDistancia() {
		actividadEnCurso.incrementarDistancia();
	}

	public void enviarPulsoPaso() {
		getUsuarioActual().darUnPaso();
	}

	public Deportista getUsuarioActual() {
		return this.historialUsuarios.get(historialUsuarios.size()-1);
	}


	public void addUsuario(Deportista usuario) {
		historialUsuarios.add(usuario);
	}
	
	public void addActividad(Disciplina nueva) {
		actividades.add(nueva);
	}
	
	public void iniciarCarrera() {
		this.actividadEnCurso = new Carrera(getUsuarioActual());
	}
	
	public void iniciarCiclismo() {
		this.actividadEnCurso = new Ciclismo(getUsuarioActual());
	}
	
	public void iniciarNatacion() {
		// TODO Auto-generated method stub
		this.actividadEnCurso = new Natacion(getUsuarioActual());
		
	}
	
	public void setFrecuencia(Integer frecuencia) {
		this.actividadEnCurso.setFrecuencia(frecuencia);
	}

	public Integer getDistancia() {
		// TODO Auto-generated method stub
		return actividadEnCurso.getDistancia();
	}

	public String getTiempo() {
		// TODO Auto-generated method stub
		return actividadEnCurso.getTiempo();
	}
	
	public ZonasFrecuenciaCardiaca getZona() {
		return actividadEnCurso.getZona();
	}

	public Disciplina getActividadEnCurso() {
		return actividadEnCurso;
	}
	
	public void setCadenciaActual(Integer cadenciaActual) {
		if(actividadEnCurso instanceof Ciclismo) {
			((Ciclismo)actividadEnCurso).setCadenciaActual(cadenciaActual);
		}
	}
	
	public void guardarActividadActual() {
		actividades.add(actividadEnCurso);
	}


}
