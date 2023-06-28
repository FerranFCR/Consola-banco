package interfaces;

public class Triangulo implements Figura{

	private double base;
	private double altura;
	
	public Triangulo() {}
		
		
	
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
		
		
		
		
	public double calcularArea() {
		return this.base * this.altura / 2;
	}

	
	public double calcularPerimetro() {
		return this.base * this.altura;
	
}

	}
	

