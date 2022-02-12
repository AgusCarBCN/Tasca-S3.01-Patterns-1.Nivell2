
/**
 * Crea un petit gestor de direccions i números de telèfon internacionals.
   L'aplicació permetrà afegir a l'agenda Adreces i Números de telèfon internacionals.
   Tenint en compte els diferents formats de diversos països, construeixi l'agenda i les adreces i telèfons
    que afegeix implementant un patró Abstract Factory.
 * 
 * @author Agustin Carnerero Peña
 */


package app;

import java.util.HashMap;
import java.util.Map;

import factories.AbstractFactory;
import factories.FactoryProvider;

public class Agenda {

	public static void main(String[] args) {
		
		//HashMap donde se almacenarán los contactos ,clave será un String con el nombre y el valor un objecto
		//de la clase Contacto
		Map<String, Contacto> contactos = new HashMap<String, Contacto>();
		boolean exit = false;
		byte opcion;
		do {
			Console.writeln("*****Menu principal*****");
			Console.writeln("0.salir de la aplicacion");
			Console.writeln("1.Añadir un contacto");
			Console.writeln("2.Eliminar un contacto");
			Console.writeln("3.Buscar un contacto");
			Console.writeln("4.Actualizar telefono.");
			Console.writeln("5.Mostrar todos los contactos.");
			opcion = Console.readOptionMenu();
			switch (opcion) {
			case 0:
				System.out.println("Has salido de la aplicación");
				exit = true;
				break;
			case 1:
				addContact(contactos);
				break;
			case 2:
				deleteContact(contactos);
				break;
			case 3:
				searchContact(contactos);
				break;
			case 4:
				updateTelefon(contactos);
				break;
			case 5:
				showContacts(contactos);
				break;
			default:
				Console.writeError("Debes introducir una opción entre 0 y 5.");
				break;
			}
		} while (!exit);

	}
/**
 * Añade un contacto a la agenda
 * 
 * @param contactos Map de contactos
 */
	public static void addContact(Map<String, Contacto> contactos) {
		boolean exit = false;
		byte opcion;
		do {
			Console.writeln("****Añadir contactos*****");
			Console.writeln("Elije nacionalidad del contacto:");
			Console.writeln("1.USA");
			Console.writeln("2.España");
			Console.writeln("0.Para salir.");
			opcion = Console.readOptionMenu();
			switch (opcion) {
			case 0:
				Console.writeln("Has salido de añadir contactos");
				exit = true;
				break;
			case 1:
				createContact(Nacionalidad.USA, contactos);
				break;
			case 2:
				createContact(Nacionalidad.ESPAÑA, contactos);
				break;
			}

		} while (!exit);
	}

	/**
	 * Borra un contacto de la agenda
	 * 
	 * @param contactos Map de contactos
	 */
	public static void deleteContact(Map<String, Contacto> contactos) {
		String nombre;
		boolean encontrado;
		if (contactos.isEmpty()) {
			Console.writeError("No hay contactos en la agenda.\n");

		} else {
			nombre = Console.readName("Introduce el nombre:");
			encontrado = contactos.containsKey(nombre);
			if (!encontrado) {
				Console.writeError("No se ha encontrado ningún contacto con este nombre");
			} else {
				Console.writeln("Has borrado el contacto");
				contactos.remove(nombre);
			}
		}

	}

	/**
	 * Busca un contacto por su nombre y lista nombre dirección y telefono del
	 * contacto encontrado.
	 * 
	 * @param contactos Map de contactos
	 */	
	public static void searchContact(Map<String, Contacto> contactos) {
		String nombre;
		boolean encontrado;
		if (contactos.isEmpty()) {
			Console.writeError("No hay contactos en la agenda.\n");

		} else {
			nombre = Console.readName("Introduce un nombre:");
			encontrado = contactos.containsKey(nombre);
			if (!encontrado) {
				Console.writeError("No se ha encontrado ningún contacto con este nombre");
			} else {
				Console.writeln(contactos.get(nombre).getNombre());
				Console.writeln(contactos.get(nombre).getTelefono());
				Console.writeln(contactos.get(nombre).getDireccion());
			}
		}

	}
	
	/**
	 * 
	 * Modifica telefono de un contacto.
	 *  
	 * @param contactos Map de contactos.
	 */
	public static void updateTelefon(Map<String, Contacto> contactos) {

		String nombre;
		String nuevoTelefono;
		boolean encontrado;
		if (contactos.isEmpty()) {
			Console.writeError("No hay contactos en la agenda.\n");

		} else {
			nombre = Console.readName("Introduce el nombre:");
			encontrado = contactos.containsKey(nombre);
			if (!encontrado) {
				Console.writeError("No se ha encontrado ningún contacto con este nombre");
			} else {
				nuevoTelefono = Console.readMobil();
				contactos.get(nombre).setTelefon(nuevoTelefono);
			}
		}
	}
	
	/**
	 * Muestra todos los contactos de la agenda.
	 * 
	 * @param contactos Map de contactos.
	 */
	public static void showContacts(Map<String, Contacto> contactos) {
		if (contactos.isEmpty()) {
			Console.writeError("No hay contactos en la agenda.\n");
		}
		for (String key : contactos.keySet()) {
			Console.writeln(key);
			Console.writeln(contactos.get(key).getTelefono());
			Console.writeln(contactos.get(key).getDireccion());
			Console.writeln("------------------");
		}

	}

	/**
	 * Crea un contacto 
	 * 
	 * @param nacion Nacionalidad del contacto
	 * @param contactos Map de contactos.
	 */
	
	public static void createContact(Nacionalidad nacion, Map<String, Contacto> contactos) {

		String name;
		//Se solicita introducir el contacto a introducir en agenda.
		name = Console.readName("Introduce el nombre del contacto: ");
		//Se crea una una factoria de tipo dirección(objeto de tipo DireccionFactory.
		AbstractFactory<?> dir = FactoryProvider.getFactory("direccion");
		//Se crea un objeto de tipo Dirección de una nacionalidad elegida por usuario.
		Direccion direccion = (Direccion) dir.create(nacion);
		//Se crea una factoria de tipo telefono(objeto de tipo TelefonoFactory.
		AbstractFactory<?> tel = FactoryProvider.getFactory("telefono");
		//Se crea un objeto de tipo Telefono.
		Telefono telefono = (Telefono) tel.create(nacion);
		//Se crea un objeto de tipo contacto.
		Contacto contacto = new Contacto(name, direccion, telefono);
		//Se añade un par clave valor,clave sera nombre,obtenido con getNombre,y valor objeto de tipo contacto.
		contactos.put(contacto.getNombre(), contacto);

	}

}
