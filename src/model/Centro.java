package model;
public class Centro{
	public final static int MAX_PACIENTES = 300;

	private Paciente[] pacientes;

	private String nombre;
	private int quantityParticular;
	private int quantityEPS;
	private int quantityCoomeva;
	private int quantitySURA;
	private int quantityOtraEntidad;

	public Centro(String nombre){
		this.nombre=nombre;
		pacientes= new Paciente[MAX_PACIENTES];
		quantityParticular=0;
		quantityEPS=0;
		quantityCoomeva=0;
		quantitySURA=0;
		quantityOtraEntidad=0;
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
					quantityParticular++;
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
					quantityEPS++;
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
					quantityCoomeva++;
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
					quantitySURA++;
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
					quantityOtraEntidad++;
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

	
	public int getTotalQuantity(){
			int amount= quantityParticular+quantityEPS+getQuantityMedPrep();

			return amount;
	}

	public int getQuantityMedPrep(){
			int amount= quantityCoomeva+quantitySURA+quantityOtraEntidad;

			return amount;
	}

	

	public String showQuantityPatients(){
		String quantity;
		quantity="\n**************  Cantidad de pacientes **************\n \n"+
		"** Cantidad total de pacientes: "+ getTotalQuantity()+"\n \n"+
		"** Cantidad de pacientes particulares: "+ quantityParticular+"\n\n "+
		"** Cantidad de pacientes por EPS: "+ quantityEPS+"\n \n"+
		"** Cantidad de pacientes por medicina prepagada: "+getQuantityMedPrep()+"\n"+
		"     *** Cantidad de pacientes Coomeva: "+ quantityCoomeva+"\n"+
		"     *** Cantidad de pacientes SURA: "+ quantitySURA+"\n"+
		"     *** Cantidad de pacientes de otras entidades: "+ quantityOtraEntidad+"\n \n";

		return quantity;
	}

	
	public String showInfoPatient(String id){
		String info="";
		Paciente pacientex=findPatient(id);
		
		if(pacientex!=null){
			
					
					if(pacientex instanceof Particular){
						info=pacientex.toString();
						
					}

					if(pacientex instanceof EPS){
						info=pacientex.toString();
					}

					if(pacientex instanceof Coomeva){
						info=pacientex.toString();
					}

					if(pacientex instanceof SURA){
						info=pacientex.toString();
					}

					if(pacientex instanceof OtraEntidad){
						info=pacientex.toString();
					}

		}
		else{
			info="** No existe el paciente";
		}
		return info;
	}

	public String showInfo(){
		String info="";
		boolean control=false;

		info+="** Nombre del centro de vacunacion: "+ nombre+"\n \n";

		for(int i=0; i<pacientes.length && !control; i++){
			if(pacientes[i]!=null){
				info+=pacientes[i].toString();
			}
			else{
				control=true;
			}
		}
		if (pacientes[0]==null){
			info+="\n**************  Paciente **************\n \n"+
			"** Aun no se han agregado pacientes \n";
		}

		info+="\n"+showQuantityPatients();

		return info;

	}
	



}