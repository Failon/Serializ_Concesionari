package Operacions.Details;
import Vehicles.Vehicle;

public class LlogerDetall{
	double tasa_alquiler;
	Vehicle producto;
	int cantidad;
	
	public LlogerDetall(double tasa_alquiler, Vehicle producto, int cantidad) {
		this.tasa_alquiler = tasa_alquiler;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public LlogerDetall() {
		
	}
	
	public double getTasa_alquiler() {
		return tasa_alquiler;
	}
	public void setTasa_alquiler(double tasa_alquiler) {
		this.tasa_alquiler = tasa_alquiler;
	}
	public Vehicle getProducto() {
		return producto;
	}
	public void setProducto(Vehicle producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
