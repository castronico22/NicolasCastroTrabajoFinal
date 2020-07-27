package NicolasCastroTrabajoFinal;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class NicolasCastroTrabajoFinal {
	public static void main(String[] args) {
		// Si la funcion login devuelve false, no ejecuta el codigo
		if (!login())
			return;
		JTextField marcaIngresada = new JTextField();
		JComboBox<String> modeloIngresado = new JComboBox<>();
		String marca = "";
		int modelo = 0;
		boolean modeloAnterior = false;

		// Se agregan al ComboBox los valores del modelo
		modeloIngresado.addItem("Anterior a 1990");
		for (int i = 1990; i <= 2020; i++) {
			modeloIngresado.addItem(Integer.toString(i));
		}
		Object[] ingresarMarcaModelo = { "Marca: ", marcaIngresada, "Modelo: ", modeloIngresado };
		int ingresarDatos = JOptionPane.showConfirmDialog(null, ingresarMarcaModelo, "Ingresar marca y modelo del auto",
				JOptionPane.OK_CANCEL_OPTION);
		if (ingresarDatos == JOptionPane.OK_OPTION) {
			marca = marcaIngresada.getText().toUpperCase();
			if (modeloIngresado.getSelectedItem().equals("Anterior a 1990")) {
				// En el caso de que se seleccione Anterior a 1990, pasa modeloAnterior a true
				modeloAnterior = true;
			} else {
				// Sino, se convierte el valor String a Integer para calcular el valor cotizado
				modelo = Integer.parseInt((String) modeloIngresado.getSelectedItem());
			}
			int valorSeguro = valorCotizar(modelo, modeloAnterior);
			// Se suma al valor cotizado otro valor dependiendo de la marca del auto
			if (altaGama(marca)) {
				valorSeguro = valorSeguro + 1800;
			} else {
				valorSeguro = valorSeguro + 890;
			}
			// Se muestra el valor del seguro
			JOptionPane.showMessageDialog(
					null, "El auto es: " + marca + " " + modeloIngresado.getSelectedItem()
							+ "\nEl valor del seguro es : $" + valorSeguro,
					"Cotizador de Seguros", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// Funcion que devuelve si el auto es alta gama
	public static boolean altaGama(String marca) {
		boolean esAltaGama = false;
		// Se define en un array las marcas consideradas alta gama
		String marcaAltaGama[] = { "BMW", "AUDI", "VOLVO" };
		// Se busca el auto ingresado dentro del array
		for (String indice : marcaAltaGama) {
			if (indice.equals(marca)) {
				esAltaGama = true;
			}
		}
		return esAltaGama;
	}

	// Funcion que devuelve la cotizacion del seguro segun el modelo del auto
	public static int valorCotizar(int modelo, boolean modeloAnterior) {
		int valor = 0;
		if (modeloAnterior)
			valor = 350;
		else if (modelo >= 1990 && modelo <= 1999)
			valor = 480;
		else if (modelo >= 2000 && modelo <= 2010)
			valor = 780;
		else if (modelo >= 2011 && modelo <= 2016)
			valor = 950;
		else if (modelo >= 2017 && modelo <= 2020)
			valor = 1200;
		return valor;
	}

	// Funcion de login con 2 o mas usuarios
	public static boolean login() {
		// DB
		String[] usr = { "NICOLAS", "CELESTE" };
		String[] pass = { "cerveza", "fernet" };
		String usrAuth = "";
		boolean auth = false;
		int intentos = 1;

		do {
			JTextField usuario = new JTextField();
			JTextField password = new JPasswordField();
			Object[] ingresarUsuarioPassword = { "Usuario: ", usuario, "Password", password };
			int ingresarLogin = JOptionPane.showConfirmDialog(null, ingresarUsuarioPassword,
					"Ingrese credenciales de usuario", JOptionPane.OK_CANCEL_OPTION);
			if (ingresarLogin == JOptionPane.OK_OPTION) {
				// Busca el usuario en un bucle For
				for (int i = 0; i < usr.length; i++) {
					// Si encuentra el usuario, verifica si el usuario y la contraseña coinciden
					if (usr[i].equals(usuario.getText().toUpperCase()) && pass[i].equals(password.getText())) {
						usrAuth = usr[i];
						auth = true;
					}
				}
				// Si no coincide, suma 1 intento y vuelve a pedir credenciales
				if (!auth) {
					JOptionPane.showMessageDialog(null, "Usuario y/o Password incorrecto",
							"Usuario y/o Password incorrecto", JOptionPane.WARNING_MESSAGE);
					intentos++;
				}
			} else {
				// Cierra si no se selecciona OK
				break;
			}
		} while (!auth & (intentos <= 3));
		// Si autentica, muestra mensaje de bienvenida
		if (auth) {
			JOptionPane.showMessageDialog(null, "Bienvenido " + usrAuth, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
			// Sino, muestra mensaje de numero de intentos superados y se cierra
		} else if (intentos > 3) {
			JOptionPane.showMessageDialog(null, "Se supero en numero de intentos", "Se supero en numero de intentos",
					JOptionPane.WARNING_MESSAGE);
		}
		return auth;
	}
}