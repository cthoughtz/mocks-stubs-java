package co.interleap.mocks;

public interface UserRepository {
    User findByEmail(String email) throws NotFoundException;
}
