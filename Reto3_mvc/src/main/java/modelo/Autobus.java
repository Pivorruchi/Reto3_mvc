package modelo;

public class Autobus {
	int Cod_bus;
	int N_plazas;
	float Consumo_km;
	String Color;

	public Autobus() {

	}

	public int getCod_bus() {
		return Cod_bus;
	}

	public void setCod_bus(int cod_bus) {
		Cod_bus = cod_bus;
	}

	public int getN_plazas() {
		return N_plazas;
	}

	public void setN_plazas(int n_plazas) {
		N_plazas = n_plazas;
	}

	public float getConsumo_km() {
		return Consumo_km;
	}

	public void setConsumo_km(float consumo_km) {
		Consumo_km = consumo_km;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

}
