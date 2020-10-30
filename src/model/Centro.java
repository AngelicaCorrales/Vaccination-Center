package model;
public class Centro{
	public final static int MAX_PACIENTES = 300;

	private Paciente[] pacientes;

	private String nombre;

	public Centro(String nombre){
		this.nombre=nombre;
		pacientes= new Paciente[MAX_PACIENTES];
	}

	public Paciente[] getPacientes(){
		return pacientes;
	}

	public void setPacientes(Paciente[] pacientes){
		this.pacientes=pacientes;
	}

	public Paciente findPatient(String idPaciente){
		boolean found= false;
		Paciente obj=null;
		for(int i=0; i<pacientes.length && !found; i++){
			if(pacientes[i]!=null && pacientes[i].getId().equals(idPaciente)){
				obj=pacientes[i];
				found=true;
			}
		}
		return obj;
	
	}

	//particular
	public String addPatient(String nombre, String apellido, int edad, String id, String telefono,String nombreMed, String telefonoMed, String licenciaMed){
		String message="El paciente ha sido agregado exitosamente";
		boolean exit=false;
		Paciente patient =findPatient(id);
		if(patient==null){
			for(int i=0; i<pacientes.length && !exit; i++){
				if(pacientes[i]==null){
					pacientes[i]= new Particular(nombre, apellido, edad,id, telefono,nombreMed, telefonoMed, licenciaMed);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden agregar mas pacientes";
			}
		}
		else{
			message="No se ha podido agregar el paciente. Ya existe un paciente con el mismo documento de identificacion";
		}
		return message;
	}


	//eps
	public String addPatient(String nombre, String apellido, int edad, String id,String nombreEPS, int numOrden){
		String message="El paciente ha sido agregado exitosamente";
		boolean exit=false;
		Paciente patient =findPatient(id);
		if(patient==null){
			for(int i=0; i<pacientes.length && !exit; i++){
				if(pacientes[i]==null){
					pacientes[i]= new EPS(nombre, apellido, edad,id, nombreEPS, numOrden);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden agregar mas pacientes";
			}
		}
		else{
			message="No se ha podido agregar el paciente. Ya existe un paciente con el mismo documento de identificacion";
		}
		return message;
	}

	//prep-coomeva
	public String addPatient(String nombre, String apellido, int edad, String id,String numAfiliacion, String categoria){
		String message="El paciente ha sido agregado exitosamente";
		boolean exit=false;
		Paciente patient =findPatient(id);
		if(patient==null){
			for(int i=0; i<pacientes.length && !exit; i++){
				if(pacientes[i]==null){
					pacientes[i]= new Coomeva(nombre, apellido,edad,id, numAfiliacion, categoria);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden agregar mas pacientes";
			}
		}
		else{
			message="No se ha podido agregar el paciente. Ya existe un paciente con el mismo documento de identificacion";
		}
		return message;
	}
	//prep-sura
	public String addPatient(String nombre, String apellido, int edad, String id,String numAfiliacion, int[] poliza){
		String message="El paciente ha sido agregado exitosamente";
		boolean exit=false;
		Paciente patient =findPatient(id);
		if(patient==null){
			for(int i=0; i<pacientes.length && !exit; i++){
				if(pacientes[i]==null){
					pacientes[i]= new SURA(nombre, apellido,edad,id, numAfiliacion, poliza);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden agregar mas pacientes";
			}
		}
		else{
			message="No se ha podido agregar el paciente. Ya existe un paciente con el mismo documento de identificacion";
		}
		return message;
	}
	//prep- otra
	public String addPatient(String nombre, String apellido, int edad,String id, String numAfiliacion,String nombreEntidad, String telefonoEntidad){
		String message="El paciente ha sido agregado exitosamente";
		boolean exit=false;
		Paciente patient =findPatient(id);
		if(patient==null){
			for(int i=0; i<pacientes.length && !exit; i++){
				if(pacientes[i]==null){
					pacientes[i]= new OtraEntidad(nombre, apellido,edad,id, numAfiliacion, nombreEntidad, telefonoEntidad);
					exit=true;
				}
			}
			if(!exit){
				message="Lo sentimos. No se pueden agregar mas pacientes";
			}
		}
		else{
			message="No se ha podido agregar el paciente. Ya existe un paciente con el mismo documento de identidad";
		}
		return message;
	}

	public int getTotalQuantityPatients(){
	
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]==null){
				amount=i;
				control=true;
			}
			if(pacientes[MAX_PACIENTES-1]!=null){
				amount=MAX_PACIENTES;
			}
		}
		return amount;
	}

	public int getQuantityParticular(){
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				if(pacientes[i] instanceof Particular){
					amount++;
				}
			}
			else{
				control=true;
			}
		}
		return amount;
	}

	public int getQuantityEPS(){
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				if(pacientes[i] instanceof EPS){
					amount++;
				}
			}
			else{
				control=true;
			}
		}

		return amount;
	}

	public int getQuantityMedPrep(){
			int amount= getQuantityCoomeva()+getQuantitySURA()+ getQuantityOtraEntidad();

			return amount;
		}

	public int getQuantityCoomeva(){
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				if(pacientes[i] instanceof Coomeva){
					amount++;
				}
			}
			else{
				control=true;
			}
		}

		return amount;
	}

	public int getQuantitySURA(){
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				if(pacientes[i] instanceof SURA){
					amount++;
				}
			}
			else{
				control=true;
			}
		}

		return amount;
	}

	public int getQuantityOtraEntidad(){
		int amount=0;
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				if(pacientes[i] instanceof OtraEntidad){
					amount++;
				}
			}
			else{
				control=true;
			}
		}

		return amount;
	}

	public String showQuantityPatients(){
		String quantity;
		quantity="**************  Cantidad de pacientes **************\n \n"+
		"** Cantidad total de pacientes: "+ getTotalQuantityPatients()+"\n \n"+
		"** Cantidad de pacientes particulares: "+ getQuantityParticular()+"\n\n "+
		"** Cantidad de pacientes por EPS: "+ getQuantityEPS()+"\n \n"+
		"** Cantidad de pacientes por medicina prepagada: "+getQuantityMedPrep()+"\n"+
		"     *** Cantidad de pacientes Coomeva: "+ getQuantityCoomeva()+"\n"+
		"     *** Cantidad de pacientes SURA: "+ getQuantitySURA()+"\n"+
		"     *** Cantidad de pacientes de otras entidades: "+ getQuantityOtraEntidad()+"\n \n";

		return quantity;
	}

	/*
	public String showInfo(){
		String quantity="";
		boolean control=false;
		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				quantity+="**************  Paciente **************\n"+
				"**  Nombre: "+pacientes[i].getNombre()+"\n"+
				"**  Apellido: "+ pacientes[i].getApellido()+"\n"+
				"**  Edad: "+pacientes[i].getEdad()+"\n"
				"**  Documento de identidad: "+pacientes[i].getId()+"\n";

				if(pacientes[i] instanceof Particular){
					quantity+="**  Telefono: "+((Particular)pacientes[i]).getTelefono()+"\n";
				}


	}
	*/



}