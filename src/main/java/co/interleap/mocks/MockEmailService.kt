package co.interleap.mocks

class MockEmailService: EmailService {

    private lateinit var lastSentEmail:  EmailBody

    override fun send(emailBody: EmailBody?) {
        if (emailBody != null) {
            lastSentEmail = emailBody
        }
    }

    @JvmName("getLastSentEmail1")
    fun getLastSentEmail(): EmailBody {
        return lastSentEmail
    }
}