package model;
public class SURA extends MedicinaPrep{
	private int[] poliza;

	public SURA(String nombre, String apellido, int edad, String id,String numAfiliacion, int[] poliza){
		super(nombre, apellido, edad, id, numAfiliacion);
		this.poliza=poliza;
	}

	public int[] getPoliza(){
		return poliza;
	}

	public void setPoliza(int[] poliza){
		this.poliza=poliza;
	}
}