package Operacions;
import java.util.Date;


public class Factura {
	String cliente, comercial, referencia;
	Date fechaPago;
	double precioTotal, discount, taxes;
	
	public Factura() {
	
	}

	public Factura(String cliente, String comercial, String referencia,
			Date fechaPago, double precioTotal, double discount, double taxes) {
		this.cliente = cliente;
		this.comercial = comercial;
		this.referencia = referencia;
		this.fechaPago = fechaPago;
		this.precioTotal = precioTotal;
		this.discount = discount;
		this.taxes = taxes;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
		
}
