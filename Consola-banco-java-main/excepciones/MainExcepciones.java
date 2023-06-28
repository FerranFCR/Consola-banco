package excepciones;

import java.util.Scanner;

public class MainExcepciones {

	public static void main (String[] args) {
		Scanner teclado = new Scanner (System.in);
		System.out.print("Introduce un número: ");
		// código a intentar ejecutar
		try {
		int numeroEntero = teclado.nextInt();
		
		System.out.println("Número x 2 = " + numeroEntero * 2);
		// tratamiento de las excepciones
	} catch(Exception e) {
		System.out.println("No se puedo leer ningún número...");
		// finally se ejecuta siempre, con o sin excepción
	} finally {
		teclado.close();
	} try {int suma = pruebaExcepciones.sumar(-2,4);
	System.out.println("Resultado" + suma);}  catch(Exception e) 
	{e.printStackTrace();}
	
	// imprimir la  
	

}}
