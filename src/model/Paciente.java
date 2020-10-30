package model;
public abstract class Paciente{
	private String nombre;
	private String apellido;
	private int edad;
	private String id;

	public Paciente(String nombre, String apellido, int edad, String id){
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.id=id;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}

	public String getApellido(){
		return apellido;
	}

	public void setApellido(String apellido){
		this.apellido=apellido;
	}

	public int getEdad(){
		return edad;
	}

	public void setEdad(int edad){
		this.edad=edad;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

}