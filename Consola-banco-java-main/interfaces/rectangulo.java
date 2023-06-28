package interfaces;

public class rectangulo implements Figura{

	private double base;
	private double altura;
	
	public rectangulo() {}

	
	
	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}


// implementamos los métodos de la interfaz para "cunmplir el contrato"
	public double calcularArea() {
		return this.base * this.altura;
	}

	public double calcularPerimetro() {
		return 2*this.base + 2*this.altura;
	}
	
}
