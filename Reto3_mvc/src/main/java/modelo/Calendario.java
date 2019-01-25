package modelo;

import java.util.Calendar;

public class Calendario {
	public String ObtenerFecha() {
		String dia = Integer.toString(Calendar.DAY_OF_MONTH);
		String mes = Integer.toString((Calendar.MONTH) + 1);
		String year = Integer.toString(Calendar.YEAR);
		String fecha = (year + "-" + mes+ "-" + dia);
		return fecha;
	}

}
