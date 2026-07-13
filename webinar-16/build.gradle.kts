plugins {
    kotlin("jvm")
}

group = "com.prosoft"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2") // для @ParameterizedTest
    testImplementation("io.mockk:mockk:1.13.10")                        // для MockK
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}