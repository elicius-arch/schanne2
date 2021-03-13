package dhbw.fowler2.theatre;

public class TragedyPlay extends Play {

	public TragedyPlay(String name, String type) {
		super(name, type);
	}

	@Override
	public int getAmount(Performance performance) {
		int thisAmount = 40000;
        if (performance.getAudience() > 30) {
            thisAmount += 1000 * (performance.getAudience() - 30);
        }
        return thisAmount;
	}

}
