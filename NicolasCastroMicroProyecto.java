package NicolasCastroMicroProyecto;

import javax.swing.JOptionPane;

public class NicolasCastroMicroProyecto {
	public static void main(String[] args) {
		int valorSeguro;
		// Se ingresan la marca y modelo del auto
		String marcaIngresada = JOptionPane.showInputDialog("Ingrese la marca del auto:");
		int modelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el modelo del auto:"));
		String marca = marcaIngresada.toUpperCase();
		valorSeguro = valorCotizar(modelo);
		// Se suma al valor cotizado otro valor dependiendo de la marca del auto
		if (altaGama(marca)) {
			valorSeguro = valorSeguro + 1800;
		} else {
			valorSeguro = valorSeguro + 890;
		}
		// Se muestra el valor del seguro
		JOptionPane.showMessageDialog(null, "El auto es: " + marca + " " + modelo + "\nEl valor del seguro es : $" + valorSeguro);
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
	public static int valorCotizar(int modelo) {
		int valor = 350;
		// Mediante varios If anidados se obtiene el valor cotizado en base al modelo ingresado
		// No es posible hacerlo con un Switch ya que no se puede definir un case como un rango
		if (modelo >= 1990 && modelo <= 1999)
			valor = 480;
		else if (modelo >= 2000 && modelo <= 2010)
			valor = 780;
		else if (modelo >= 2011 && modelo <= 2016)
			valor = 950;
		else if (modelo >= 2017 && modelo <= 2020)
			valor = 1200;
		return valor;
	}
}