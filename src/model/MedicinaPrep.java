package model;
public abstract class MedicinaPrep extends Paciente{
	private String numAfiliacion;
	

	public MedicinaPrep(String nombre, String apellido, int edad, String id,String numAfiliacion){
		super(nombre, apellido, edad, id);
		this.numAfiliacion=numAfiliacion;
		
	}

	public String getNumAfiliacion(){
		return numAfiliacion;
	}

	public void setNumAfiliacion(String numAfiliacion){
		this.numAfiliacion=numAfiliacion;
	}

	public String toString(){
		return super.toString()+
		"**  Numero de afiliacion: "+numAfiliacion+"\n";
	}

}