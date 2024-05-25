plugins {
    id("java")
    id("org.flywaydb.flyway") version "10.13.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation ("org.flywaydb:flyway-core:10.13.0")
    implementation ("org.postgresql:postgresql:42.2.23")

    compileOnly ("org.projectlombok:lombok:1.18.32")
    annotationProcessor ("org.projectlombok:lombok:1.18.32")

}

flyway {
    url = ("jdbc:postgresql://localhost:5437/oleksandr-db")
    user = ("postgres")
    password = ("password")
}

tasks.test {
    useJUnitPlatform()
}