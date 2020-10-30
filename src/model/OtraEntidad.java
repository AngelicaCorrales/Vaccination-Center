package model;
public class OtraEntidad extends MedicinaPrep{
	private String nombreEntidad;
	private String telefonoEntidad;

	public OtraEntidad(String nombre, String apellido, int edad, String id,String numAfiliacion,String nombreEntidad, String telefonoEntidad){
		super(nombre, apellido, edad, id,numAfiliacion);
		this.nombreEntidad=nombreEntidad;
		this.telefonoEntidad=telefonoEntidad;
	}

	public String getNombreEntidad(){
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad){
		this.nombreEntidad=nombreEntidad;
	}

	public String getTelefonoEntidad(){
		return telefonoEntidad;
	}

	public void setTelefonoEntidad(String telefonoEntidad){
		this.telefonoEntidad=telefonoEntidad;
	}

	public String toString(){
		return super.toString()+
		"**  Nombre de la entidad: "+nombreEntidad+"\n"+
		"** Telefono de la entidad: "+telefonoEntidad+"\n";
	}
}