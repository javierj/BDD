package dracotienda.page;

public class ShoppingPage extends Page {

	public Boolean containsSubtotal(String total) {
		String subtotal = "Subtotal: "+total+"EUR";
		return this.asText().contains(subtotal);
	}
}
