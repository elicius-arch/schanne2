package dhbw.fowler2.theatre;

public class Performance {

    private Play play;
    private int audience;

    public Performance(Play play, int audience) {
        this.play = play;
        this.audience = audience;
    }

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}
    
    
}
