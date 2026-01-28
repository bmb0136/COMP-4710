import org.gradle.kotlin.dsl.sourceSets

plugins {
  application
  id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":core"))
  testImplementation("org.junit.jupiter:junit-jupiter:6.0.2")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}

application {
  mainClass = "io.github.bmb0136.composer.Main"
}

javafx {
  version = "21"
  modules("javafx.controls", "javafx.fxml")
}