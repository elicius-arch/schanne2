package dhbw.fowler2.theatre;

public abstract class Play {

	private String name;

	public Play(String name) {
		this.name = name;
	}

	public abstract int getAmount(Performance performance);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
