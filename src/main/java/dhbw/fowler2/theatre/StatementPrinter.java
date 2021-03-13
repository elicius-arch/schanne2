package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class StatementPrinter {
	
	protected Invoice invoice;
	protected int totalAmount = 0;
	protected int volumeCredits = 0;
	protected String result;
	protected NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
	
	public StatementPrinter(Invoice invoice) {
		this.invoice = invoice;
	}

	public String print() {

		for (var perf : invoice.performances) {
			var play = perf.getPlay();
			var thisAmount = 0;

			// ehemaliges switch
			thisAmount = play.getAmount(perf);

			// add volume credits
			volumeCredits += Math.max(perf.getAudience() - 30, 0);
			// add extra credit for every ten comedy attendees
			if (ComedyPlay.class.equals(play.getClass()))
				volumeCredits += Math.floor(perf.getAudience() / 5);

			// print line for this order
			printLineForThisOrder(perf, thisAmount);
			totalAmount += thisAmount;
		}
		printEnd();
		return result;
	}
	
	protected abstract void printEnd();

	protected abstract void printLineForThisOrder(Performance perf, int thisAmount);
}
