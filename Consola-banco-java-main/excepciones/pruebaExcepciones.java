package excepciones;

public class pruebaExcepciones {



public static int sumar(int a, int b)throws Exception {
	if(a<0 || b<0) {
		throw new NumeroPositivoException ("Los números deben ser positivos");
}return a + b;}

}