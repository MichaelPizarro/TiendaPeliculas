package com.catalogo.peliculas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PeliculasApplicationTests {

	private AnalizadorTitulosImpl1 analizadorTitulosImpl1;
	private AnalizadorTitulosImpl2 analizadorTitulosImpl2;

	public PeliculasApplicationTests(){
		analizadorTitulosImpl1 = new AnalizadorTitulosImpl1();
		analizadorTitulosImpl2 = new AnalizadorTitulosImpl2();
	}

	//Clase AnalizadorTitulosImpl1
	@Test
	public void testAnalizarTituloAtractivo(){
		String titulo = "Los Locos Addams";
		Integer resultado = analizadorTitulosImpl1.analizar(titulo);
		assertEquals(1,resultado);
	}
	@Test
	public void testAnalizarTituloIndiferente(){
		String titulo = "El Padrino";
		Integer resultado = analizadorTitulosImpl1.analizar(titulo);
		assertEquals(0,resultado);
	}
	@Test
	public void testAnalizarTituloPocoAtractivo(){
		String titulo = "Titanic";
		Integer resultado = analizadorTitulosImpl1.analizar(titulo);
		assertEquals(-1,resultado);
	}
	// Fin AnalizadorTitulosImpl1

	// Clase AnalizadorTitulosImpl2
	@Test
	public void testAnalizarTituloAtractivo2() {
		String titulo = "El misterioso viaje a la isla encantada";
		Integer resultado = analizadorTitulosImpl2.analizar(titulo);
		assertEquals(1, resultado);
	}

	@Test
	public void testAnalizarTituloIndiferente2() {
		String titulo = "El puente sobre el rio Kwai";
		Integer resultado = analizadorTitulosImpl2.analizar(titulo);
		assertEquals(0, resultado);
	}

	@Test
	public void testAnalizarTituloPocoAtractivo2() {
		String titulo = "LZ 129 Hindenburg";
		Integer resultado = analizadorTitulosImpl2.analizar(titulo);
		assertEquals(-1, resultado);
	}
}
