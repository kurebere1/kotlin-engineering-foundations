package day01

@ConsistentCopyVisibility
data class UserSession private constructor (
    val id: String,
    val userId: String,
    val createdAt: Long,
    val permissions: List<String>
) {
    companion object {
        fun create(
            id: String,
            userId: String,
            createdAt: Long,
            permissions: List<String>
        ): UserSession {
            return UserSession(id, userId, createdAt, permissions.toList())
        }
    }
}

fun hasPermission(session: UserSession, permission: String): Boolean {
    return session.permissions.contains(permission)
}

fun withAddedPermission(session: UserSession, permission: String): UserSession {
    return UserSession.create(
        session.id,
        session.userId,
        session.createdAt,
        session.permissions + permission
    )
}