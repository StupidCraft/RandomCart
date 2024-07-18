plugins {
    java
}

dependencies {
    compileOnly(libs.spigot.api)
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
}

java.toolchain.languageVersion = JavaLanguageVersion.of(8)
