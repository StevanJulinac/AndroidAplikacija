package klase;

import android.os.Build;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Message implements Serializable {

    private String id;
    private Contact from;
    private Contact to;
    private ArrayList<Contact> cc;
    private ArrayList<Contact> bcc;
    private Date datumVreme;
    private String subject;
    private String content;
    private Tag tag;
    private Attachment dodatak;
    private Account akaunt;
    private Folder folder;

    public Message() {

        this.id = "";
        this.datumVreme = Calendar.getInstance().getTime();
        this.subject = "";
        this.content = "";

    }

    public Message(String subject,String content,Date datumVreme,Contact from, Contact to){

        this.subject = subject;
        this.content = content;
        this.datumVreme = datumVreme;
        this.from = from;
        this.to = to;

    }

    @Override
    public String toString() {
        return "subject=" + subject + '\'' +"from"+from.getFirstName();

    }

    public Message(String id, Contact from, Contact to, ArrayList<Contact> cc, ArrayList<Contact> bcc, Date datumVreme, String subject, String content, Tag tag, Attachment dodatak, Account akaunt, Folder folder) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.datumVreme = datumVreme;
        this.subject = subject;
        this.content = content;
        this.tag = tag;
        this.dodatak = dodatak;
        this.akaunt = akaunt;
        this.folder = folder;

    }

    public Account getAkaunt() {
        return akaunt;
    }

    public void setAkaunt(Account akaunt) {
        this.akaunt = akaunt;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Attachment getDodatak() {
        return dodatak;
    }

    public void setDodatak(Attachment dodatak) {
        this.dodatak = dodatak;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Contact getFrom() {
        return from;
    }

    public void setFrom(Contact from) {
        this.from = from;
    }

    public Contact getTo() {
        return to;
    }

    public void setTo(Contact to) {
        this.to = to;
    }

    public ArrayList<Contact> getCc() {
        return cc;
    }

    public void setCc(ArrayList<Contact> cc) {
        this.cc = cc;
    }

    public ArrayList<Contact> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<Contact> bcc) {
        this.bcc = bcc;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
