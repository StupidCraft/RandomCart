plugins {
    java
    alias(libs.plugins.shadow)
    alias(libs.plugins.pluginyml.bukkit)
}

dependencies {
    compileOnly(libs.spigot.api)
    implementation(libs.bstats.bukkit)
    implementation(libs.paperlib)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }

    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set(null as String?)

        listOf(
            "org.bstats",
            "io.papermc.lib"
        ).forEach {
            relocate(it, "org.stupidcraft.randomcart.lib.$it")
        }
    }
}

bukkit {
    name = rootProject.name
    description = project.description
    version = project.version as String
    authors = listOf("StupidCraft", "Triassic")
    website = "https://github.com/StupidCraft/RandomCart"
    main = "org.stupidcraft.randomcart.RandomCart"
    foliaSupported = true
    apiVersion = "1.13"
}

java.toolchain.languageVersion = JavaLanguageVersion.of(8)
