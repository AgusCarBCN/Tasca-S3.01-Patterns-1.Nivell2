package app;

public class DireccionEspaña extends Direccion {

	public DireccionEspaña( String street, String postalCode, String city) {
		super(street, postalCode, city);

	}

	@Override
	public String getFormatAddress() {
		return super.getStreet() + " " + super.getPostalCode() + "\n" + super.getCity() + "\n" + "SPAIN";
	}

}
