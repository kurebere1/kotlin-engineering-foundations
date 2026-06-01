package day01

data class UserSession(
    val id: String,
    val userId: String,
    val createdAt: Long,
    val permissions: List<String>
)

fun hasPermission(session: UserSession, permission: String): Boolean {
    return session.permissions.contains(permission)
}

fun withAddedPermission(session: UserSession, permission: String): UserSession {
    return session.copy(permissions = session.permissions + permission)
}