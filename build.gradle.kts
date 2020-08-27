plugins {
    kotlin("jvm") version "1.4.0"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

group = "com.github.parangee"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://jitpack.io/")
}

dependencies {
    compileOnly(kotlin("stdlib"))
    compileOnly(kotlin("reflect"))
    compileOnly("com.destroystokyo.paper:paper-api:1.16.2-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    processResources {
        filesMatching("**/*.yml") {
            expand(project.properties)
        }
    }

    shadowJar {
        archiveClassifier.set("dist")
    }

    create<Copy>("distJar") {
        from(shadowJar)
        into("G:\\servers\\amongus\\plugins")
    }
}
