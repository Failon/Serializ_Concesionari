package Vehicles;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehicle {

	protected String matricula, marca, model, color, dataAlta;
	protected int numRodes, numPassatgers;
	protected float Potencia, alt, ample, llarg, pes;
	protected boolean alquilado; //determina si el vehiculo esta siendo o no alquilado.

    public Vehicle() {
    }
       
    public Vehicle(String matricula, String marca, String model, String color, String dataAlta, 
            int numRodes, int numPassatgers, float Potencia, float alt, float ample, float llarg, float pes, boolean alquilado) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.color = color;
        this.dataAlta = dataAlta;
        this.numRodes = numRodes;
        this.numPassatgers = numPassatgers;
        this.Potencia = Potencia;
        this.alt = alt;
        this.ample = ample;
        this.llarg = llarg;
        this.pes = pes;
        this.alquilado = alquilado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
    	//Solo se guarda la matricula si pasa el check.
    	if(checkMatricula(matricula)){
    		this.matricula = matricula;
    	}
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public int getNumRodes() {
        return numRodes;
    }

    public void setNumRodes(int numRodes) {
        this.numRodes = numRodes;
    }

    public int getNumPassatgers() {
        return numPassatgers;
    }

    public void setNumPassatgers(int numPassatgers) {
        this.numPassatgers = numPassatgers;
    }

    public float getPotencia() {
        return Potencia;
    }

    public void setPotencia(float Potencia) {
        this.Potencia = Potencia;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alt) {
        this.alt = alt;
    }

    public float getAmple() {
        return ample;
    }

    public void setAmple(float ample) {
        this.ample = ample;
    }

    public float getLlarg() {
        return llarg;
    }

    public void setLlarg(float llarg) {
        this.llarg = llarg;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }
    
    
	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	private boolean checkMatricula(String matricula){
    	boolean error; //retornaremos este error;
    	
    	//definimos los patrones que deben de cumplir las matriculas
    	Pattern patron_antiguo = Pattern.compile("(\\d{4})([a-zA-Z&&[^aeiouAEIOUqQÒ—]]{3})");
    	Pattern patron_nuevo = Pattern.compile("([a-zA-Z&&[^Ò—]]{1,2})([-]{1})(\\d{4})([-]{1})([a-zA-Z&&[^Ò—]]{2})");
    	
    	//le pasamos el match al parametro matricula para ver si cumple alguno de los 2 patrones
    	Matcher matcher_antiguo = patron_antiguo.matcher(matricula);
    	Matcher matcher_nuevo = patron_nuevo.matcher(matricula);
    	
    	//si pasa uno de los 2 devuelve true
    	if(matcher_antiguo.matches()||matcher_nuevo.matches()){
    		error = true;
    	}
    	else{ //sino pasa ninguno de los 2 devuelve false
    		error = false;
    	}
    	return error;
    }
 
}