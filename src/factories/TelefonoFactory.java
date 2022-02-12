package factories;

import java.util.Scanner;

import app.Console;
import app.Nacionalidad;
import app.Telefono;
import app.TelefonoEspaña;
import app.TelefonoUSA;

public class TelefonoFactory implements AbstractFactory<Telefono> {
	
	private String telefono;

	@Override
	public Telefono create(Nacionalidad nacion) {
		Telefono contacto = null;
		switch (nacion) {
		case ESPAÑA:			
			telefono = Console.readMobil();
			contacto = new TelefonoEspaña(telefono);
			break;
		case USA:			
			telefono = Console.readMobil();
			contacto = new TelefonoUSA(telefono);
			break;
		default:
			Console.writeError("No existe esa nacionalidad");
			break;
		}
		return contacto;
	}

}
