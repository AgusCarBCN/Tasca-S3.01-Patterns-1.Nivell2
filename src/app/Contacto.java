package app;

public class Contacto {

private Direccion direccion;
private Telefono telefono;
private String nombre;
 
public Contacto(String nombre,Direccion direccion,Telefono telefono) {
	
	this.nombre=nombre;
	this.direccion=direccion;
	this.telefono=telefono;
}

public String getDireccion() {
	return direccion.getFormatAddress();
}

public String getTelefono() {
	return telefono.getFormatTelefon();
}
public void setTelefon(String telefono) {
	this.telefono.setTelefon(telefono);
}

public String getNombre() {
	return nombre;
}


	
}
