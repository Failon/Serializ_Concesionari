package Operacions;
import java.util.Date;
import java.util.ArrayList;
import Vehicles.Vehicle;

import Operacions.Details.LlogerDetall;

public class Lloguer extends Factura{
	Date fecha_inicio, fecha_fin;
	ArrayList<LlogerDetall> detalleAlquiler = new ArrayList<LlogerDetall>();
	
	public Lloguer(String cliente, String comercial, String referencia,
			Date fechaPago, double precioTotal, double discount, double taxes,
			Date fecha_inicio, Date fecha_fin,
			ArrayList<LlogerDetall> detalleAlquiler) {
		super(cliente, comercial, referencia, fechaPago, precioTotal, discount,
				taxes);
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.detalleAlquiler = detalleAlquiler;
	}

	public Lloguer() {
		super();
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public ArrayList<LlogerDetall> getDetalleAlquiler() {
		return detalleAlquiler;
	}

	public void setDetalleAlquiler(ArrayList<LlogerDetall> detalleAlquiler) {
		this.detalleAlquiler = detalleAlquiler;
	}
	
	public int addLine(String detalle, Vehicle vehiculo){ //anyadir una linea
		int error; //devolvera 0 si tiene exito o -1 sino tiene exito.
		String[] detalle_seccionado = detalle.split(";"); //separo el detalle por ;
		double precio_aux = Double.parseDouble(detalle_seccionado[0]); //guardo el primer valor que será el precio
		int cantidad = Integer.parseInt(detalle_seccionado[1]);//guardo el segundo valor que será la cantidad
		
		LlogerDetall detalle_aux = new LlogerDetall(precio_aux, vehiculo, cantidad); //monto un LlogerDetall auxiliar.
		String Matricula = vehiculo.getMatricula();
		int tamany = detalleAlquiler.size(), flag=0;
		for(int cont = 0; cont<tamany & flag==0;cont++){
			String matricula_aux = detalleAlquiler.get(cont).getProducto().getMatricula();
			if(matricula_aux.equals(Matricula)){
				flag = 1;
				updateLine(detalle,Matricula);//si ya existia la linea con el producto, actualizo en vez de anyadir.
				detalleAlquiler.get(cont).getProducto().setAlquilado(true);//lo marco como alquilado.
				error = 0;
			}
		}
		if(flag==0){
		if(detalleAlquiler.add(detalle_aux)) error = 0; //anyado al arrayList si tengo exito devuelvo 0.
		else error = -1; //Y sino lo tengo devuelvo -1.			
		}
		else error = 0;

		
		return error;
	}
	
	public String getLine(String matricula){
		int tamany = detalleAlquiler.size(), flag=0; // determino el tamanyo del arraylist
		String detalle = ""; //El detalle que devolveré por defecto está vacio.
		for(int cont = 0;cont<tamany&&flag==0;cont++){ //recorro el arraylist en busca de un match a la matricula del vehiculo introducida por parametro.
			String matricula_aux = detalleAlquiler.get(cont).getProducto().getMatricula(); //guardo la matricula de la linea.
			if(matricula_aux.equals(matricula)){ //si coinciden
				flag = 1; //dejo de buscar
				String precio = Double.toString(detalleAlquiler.get(cont).getTasa_alquiler());
				String cantidad = Integer.toString(detalleAlquiler.get(cont).getCantidad());
				detalle = precio+matricula+cantidad;//concateno el detalle.
			}
		}
		return detalle; //devuelvo el detalle.
	}
	
	public int delLine(String matricula){
		int tamany = detalleAlquiler.size(), flag=0, error; //determino el tamanyo del arraylist
		for(int cont=0;cont<tamany && flag==0;cont++){
			String matricula_aux = detalleAlquiler.get(cont).getProducto().getMatricula(); //guardo la matricula de la linea.
			if(matricula_aux.equals(matricula)){
				flag=1;//dejo de buscar
				detalleAlquiler.get(cont).getProducto().setAlquilado(false);//si borro la linea deja de estar alquilado.
				detalleAlquiler.remove(cont);
			}
		}
		if(flag==0){
			error = -1;//si no ha encontrado ningun vehiculo con esa matricula, no ha borrado nada y devuelve -1.
		}
		else{
			error = 0;//si ha borrado algo devuelve 0.
		}
		return error;
	}
	
	public int updateLine(String detalle, String matricula){
		int tamany = detalleAlquiler.size(), flag=0, error; //determino el tamanyo del arraylist
		String[] detalle_seccionado = detalle.split(";"); //separo el detalle por ;
		double precio_aux = Double.parseDouble(detalle_seccionado[0]); //guardo el primer valor que será el precio
		int cantidad = Integer.parseInt(detalle_seccionado[1]);//guardo el segundo valor que será la cantidad
		for(int cont=0;cont<tamany && flag==0;cont++){
			String matricula_aux = detalleAlquiler.get(cont).getProducto().getMatricula(); //guardo la matricula de la linea.
			if(matricula_aux.equals(matricula)){//si hay un match
				flag = 1; //dejo de buscar
				detalleAlquiler.get(cont).setCantidad(cantidad); //actualizo la cantidad
				detalleAlquiler.get(cont).setTasa_alquiler(precio_aux); //actualizo el precio
				detalleAlquiler.get(cont).getProducto().setAlquilado(true);
			}
		}
		if(flag==1){
			error = 0;
		}
		else{
			error = -1;
		}
		
		return error;
		
	}
	
	
}
