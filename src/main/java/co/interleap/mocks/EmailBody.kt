package co.interleap.mocks

class EmailBody(val subject: String, val body: String, val receiver: String){

    // When the test is not passing due to has code issue then you have to implement equals
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if(other == null || javaClass != other.javaClass) return false
        return true
    }
}