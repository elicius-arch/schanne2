package dhbw.fowler2.theatre;

public class WordStatementPrinter extends StatementPrinter {
	
	public WordStatementPrinter(Invoice invoice) {
		super(invoice);
		result = String.format("Statement for %s\n", invoice.customer);
	}
	
	@Override
	protected void printEnd() {
		result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
		result += String.format("You earned %s credits\n", volumeCredits);
	}
	
	@Override
	protected void printLineForThisOrder(Performance perf, int thisAmount) {
		result += String.format("  %s: %s (%s seats)\n", perf.getPlay().getName(), frmt.format(thisAmount / 100), perf.getAudience());
	}

}
