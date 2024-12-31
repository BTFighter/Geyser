enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        maven("https://repo.opencollab.dev/main") // Floodgate, Cumulus, etc.
        maven("https://repo.papermc.io/repository/maven-public") // Paper, Velocity
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots") { mavenContent { snapshotsOnly() } } // Spigot
        maven("https://oss.sonatype.org/content/repositories/snapshots") { mavenContent { snapshotsOnly() } } // BungeeCord
        maven("https://libraries.minecraft.net") { name = "minecraft"; mavenContent { releasesOnly() } } // Minecraft
        mavenLocal()
        mavenCentral()
        maven("https://repo.viaversion.com") { name = "viaversion" } // ViaVersion
        maven("https://repo.spongepowered.org/repository/maven-public/") // Sponge
        maven("https://jitpack.io") { content { includeGroupByRegex("com\\.github\\..*") } } // GitHub
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") // Adventure snapshots
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://repo.opencollab.dev/maven-snapshots")
    }
    plugins {
        id("net.kyori.blossom") version "1.2.0"
        id("net.kyori.indra")
        id("net.kyori.indra.git")
    }
    includeBuild("build-logic")
}

rootProject.name = "geyser-parent"

// Define subprojects
include(":ap", ":api", ":common", ":core")
include(":bungeecord", ":fabric", ":spigot", ":sponge", ":standalone", ":velocity")

// Specify project directories
mapOf(
    ":bungeecord" to "bootstrap/bungeecord",
    ":fabric" to "bootstrap/fabric",
    ":spigot" to "bootstrap/spigot",
    ":sponge" to "bootstrap/sponge",
    ":standalone" to "bootstrap/standalone",
    ":velocity" to "bootstrap/velocity"
).forEach { project, path ->
    project(project).projectDir = file(path)
}
