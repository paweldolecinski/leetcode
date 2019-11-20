plugins {
    java
}

group = "pl.dolecinski.leetcode"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    jcenter()
}

dependencies {
    testImplementation("junit:junit:4.12")
}
