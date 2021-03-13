package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public class WordStatementPrinter extends StatementPrinter {
	
	public WordStatementPrinter(Invoice invoice) {
		super(invoice);
	}

	@Override
	public String print() {
		var totalAmount = 0;
		var volumeCredits = 0;
		var result = String.format("Statement for %s\n", invoice.customer);

		NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

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
			result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.getAudience());
			totalAmount += thisAmount;
		}
		result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
		result += String.format("You earned %s credits\n", volumeCredits);
		return result;
	}

}
