package dhbw.fowler2.theatre;

public abstract class Play {

    public String name;
    public String type;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public abstract int getAmount(Performance performance);
}
