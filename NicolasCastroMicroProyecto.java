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
		JOptionPane.showMessageDialog(null, "El valor del seguro es : $" + valorSeguro);
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
		int i = 0;
		int valor;
		// Se genera un indice mediante condicionales If en base al modelo ingresado
		if (modelo >= 1990 && modelo <= 1999)
			i = 1;
		if (modelo >= 2000 && modelo <= 2010)
			i = 2;
		if (modelo >= 2011 && modelo <= 2016)
			i = 3;
		if (modelo >= 2017 && modelo <= 2020)
			i = 4;
		// Se utiliza condicional Switch para definir el valor cotizado 
		switch (i) {
			case 1:
				valor = 480;
				break;
			case 2:
				valor = 780;
				break;
			case 3:
				valor = 950;
				break;
			case 4:
				valor = 1200;
				break;
			default:
				valor = 350;
				break;
		}
		return valor;
	}
}