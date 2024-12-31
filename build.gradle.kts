plugins {
    `java-library`
    id("geyser.build-logic")
    id("io.freefair.lombok") version "6.3.0" apply false
}

allprojects {
    group = "org.geysermc.geyser"
    version = "2.1.1-SNAPSHOT"
    description = "Allows for players from Minecraft: Bedrock Edition to join Minecraft: Java Edition servers."

    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

// Define platform-specific subprojects
val platformProjects = setOf(
    ":fabric",
    ":bungeecord",
    ":spigot",
    ":sponge",
    ":standalone",
    ":velocity"
)

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "geyser.build-logic")

    // Apply platform or base conventions
    plugins.apply(
        if (project.path in platformProjects) "geyser.platform-conventions"
        else "geyser.base-conventions"
    )
}
