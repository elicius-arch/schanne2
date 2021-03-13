package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

	public String print(Invoice invoice, Map<String, Play> plays) {
		var totalAmount = 0;
		var volumeCredits = 0;
		var result = String.format("Statement for %s\n", invoice.customer);

		NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

		for (var perf : invoice.performances) {
			var play = plays.get(perf.playID);
			var thisAmount = 0;

			// ehemaliges switch
			thisAmount = play.getAmount(perf);

			// add volume credits
			volumeCredits += Math.max(perf.audience - 30, 0);
			// add extra credit for every ten comedy attendees
			if (ComedyPlay.class.equals(play.getClass()))
				volumeCredits += Math.floor(perf.audience / 5);

			// print line for this order
			result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(thisAmount / 100), perf.audience);
			totalAmount += thisAmount;
		}
		result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
		result += String.format("You earned %s credits\n", volumeCredits);
		return result;
	}

	public String printHtml(Invoice invoice, Map<String, Play> plays) {
		var totalAmount = 0;
		var volumeCredits = 0;
		var result = String.format("<p>Statement for %s</p>", invoice.customer);

		NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

		for (var perf : invoice.performances) {
			var play = plays.get(perf.playID);
			var thisAmount = 0;

			// ehemaliges switch
			thisAmount = play.getAmount(perf);

			// add volume credits
			volumeCredits += Math.max(perf.audience - 30, 0);
			// add extra credit for every ten comedy attendees
			if (ComedyPlay.class.equals(play.getClass()))
				volumeCredits += Math.floor(perf.audience / 5);

			// print line for this order
			result += String.format("<p>  <b>%s</b>: %s (%s seats)</p>", play.name, frmt.format(thisAmount / 100),
					perf.audience);
			totalAmount += thisAmount;
		}
		result += String.format("<p>Amount owed is %s</p>", frmt.format(totalAmount / 100));
		result += String.format("<p>You earned %s credits</p>", volumeCredits);
		return result;
	}

}
