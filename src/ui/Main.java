package ui;
import java.util.Scanner;
import model.Centro;
public class Main{

	private Centro centro;
	private Scanner sc;

	public Main(){
		sc= new Scanner(System.in);
		createCenter();
	}

	public static void main(String [] args){
		Main objMain= new Main();
		int option;
		do{
			option=objMain.showMenu();
			objMain.chosenOption(option);
		}while(option!=5);
		
	}

	public int showMenu(){
		System.out.println("Seleccione una opcion:\n"+
				"(1) Agregar un nuevo paciente\n"+
				"(2) Mostrar la cantidad de pacientes \n"+
				"(3) Mostrar informacion de un paciente\n"+
				"(4) Mostrar toda la informacion del centro \n"+
				"(5) Salir");
		int option= sc.nextInt();
		return option;
	}

	public void chosenOption(int op) {
		
		switch(op) {
		case 1:
			addPatient();
			break;
		case 2:
			//showQuantityPatients();
			break;
		case 3:
			//showInfoPatient();
			break;
		case 4:
			//showInfo();
			break;
		case 5:
			System.out.println("\nHasta la proxima!");
			break;
			
		default:
			System.out.println("\n Error, opcion no valida \n");
		
		}
	}

	public void addPatient(){
		sc.nextLine();
		System.out.println("-----------------------------------------------------------");
		System.out.println("AGREGAR NUEVO PACIENTE \n");
		int edad;
		String message="";
		boolean error;
		int option;
		
		System.out.println("Ingrese el nombre del paciente");
		String nombre=sc.nextLine();
		
		System.out.println("\nIngrese el apellido del paciente");
		String apellido=sc.nextLine();
		
		do{
			System.out.println("\nIngrese la edad del paciente");
			edad=sc.nextInt();
			if(edad<0 ||edad>130){
				System.out.println("\n No valido");
			}
		}while(edad<0 ||edad>130);

		sc.nextLine();
		System.out.println("\nIngrese el documento de identidad del paciente");
		String id=sc.nextLine();


		do{
			error=false;
			System.out.println("\nSeleccione el tipo de paciente:\n"+
				"(1) Particular\n"+
				"(2) Por EPS \n"+
				"(3) Por medicina prepagada");
			option= sc.nextInt();
			sc.nextLine();
								
			
			switch(option){
				case 1:

					System.out.println("\nIngrese un telefono de contacto del paciente");
					String telefono=sc.nextLine();

					System.out.println("\nIngrese el nombre del medico tratante");
					String nombreMed=sc.nextLine();

					System.out.println("\nIngrese el telefono del medico tratante");
					String telefonoMed=sc.nextLine();

					System.out.println("\nIngrese el numero de licencia del medico tratante");
					String licenciaMed=sc.nextLine();

					message=centro.addPatient(nombre, apellido, edad,id, telefono,nombreMed, telefonoMed, licenciaMed);
					break;


				case 2:
					System.out.println("\nIngrese el nombre de la EPS");
					String nombreEPS=sc.nextLine();

					System.out.println("\nIngrese el numero de la orden de servicio");
					int numOrden=sc.nextInt();

					message=centro.addPatient(nombre, apellido, edad,id, nombreEPS, numOrden);
					break;


				case 3:
					System.out.println("\nIngrese el numero de afiliacion");
					String numAfiliacion=sc.nextLine();

					do{
						error=false;
						System.out.println("\nSeleccione la entidad prestadora de salud:\n"+
							"(1) Coomeva\n"+
							"(2) SURA \n"+
							"(3) Otra entidad");
						option= sc.nextInt();
						

						switch(option){
							case 1:
								boolean control;
								String categoria;
								sc.nextLine();
								do{
									System.out.println("\nIngrese la categoria del paciente (PLATINO, ORO, ORO PLUS)");
									categoria=sc.nextLine().toUpperCase();

									if(categoria.equals("ORO PLUS"))
										categoria="OROPLUS";

									if(categoria.equals("PLATINO") || categoria.equals("ORO") || categoria.equals("OROPLUS")){
										control=false;
									}
									else{
										System.out.println("No valido");
										control=true;
									}
								}while(control);

								message= centro.addPatient(nombre, apellido,edad,id, numAfiliacion, categoria);
								break;


							case 2:
								int[] poliza= new int[2];

								System.out.println("\nIngrese el valor minimo del rango de cubrimiento de la poliza");
								poliza[0]=sc.nextInt();

								System.out.println("\nIngrese el valor maximo del rango de cubrimiento de la poliza");
								poliza[1]=sc.nextInt();

								message= centro.addPatient(nombre, apellido,edad,id, numAfiliacion, poliza);
								break;


							case 3:
								sc.nextLine();
								System.out.println("\nIngrese el nombre de la entidad");
								String nombreEntidad=sc.nextLine();

								System.out.println("\nIngrese el telefono de la entidad");
								String telefonoEntidad=sc.nextLine();

								message= centro.addPatient(nombre, apellido,edad,id, numAfiliacion, nombreEntidad, telefonoEntidad);
								break;


							default:
								System.out.println("\n Error, opcion no valida \n");
								error=true;
						}
					}while(error);

					break;
				
				default:
				System.out.println("\n Error, opcion no valida \n");
				error=true;
			
			}
		}while(error);

		System.out.println("-----------------------------------------------------------");
		System.out.println(message);
		System.out.println("-----------------------------------------------------------");
	}

	public void createCenter(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("CENTRO DE VACUNACION \n");
		System.out.println("Ingrese el nombre del dentro de vacunacion");
		String name=sc.nextLine().toUpperCase();
		centro=new Centro(name);
	}

}