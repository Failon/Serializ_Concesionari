package serializ_concesionari;
import Vehicles.Vehicle;
public class Serializ_Concesionari {

    public static void main(String[] args) {
        
        Vehicle vehiculo = new Vehicle();
        vehiculo.setMatricula("1234ccc");
        System.out.println(vehiculo.getMatricula());       
    }
}
