package klase;

import java.io.Serializable;

public class Account implements Serializable {

    private String id;
    private String smtp;
    private String pop3Imap;
    private String username;
    private String password;

    public Account(){
        this.id = "";
        this.smtp = "";
        this.pop3Imap = "";
        this.username = "";
        this.password = "";
    }

    public Account(String id, String smtp, String pop3Imap, String username, String password) {
        this.id = id;
        this.smtp = smtp;
        this.pop3Imap = pop3Imap;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getPop3Imap() {
        return pop3Imap;
    }

    public void setPop3Imap(String pop3Imap) {
        this.pop3Imap = pop3Imap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
