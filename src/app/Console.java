package app;

import java.util.Scanner;

/**
 * La clase Console contiene métodos que permiten introducir datos desde el
 * teclado y verificar que cumplen con un formato determinado.
 * 
 * @author Agustin Carnerero Peña
 *
 */
public class Console {
	private static Scanner enter = new Scanner(System.in);
	private static boolean verify = false;
	private static String intro = "";
	private static byte entero8Bits = 0;
	private Console() {
	};

	/**
	 * Imprime un objeto y salta una linea.
	 * 
	 * @param object Objeto que se le pasa como parametro.
	 */
	public static void writeln(Object object) {
		System.out.println(object);
	}

	/**
	 * Imprime un objeto y no salta de línea.
	 * 
	 * @param object Objeto que se le pasa como parametro.
	 */
	public static void write(Object object) {
		System.out.print(object);
	}

	/**
	 * Imprime un mensaje de error.
	 * 
	 * @param message Retorna un mensaje de error
	 */
	public static void writeError(String message) {
		System.err.println(message);
		System.out.println("");
	}

	/**
	 * Método que permite leer un string desde el teclado.No hay restricciones de
	 * carácteres.
	 * 
	 * @param message Mensaje que aparecerá antes de introducir la cadena.
	 * 
	 * @return Retorna un cadena de carácteres.
	 */
	public static String read(String message) {
		write(message);
		intro = enter.nextLine();
		return intro;
	}

	/**
	 * Método que pide que se introduzca un nombre y valida la entrada ,con una
	 * expresión regular, que la cadena comience por una letra mayúscula y las
	 * siguienes seán carácteres o letras minúsculas. Si verify es false muestra
	 * mensaje de error y se pide volver a introducir la cadena,hasta que se
	 * introduzca correctamente. Un nombre valido sería por ejemplo ,Pedro. Uno no
	 * valido sería pedro,ya que empieza por una letra minúscula.
	 * 
	 * @param message Mensaje que ser verá antes de introducir el nombre.Debe ser
	 *                introducido como argumento.
	 * 
	 * @return Retorna una cadena si el nombre introducido es correcto.
	 */
	public static String readName() {

		do {
			write("Introduce el nombre del contacto: ");
			intro = enter.nextLine();
			verify = intro.matches("[A-Z,Ñ]{1}[A-Z,a-z,ñ,\\s]{1,20}");
			if (!verify) {
				writeError("Error al introducir el nombre.");
				writeError("El nombre ha de comenzar en mayúsculas seguido de minúsculas.");
				writeError("Ejemplo: Agustin");
			}
		} while (!verify);
		return intro;
	}

	/**
	 * Método que pide que se introduzcan los apellidosy valida si cumple con el
	 * formato establecido por la expresión regular.Los dos apellidos deben empezar
	 * por mayúsculas seguido de minúsculas y un espacio en blanco entre ellos. Un
	 * ejemplo de introducción de apellidos validos sería:
	 * 
	 * Perez Gonzalez (ambos empienzan por mayúsculas ,seguidos de minúsculas,y con
	 * un espacio en blanco entre ellos.
	 * 
	 * @return Retorna los apellidos introducidos por el teclado si la validación es
	 *         correcta.
	 */
	public static String readSurnames() {
		String intro = "";
		boolean verify = false;

		do {
			write("Introduce los apellidos del contacto: ");
			intro = enter.nextLine();
			verify = intro.matches("[A-Z,Ñ]{1}[a-z,ñ]{1,20}[\\s]{1}+[A-Z,Ñ]{1}[a-z,ñ]{1,20}");
			if (!verify) {
				writeError("Error al introducir los apellidos.");
				writeError("Los apellidos han de empezar por mayúscula seguido de minúsculas.");
				writeError("Con un espacio en blanco entre apellidos.");
				writeError("ejemplo: Carnerero Peña");
			}
		} while (!verify);
		return intro;
	}

	/**
	 * Método que pide el número de un movil por teclado y valida que lo se ha
	 * introducido sea un móvil.
	 * 
	 * Ejemplo:600122191
	 * 
	 * @parram code Código internacional del móvil que se concatenará al movil
	 *         introducido. Ejemplo:"35".
	 * 
	 * @return Retorna una Objeto Telefono con el movil introducido por teclado con
	 *         el código internacional pasado como argumento.Retorna +35 600122191.
	 *         *
	 * 
	 */
	public static String readMobil() {

		do {
			write("Introduce el número de telefono: ");
			intro = enter.nextLine();
			verify = intro.matches("[0-9]{3,15}");
			if (!verify) {
				writeError("Error al introducir movil");

			}
		} while (!verify);
		return intro;
	}

	/**
	 * Método que pide un número de tipo byte que representa una opción de un
	 * menú.Valida que sea un byte positivo.
	 * 
	 * @return Retorna un número byte positivo si la validación es correcta.
	 */
	public static byte readOptionMenu() {
		verify = false;

		do {
			writeln("Introduce una opcion: ");
			if (enter.hasNextByte()) {
				entero8Bits = enter.nextByte();
				enter.nextLine();
				verify = true;
			} else {
				enter.nextLine();
				writeError("Debes introducir un número.");
			}
		} while (!verify);
		return entero8Bits;
	}

}
