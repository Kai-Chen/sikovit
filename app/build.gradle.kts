plugins {
    id("sikovit.kotlin-application-conventions")
}

dependencies {
    implementation(project(":utilities"))
    implementation("no.tornado:tornadofx:1.7.20")
}

application {
    // Define the main class for the application.
    mainClass.set("sikovit.app.AppKt")
}
