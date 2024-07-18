plugins {
    java
}

dependencies {
    compileOnly(libs.spigot.api)
    compileOnly(libs.bstats.bukkit)
}

java.toolchain.languageVersion = JavaLanguageVersion.of(8)
