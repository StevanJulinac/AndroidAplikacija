package klase;

import java.io.Serializable;

public class Condition implements Serializable {

    private Contact to;
    private Contact from;
    private String cc;
    private String subject;

    public Condition(Contact to, Contact from, String cc, String subject) {
        this.to = to;
        this.from = from;
        this.cc = cc;
        this.subject = subject;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
