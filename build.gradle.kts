plugins {
    // Ensure AP works in eclipse (no effect on other IDEs)
<<<<<<< HEAD
    `eclipse`
    id("geyser.build-logic")
    id("io.freefair.lombok") version "6.3.0" apply false
}



java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}

val platforms = setOf(
    projects.standalone
).map { it.dependencyProject }

subprojects {
    apply {
        plugin("java-library")
        plugin("io.freefair.lombok")
        plugin("geyser.build-logic")
    }

    when (this) {
        in platforms -> plugins.apply("geyser.platform-conventions")
        else -> plugins.apply("geyser.base-conventions")
    }
=======
    eclipse
    id("geyser.base-conventions")
>>>>>>> parent of 5255b844e (Upload old version)
}
