package co.interleap.mocks

class StubMockUserRepository: UserRepository {
    override fun findByEmail(email: String?): User? {
        return User("0","jamesExampleEmail@gmail.com","Existing User")
    }
}