package app;

public class TelefonoUSA implements Telefono{

	private String telefono;
	
	public TelefonoUSA(String telefono) {
		this.telefono=telefono;
	}
		
	@Override
	public String getFormatTelefon() {
		
		return "+1 "+telefono;
	}
	@Override
	public void setTelefon(String telefono) {
		this.telefono=telefono;
		
	}
}
