package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;

public class HtmlStatementPrinter extends StatementPrinter {

	public HtmlStatementPrinter(Invoice invoice) {
		super(invoice);
	}

	@Override
	public String print() {
		var totalAmount = 0;
		var volumeCredits = 0;
		var result = String.format("<p>Statement for %s</p>", invoice.customer);

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
			result += String.format("<p>  <b>%s</b>: %s (%s seats)</p>", play.name, frmt.format(thisAmount / 100),
					perf.getAudience());
			totalAmount += thisAmount;
		}
		result += String.format("<p>Amount owed is %s</p>", frmt.format(totalAmount / 100));
		result += String.format("<p>You earned %s credits</p>", volumeCredits);
		return result;
	}
}
