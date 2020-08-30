package upenn.fleamarket.demo.data;

public class Email {
  protected String senderAddress;
  protected String subject;
  protected String senderName;
  protected String body;

  public Email(String senderAddress, String subject, String senderName, String body) {
    this.body = body;
    this.subject = subject;
    this.senderName = senderName;
    this.senderAddress = senderAddress;
  }

  public Email() {
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getSenderAddress() {
    return senderAddress;
  }

  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }
}