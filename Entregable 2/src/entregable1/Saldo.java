package entregable1;

/**
 * Informa el balance de una cryptomoneda particular. Traduce el balance a USD.
 */
public class Saldo implements Comparable<Saldo>{
	private String nombre = "?";
	private Double cantMonedas = 0.0;
	public Saldo(String nombre, Double cantMonedas) {
		super();
		this.nombre = nombre;
		this.cantMonedas = cantMonedas;
	}
	public Saldo() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCantMonedas() {
		return cantMonedas;
	}
	public void setCantMonedas(Double cantMonedas) {
		this.cantMonedas = cantMonedas;
	}
	public String toString(){
		String aux = (nombre +" "+cantMonedas);
		return aux;
	}
	public String ConvertirADivisa(Double cantMonedas2) {
		// Aca se convierte a pesos.
		return null;
	}
	
	@Override
	public int compareTo(Saldo s) {
		return Double.compare(s.getCantMonedas(), this.getCantMonedas());
	}
}
