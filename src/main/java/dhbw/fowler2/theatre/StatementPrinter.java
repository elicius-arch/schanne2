package dhbw.fowler2.theatre;

public abstract class StatementPrinter {
	
	protected Invoice invoice;
	
	public StatementPrinter(Invoice invoice) {
		this.invoice = invoice;
	}

	public abstract String print();

}
