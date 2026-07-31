plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version "2.3.20"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.prosoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Веб-слой + встроенный Tomcat + JSON (Jackson)
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Корректная (де)сериализация Kotlin-классов в JSON
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation(kotlin("reflect"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
