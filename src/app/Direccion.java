package app;

public abstract class Direccion {

	
	private String street;
	private String postalCode;
	private String city;

	public Direccion( String street, String postalCode, String city) {
		
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}

	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public abstract String getFormatAddress();
}
