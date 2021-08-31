package co.interleap.mocks;

public class EmailBody {
    public final String subject;
    public final String body;
    public final String receiver;

    public EmailBody(String subject, String body, String receiver) {
        this.subject = subject;
        this.body = body;
        this.receiver = receiver;
    }
}
