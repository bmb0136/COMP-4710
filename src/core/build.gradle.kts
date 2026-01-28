plugins {
  `java-library`
}

repositories {
    mavenCentral() 
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:6.0.2")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform() 
}
