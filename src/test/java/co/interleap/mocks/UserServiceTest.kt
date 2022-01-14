package co.interleap.mocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserServiceTest {

    @Test
    fun shouldSendWelcomeEmail() {

        val emailService = MockEmailService()
        val userService = UserService(null,emailService)
        userService.sendWelcomeEmail(JAMES_EMAIL)
        val expectedEmail = EmailBody("Welcome", "Welcome to the portal", JAMES_EMAIL)
        val actualEmail = emailService.getLastSentEmail()
        assertEquals(expectedEmail,actualEmail)
    }

    @Test
    fun shouldSendRegisteredPhoneNumberIfUserAccountExists() {
        // Setup user repository to return the phone number 1122334 for existing@user.com
        val mockEmailService = MockEmailService()
        val mockUserRepository = StubMockUserRepository()
        val userService = UserService(mockUserRepository, mockEmailService)
        userService.sendRegisteredPhoneNumber(JAMES_EMAIL)
        val expected = EmailBody("Account Detail", "Here is your Registered PHone number: \n 4044445555", JAMES_EMAIL)
        val actual = mockEmailService.getLastSentEmail()
        assertEquals(expected,actual)
    }

    @Test
    fun sendAccountNotFoundEmailForUnregisteredUsersWhenTryingToGetRegisteredPhoneNumber() {

        val mockEmailService = MockEmailService()
        val mockUserRepository = StubMockUserRepository()
        val userService = UserService(mockUserRepository, mockEmailService)
        userService.sendRegisteredPhoneNumber(WRONG_EMAIL)
        val expected = EmailBody("Account Not Found", "We do not have a registered account matching your email address", JAMES_EMAIL)
        val actual = mockEmailService.getLastSentEmail()
        assertEquals(expected, actual)
    }

    companion object {
        const val JAMES_EMAIL = "jamesExampleEmail@gmail.com"
        const val WRONG_EMAIL = "wrongExampleEmail@gmail.com"
    }
}