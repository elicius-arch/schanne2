package dhbw.fowler2.theatre;

public class ComedyPlay extends Play {

	public ComedyPlay(String name, String type) {
		super(name, type);
	}

	@Override
	public int getAmount(Performance performance) {
		int thisAmount = 30000;
        if (performance.audience > 20) {
            thisAmount += 10000 + 500 * (performance.audience - 20);
        }
        thisAmount += 300 * performance.audience;
        return thisAmount;
	}

}
