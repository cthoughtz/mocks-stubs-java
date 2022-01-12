package co.interleap.mocks

import kotlin.Throws

interface UserRepository {
    @Throws(NotFoundException::class)
    fun findByEmail(email: String?): User?
}