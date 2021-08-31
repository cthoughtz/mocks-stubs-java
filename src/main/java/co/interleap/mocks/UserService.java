package co.interleap.mocks;

public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public void sendWelcomeEmail(String email){
        emailService.send(new EmailBody("Welcome", "Welcome to the portal", email));
    }

    public void sendRegisteredPhoneNumber(String email){
        try {
            User user = userRepository.findByEmail(email);
            EmailBody emailBody = new EmailBody("Account Details",
                    "Here is your Registered Phone Number: \n" + user.getPhoneNumber(),
                    email);
            emailService.send(emailBody);
        } catch (NotFoundException exception) {
            EmailBody emailBody = new EmailBody("Account Not Found",
                    "We do not have a registered account matching your email address",
                    email);
            emailService.send(emailBody);
        }
    }
}
