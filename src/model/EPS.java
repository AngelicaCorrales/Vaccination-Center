package model;
public class EPS extends Paciente{
	private String nombreEPS;
	private int numOrden;

	public EPS(String nombre, String apellido, int edad, String id,String nombreEPS, int numOrden){
		super(nombre, apellido, edad, id);
		this.nombreEPS=nombreEPS;
		this.numOrden=numOrden;
	}

	public String getNombreEPS(){
		return nombreEPS;
	}

	public void setNombreEPS(String nombreEPS){
		this.nombreEPS=nombreEPS;
	}

	public int getNumOrden(){
		return numOrden;
	}

	public void setNumOrden(int numOrden){
		this.numOrden=numOrden;
	}


}