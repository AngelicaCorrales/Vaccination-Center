package model;
public class Particular extends Paciente{
	
	private String telefono;
	private String nombreMed;
	private String telefonoMed;
	private String licenciaMed;

	public Particular(String nombre, String apellido, int edad, String id, String telefono,String nombreMed, String telefonoMed, String licenciaMed){
		super(nombre, apellido, edad, id);
		this.telefono=telefono;
		this.nombreMed=nombreMed;
		this.telefonoMed=telefonoMed;
		this.licenciaMed=licenciaMed;
		
	}

	public String getTelefono(){
		return telefono;
	}

	public void setTelefono(String telefono){
		this.telefono=telefono;
	}

	public String getNombreMed(){
		return nombreMed;
	}

	public void setNombreMed(String nombreMed){
		this.nombreMed=nombreMed;
	}

	public String getTelefonoMed(){
		return telefonoMed;
	}

	public void setTelefonoMed(String telefonoMed){
		this.telefonoMed=telefonoMed;
	}

	public String getLicenciaMed(){
		return licenciaMed;
	}

	public void setLicenciaMed(String licenciaMed){
		this.licenciaMed=licenciaMed;
	}

	public String toString(){
		return super.toString()+ 
		"**  Telefono: "+telefono+"\n"+
		"**  Nombre del medico tratante: "+nombreMed+"\n"+
		"**  Telefono del medico tratante: "+telefonoMed+"\n"+
		"**  Numero de licencia del medico tratante: "+licenciaMed+"\n";
	}


}