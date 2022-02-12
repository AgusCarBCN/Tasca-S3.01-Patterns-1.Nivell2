package app;

public class TelefonoEspaña implements Telefono{
	
private String telefono;
	
	public TelefonoEspaña(String telefono) {
		this.telefono=telefono;
	}
		
	@Override
	public String getFormatTelefon() {
		
		return "+34 "+telefono;
	}

	@Override
	public void setTelefon(String telefon) {
		this.telefono=telefono;
		
	}

}
