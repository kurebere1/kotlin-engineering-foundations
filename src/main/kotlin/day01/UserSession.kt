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
    return UserSession(
        id = session.id,
        userId = session.userId,
        createdAt = session.createdAt,
        permissions = session.permissions.toMutableList().also { it.add(permission) }
    )
}