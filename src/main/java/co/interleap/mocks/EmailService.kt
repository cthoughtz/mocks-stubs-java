package co.interleap.mocks

interface EmailService {
    fun send(emailBody: EmailBody?)
}