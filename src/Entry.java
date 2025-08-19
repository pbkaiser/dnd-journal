import java.io.Serializable;

public class Entry implements Serializable {
    private String text;
    private int day;
    private int session;

    Entry(String text, int day, int session) {
        this.text = text;
        this.day = day;
        this.session = session;
    }
    @Override
    public String toString() {
        return text+" (day: "+day+")";
    }
    public int getDay() {
        return day;
    }
    public int getSession() {
        return session;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setSession(int session) {
        this.session = session;
    }
}
