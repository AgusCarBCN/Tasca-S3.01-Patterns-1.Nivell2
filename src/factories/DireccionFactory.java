package factories;

import app.Console;
import app.Direccion;
import app.DireccionEspaña;
import app.DireccionUSA;
import app.Nacionalidad;

public class DireccionFactory implements AbstractFactory<Direccion> {	
	private Direccion direccion;
	private String state;
	private String street;
	private String postalCode;
	private String city;	

	@Override
	public Direccion create(Nacionalidad nacion) {

		switch (nacion) {
		case ESPAÑA:
			
			street =Console.read("calle: ");			
			postalCode =Console.read("Código postal: ");
			city=Console.read("ciudad: ");			
			direccion = new DireccionEspaña(street, postalCode, city);
			break;
		case USA:
			
			street =Console.read("calle: ");			
			postalCode =Console.read("Código postal: ");
			city=Console.read("ciudad: ");			
			state=Console.read("estado: ");
			direccion = new DireccionUSA(street, postalCode, city,state);
			break;
		default:
			System.err.println("No existe esa nacionalidad");
			break;
		}
		return direccion;
	}
}
