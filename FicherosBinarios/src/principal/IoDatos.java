package principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDatos {

	private final String RUTA = "./datos/datos.dat";

	private File fichero;
	private FileInputStream input;
	private DataInputStream lectura;
	private FileOutputStream output;
	private DataOutputStream escritura;

	public IoDatos() {
		this.fichero = new File(RUTA);
		this.input = null;
		this.lectura = null;
		this.output = null;
		this.escritura = null;

		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
			}
		}
	}

	private void abrirStreamLectura() {
		try {
			input = new FileInputStream(fichero);
			lectura = new DataInputStream(input);
		} catch (FileNotFoundException e) {
		}
	}

	private void abrirStreamEscritura() {
		try {
			output = new FileOutputStream(fichero);
			escritura = new DataOutputStream(output);
		} catch (FileNotFoundException e) {
		}
	}

	public void escribirFichero(Persona[] vPersona) {
		abrirStreamEscritura();

		for (Persona persona : vPersona) {
			if (persona != null) {
				try {
					escritura.writeUTF(persona.getNombre());
					escritura.writeInt(persona.getTelefono());
				} catch (IOException e) {
				}
			}
		}
		try {
			output.close();
			escritura.close();
		} catch (IOException e) {
		}
	}

	public Persona[] asignaEnArrayLecturaDeFichero() {
		Persona[] vPersona_2 = new Persona[5];

		abrirStreamLectura();

		for (int i = 0; i < vPersona_2.length; i++) {
			if (vPersona_2[i] == null) {
				try {
					vPersona_2[i] = new Persona(lectura.readUTF(), lectura.readInt());
				} catch (IOException e) {
				}
			}
		}
		try {
			input.close();
			lectura.close();
		} catch (IOException e) {
		}
		return vPersona_2;
	}
}
