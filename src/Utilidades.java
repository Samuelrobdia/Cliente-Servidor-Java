import java.util.Scanner;

public class Utilidades {

	public static String pedirTexto(String mensaje) {
		String texto = "";
		boolean error = false;
		Scanner scan = new Scanner(System.in);
		do {
			error = false;
			try {
				System.out.println(mensaje);
				texto = scan.nextLine();
			} catch (Exception e) {
				System.out.println("Valor incorrecto, introduce de nuevo");
				error = true;
			}
		} while (error);
		return texto;
	}

	public static int pedirEntero(String mensaje) {
		int entero = 0;
		boolean error = false;
		Scanner scan = new Scanner(System.in);
		do {
			error = false;
			try {
				System.out.print(mensaje);
				entero = Integer.parseInt(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Valor incorrecto, introduce de nuevo");
				error = true;
			}
		} while (error);
		return entero;
	}

	public static float pedirFloat(String mensaje) {
		float doble = 0;
		boolean error = false;
		Scanner scan = new Scanner(System.in);
		do {
			error = false;
			try {
				System.out.print(mensaje);
				doble = Float.parseFloat(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Valor incorrecto, introduce de nuevo");
				error = true;
			}
		} while (error);
		return doble;
	}

	public static boolean pedirBoolean(String mensaje) {
		boolean booleano = true;
		boolean error = false;
		Scanner scan = new Scanner(System.in);
		do {
			error = false;
			try {
				System.out.print(mensaje);
				booleano = Boolean.parseBoolean(scan.nextLine());
			} catch (Exception e) {
				System.out.println("Valor incorrecto, introduce de nuevo");
				error = true;
			}
		} while (error);

		return booleano;
	}

	public static char pedirChar(String mensaje) {
		char character = ' ';
		boolean error = false;
		Scanner scan = new Scanner(System.in);

		do {
			error = false;
			try {
				System.out.print(mensaje);
				String linea = scan.nextLine();
				character = linea.charAt(0);
			} catch (Exception e) {
				System.out.println("Valor incorrecto, introduce de nuevo");
				error = true;
			}
		} while (error);
		return character;
	}
}
