package lonja;

public class Lonjamatic {

	private static final Integer GASTO_CARGA = 5;
	private PreciosLonja precios;
	private DistanciaCiudades distancias;

	public Lonjamatic(PreciosLonja precios, DistanciaCiudades distancias) {
		this.precios = precios;
		this.distancias = distancias;
	}
	
	public Integer beneficiosDeVenta(Carga carga, String ciudad) {
		Integer costes = costesDeVenta(ciudad);
		Integer ingresos = ingresosDeVenta(carga, ciudad);
		
		return ingresos - costes;
	}

	private Integer costesDeVenta(String ciudad) {
		Integer distancia = this.distancias.hasta(ciudad);
		Integer gastoViaje = distancia * 2;
		return gastoViaje + GASTO_CARGA;
	}
	
	private Integer ingresosDeVenta(Carga carga, String ciudad) {
		Integer ingresosVieira = calcularIngresosVieiras(carga, ciudad);
		Integer ingresosPulpo = calcularIngresosPulpo(carga, ciudad);
		Integer ingresosCentollo = this.precios.centolloEn(ciudad)
				 * carga.getKilosCentollo();
		
		return ingresosVieira + ingresosPulpo + ingresosCentollo;
	}

	private int calcularIngresosPulpo(Carga carga, String ciudad) {
		if ((ciudad.compareToIgnoreCase("Lisboa") == 0) 
				&& (carga.getKilosCentollo() > 70)) {
			return 0;
		}
		return this.precios.pulpoEn(ciudad)
				 * carga.getKilosPulpo();
	}

	private int calcularIngresosVieiras(Carga carga, String ciudad) {
		if ((ciudad.compareToIgnoreCase("Madrid") == 0) && 
				(carga.getKilosVieiras() < 51)) {
			return 0;
		}
		return this.precios.vieiraEn(ciudad) * carga.getKilosVieiras();
	}
	
}
