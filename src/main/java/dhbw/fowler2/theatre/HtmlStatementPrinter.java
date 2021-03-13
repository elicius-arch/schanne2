package dhbw.fowler2.theatre;

public class HtmlStatementPrinter extends StatementPrinter {

	public HtmlStatementPrinter(Invoice invoice) {
		super(invoice);
		result = String.format("<p>Statement for %s</p>", invoice.customer);
	}

	@Override
	protected void printEnd() {
		result += String.format("<p>Amount owed is %s</p>", frmt.format(totalAmount / 100));
		result += String.format("<p>You earned %s credits</p>", volumeCredits);
		
	}

	@Override
	protected void printLineForThisOrder(Performance perf, int thisAmount) {
		result += String.format("<p><b>%s</b>: %s (%s seats)</p>", perf.getPlay().getName(), frmt.format(thisAmount / 100),
				perf.getAudience());
	}
}
