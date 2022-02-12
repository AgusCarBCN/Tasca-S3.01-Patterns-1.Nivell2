package app;

public class DireccionUSA extends Direccion{	
	
	private String state;
	public DireccionUSA( String street, String postalCode, String city,String state) {
		super(street, postalCode, city);
		this.state=state;
		
	}

	@Override
	public String getFormatAddress() {
		return super.getStreet() + " " + super.getPostalCode() + "\n"  + super.getCity() + "\n" + state
				+ "\n" + "UNITED STATES";
	}

}
