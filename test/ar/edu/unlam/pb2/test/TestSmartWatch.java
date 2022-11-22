package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.pb2.clases.Carrera;
import ar.edu.unlam.pb2.clases.Deportista;
import ar.edu.unlam.pb2.clases.Natacion;
import ar.edu.unlam.pb2.clases.Reloj;
import ar.edu.unlam.pb2.clases.ZonasFrecuenciaCardiaca;



public class TestSmartWatch {

	// Datos de usuario genérico
		private static String NOMBRE = "Delfina Pignatello";
		private static Integer EDAD = 22;
		private static Double PESO = 56.0;
		private static Double ALTURA = 1.60;
		private static Integer MAXIMO_ZONA1 = 70;
		private static Integer MAXIMO_ZONA2 = 90;
		private static Integer MAXIMO_ZONA3 = 120;
		private static Integer MAXIMO_ZONA4 = 150;

		@Test
		public void queSePuedaCrearUnReloj() {
			// Preparación
			String horaActual = "12:00:00";
			
			// Ejecución
			Reloj clasico = new Reloj();
			clasico.setHoraActual(horaActual);
			
			// Verificación
			assertEquals(horaActual, clasico.toString());
		}
		
		@Test
		public void queSeCalculeElTiempoDeFormaCorrecta() {
			// Preparación
			Integer TIEMPO_TRANSCURRIDO = 5430;
			String TIEMPO_TRANSCURRIDO_ESPERADO = "01:30:30";
			
			// Ejecución
			Reloj clasico = new Reloj();
			
			for(int i=0; i<TIEMPO_TRANSCURRIDO; i++) {
				clasico.enviarPulsoTiempo();
			}
			
			// Verificación
			assertEquals(TIEMPO_TRANSCURRIDO_ESPERADO, clasico.toString());
		}
		
		@Test
		public void queSePuedaConfigurarUnNuevoUsuario() {
			// Preparación
			
			// Ejecución
			Deportista nuevo = new Deportista(NOMBRE, EDAD, PESO, ALTURA);
			Reloj garmin = new Reloj();
			garmin.addUsuario(nuevo);
			
			// Verificación
			assertEquals(NOMBRE, garmin.getUsuarioActual().getNombre());
			assertEquals(EDAD, garmin.getUsuarioActual().getEdad());
			assertEquals(PESO, garmin.getUsuarioActual().getPesoActual());
			assertEquals(ALTURA, garmin.getUsuarioActual().getAltura());
		}
		
		@Test
		public void queSePuedanContabilizarLosPasos() {
			// Preparación
			Integer CANTIDAD_DE_PASOS = 500;
			
			// Ejecución
			Deportista nuevo = new Deportista(NOMBRE, EDAD, PESO, ALTURA);
			Reloj garmin = new Reloj();
			garmin.addUsuario(nuevo);
			for(Integer i=0; i<CANTIDAD_DE_PASOS; i++) {
				garmin.enviarPulsoPaso();
			}
			
			// Verificación
			assertEquals(CANTIDAD_DE_PASOS, garmin.getUsuarioActual().getPasosDiarios());
		}
		
		@Test
		public void queSePuedaCrearUnaDisciplinaDeTipoCarrera() {

			// Preparación
			Integer distanciaRecorrida = 10000;// en metros
			Integer tiempoTranscurrido = 3600; // en segundos	
			Integer frecuenciaActual = 85;
			
			Integer DISTANCIA_ESPERADA = 10; // en kilómetros
			String TIEMPO_ESPERADO = "01:00:00"; // en horas, minutos y segundos
			Double RITMO_ESPERADO = 6.0; // En minutos cada 1 km
			ZonasFrecuenciaCardiaca ZONA_ESPERADA = ZonasFrecuenciaCardiaca.ZONA2;
			String VISUALIZACION_ESPERADA = "Distancia recorrida: " + DISTANCIA_ESPERADA
					+ "Tiempo transcurrido: " + TIEMPO_ESPERADO
					+ "Ritmo: " + RITMO_ESPERADO
					+ ZONA_ESPERADA;
			
			// Ejecución
			Deportista actual = new Deportista(NOMBRE, EDAD, PESO, ALTURA);
			actual.setMaximoZona1Carrera(MAXIMO_ZONA1);
			actual.setMaximoZona2Carrera(MAXIMO_ZONA2);
			actual.setMaximoZona3Carrera(MAXIMO_ZONA3);
			actual.setMaximoZona4Carrera(MAXIMO_ZONA4);

			Reloj garmin = new Reloj();
			garmin.addUsuario(actual);
			garmin.iniciarCarrera();
			
			for(int i=0; i<distanciaRecorrida; i++) {
				garmin.enviarPulsoDistancia();
			}
			for(int i=0; i<tiempoTranscurrido; i++) {
				garmin.enviarPulsoTiempo();
			}

			garmin.setFrecuencia(frecuenciaActual);
			
			// Verificación
			assertEquals(DISTANCIA_ESPERADA, garmin.getDistancia());
			assertEquals(TIEMPO_ESPERADO, garmin.getTiempo());
			assertEquals(RITMO_ESPERADO, ((Carrera)garmin.getActividadEnCurso()).getRitmo(), 0.01);
			assertEquals(ZONA_ESPERADA, garmin.getZona());
			assertEquals(VISUALIZACION_ESPERADA, garmin.toString());
			
		}
		
		@Test
		public void queSePuedaCrearUnaDisciplinaDeTipoCiclismo() {

			// Preparación
			Integer distanciaRecorrida = 120000;// en metros
			Integer tiempoTranscurrido = 14400; // en segundos	
			Integer frecuenciaActual = 120;
			Integer cadencia = 90;
			
			Integer DISTANCIA_ESPERADA = 120; // en kilómetros
			String TIEMPO_ESPERADO = "04:00:00"; // en horas, minutos y segundos
			Double VELOCIDAD_ESPERADA = 30.0; // En el ciclismo no hay ritmo
			ZonasFrecuenciaCardiaca ZONA_ESPERADA = ZonasFrecuenciaCardiaca.ZONA3;
			String VISUALIZACION_ESPERADA = "Distancia recorrida: " + DISTANCIA_ESPERADA + " km"
					+ " Tiempo transcurrido: " + TIEMPO_ESPERADO
					+ " Velocidad: " + VELOCIDAD_ESPERADA.intValue() + " km/h"
					+ " Zona " + ZONA_ESPERADA
					+ " Cadencia " + cadencia;
					
			
			// Ejecución
			Deportista actual = new Deportista(NOMBRE, EDAD, PESO, ALTURA);
			actual.setMaximoZona1Ciclismo(MAXIMO_ZONA1);
			actual.setMaximoZona2Ciclismo(MAXIMO_ZONA2);
			actual.setMaximoZona3Ciclismo(MAXIMO_ZONA3);
			actual.setMaximoZona4Ciclismo(MAXIMO_ZONA4);

			Reloj garmin = new Reloj();
			garmin.addUsuario(actual);
			garmin.iniciarCiclismo();
			
			for(int i=0; i<distanciaRecorrida; i++) {
				garmin.enviarPulsoDistancia();
			}
			for(int i=0; i<tiempoTranscurrido; i++) {
				garmin.enviarPulsoTiempo();
			}

			garmin.setFrecuencia(frecuenciaActual);
			garmin.setCadenciaActual(cadencia);
			
			// Verificación
			assertEquals(DISTANCIA_ESPERADA, garmin.getDistancia());
			assertEquals(TIEMPO_ESPERADO, garmin.getTiempo());

			assertEquals(ZONA_ESPERADA, garmin.getZona());
			assertEquals(VISUALIZACION_ESPERADA, garmin.toString());
			
		}
		
		@Test
		public void queSePuedaCrearUnaDisciplinaDeTipoNatacion() {

			// Preparación
			Integer distanciaRecorrida = 3000;// en metros
			Integer tiempoTranscurrido = 2550; // en segundos	
			Integer frecuenciaActual = 75;
			
			Double RITMO_ESPERADO = 1.41;
			String RITMO_VISUALIZADO = "01:25";
			String TIEMPO_ESPERADO = "00:42:30"; // en horas, minutos y segundos
			String VISUALIZACION_ESPERADA = "Distancia recorrida: " + distanciaRecorrida + " m"
					+ " Tiempo transcurrido: " + TIEMPO_ESPERADO
					+ " Ritmo: " + RITMO_VISUALIZADO;
					
			
			// Ejecución
			Deportista actual = new Deportista(NOMBRE, EDAD, PESO, ALTURA);

			Reloj garmin = new Reloj();
			garmin.addUsuario(actual);
			garmin.iniciarNatacion();
			
			for(int i=0; i<distanciaRecorrida; i++) {
				garmin.enviarPulsoDistancia();
			}
			for(int i=0; i<tiempoTranscurrido; i++) {
				garmin.enviarPulsoTiempo();
			}
			
			// Verificación
			assertEquals(distanciaRecorrida, garmin.getDistancia());
			assertEquals(TIEMPO_ESPERADO, garmin.getTiempo());
			assertEquals(RITMO_ESPERADO, ((Natacion)garmin.getActividadEnCurso()).getRitmo(), 0.01);
			assertEquals(VISUALIZACION_ESPERADA, garmin.toString());
			
		}
	}

