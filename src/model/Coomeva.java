package model;
public class Coomeva extends MedicinaPrep{
	Categoria categoria;

	public Coomeva(String nombre, String apellido, int edad, String id,String numAfiliacion, String categoria){
		super(nombre, apellido, edad, id, numAfiliacion);
		this.categoria=Categoria.valueOf(categoria);
	}

	public Categoria getCategoria(){
		return categoria;
	}

	public void setCategoria(Categoria categoria){
		this.categoria=categoria;
	}
}