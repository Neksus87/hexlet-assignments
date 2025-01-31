plugins {
    id("com.github.ben-manes.versions") version "0.48.0"
    application
    id("io.freefair.lombok") version "8.6"
}

application {
    mainClass.set("exercise.App")
}

group = "exercise"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:6.1.3")
    implementation("gg.jte:jte:3.1.16") // Подключение JTE
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("net.datafaker:datafaker:2.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("org.projectlombok:lombok:1.18.20") // Для использования Lombok

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.23.1")
}
