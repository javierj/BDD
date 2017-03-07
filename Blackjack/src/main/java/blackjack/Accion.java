package blackjack;

public interface Accion {

	void resuelveAccion(Mesa mesa);

	Boolean esPlantarse();

	boolean pideCarta();

}
