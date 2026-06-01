import day01.UserSession
import day01.hasPermission
import day01.withAddedPermission
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class UserSessionTest : FunSpec({
    val permissions = listOf("READ")
    val session = UserSession(
        id = "s1",
        userId = "u1",
        createdAt = 1L,
        permissions = permissions,
    )

    test("returnsNewSessionInstance") {
        withAddedPermission(session, "WRITE") shouldNotBeSameInstanceAs session
    }

    test("doesNotModifyOriginalPermissionList") {
        session.permissions shouldBe permissions
    }

    test("returnsTrueWhenPermissionExists") {
        hasPermission(session, "READ") shouldBe true
    }

    test("returnsFalseWhenPermissionDoesNotExist") {
        hasPermission(session, "WRITE") shouldBe false
    }

    test("returnsFalseForEmptyPermission") {
        hasPermission(session, "") shouldBe false
    }

    test("returnsTrueWhenPermissionExistsMultipleTimes") {
        val permissions = listOf("READ", "WRITE", "WRITE")
        val session2 = UserSession(
            id = "s1",
            userId = "u1",
            createdAt = 1L,
            permissions = permissions,
        )
        hasPermission(session2, "WRITE") shouldBe true
    }

    test("returnsSessionContainingOriginalAndNewPermission") {
        withAddedPermission(session, "WRITE").permissions shouldBe listOf("READ", "WRITE")
    }

})