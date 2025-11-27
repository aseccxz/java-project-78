plugins {
    application
    id("com.github.ben-manes.versions") version "0.53.0"
    checkstyle
    id("org.sonarqube") version "7.0.1.6134"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass = "hexlet.code.App"
}
sonar {
    properties {
        property("sonar.projectKey", "aseccxz_java-project-78")
        property("sonar.organization", "aseccxz")
    }
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }
