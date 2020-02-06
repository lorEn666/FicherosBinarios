package principal;

public class Main {

	public static void main(String[] args) {
		Persona[] vPersona = new Persona[5];

		vPersona[0] = new Persona("David", 600000000);
		vPersona[1] = new Persona("José", 611111111);
		vPersona[2] = new Persona("Ismael", 622222222);
		vPersona[3] = new Persona("Asier", 633333333);
		vPersona[4] = new Persona("Aitor", 644444444);

		IoDatos ioDatos = new IoDatos();

		ioDatos.escribirFichero(vPersona);

		Persona[] vPersona_2 = ioDatos.asignaEnArrayLecturaDeFichero();

		for (Persona persona : vPersona_2) {
			if (persona != null) {
				System.out.println(persona);
			}
		}
	}
}
