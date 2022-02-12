package factories;

public class FactoryProvider {

	public static AbstractFactory<?> getFactory(String tipoFactoria) {
		AbstractFactory<?> factory=null;
		if("telefono".equals(tipoFactoria)) {
			factory= new TelefonoFactory();
		}else if("direccion".equals(tipoFactoria)) {
			factory= new DireccionFactory();
		}		
		return factory;
		
	}
}
