package app;

public class Contacto {

private Direccion direccion;
private Telefono telefono;
private String nombre;
private String surnames;
 
public Contacto(String nombre,String surnames,Direccion direccion,Telefono telefono) {
	
	this.nombre=nombre;
	this.direccion=direccion;
	this.telefono=telefono;
	this.surnames=surnames;
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
public String getSurnames() {
return surnames;
}
	
}
