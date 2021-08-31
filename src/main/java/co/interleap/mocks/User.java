package co.interleap.mocks;

public class User {
    private final String phoneNumber;
    private final String email;
    private final String name;

    public User(String phoneNumber, String email, String name) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public String getName() { return name; }
}
