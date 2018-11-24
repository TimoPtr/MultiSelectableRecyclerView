
/**
 * You should keep maximum build logic in buildSrc
 *
 * https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources
 *
 */

plugins {
    `kotlin-dsl` // To use some groovy to kotlin utilities
    groovy
    kotlin("jvm") version "1.2.61" apply false// To be able to parse the code under main/kotlin
    id("java-gradle-plugin") // To facilitate the register of the custom plugins   https://docs.gradle.org/current/userguide/java_gradle_plugin.html
}

/**
 * This block allow the declaration of the custom plugin.
 * The id is the name to use in the plugins container to apply this plugin sample:
 *
 * plugins {
 *  id("com.android.application")
 * }
 *
 * https://docs.gradle.org/current/userguide/java_gradle_plugin.html
 */
/*gradlePlugin {
    // Define the id of the custom Plugins which will be use in build.gradle (id("app-android"))
    plugins {
        create("cardioskin-android") {
                id = "app-android"
                implementationClass = "sample.AndroidPlugin"
         }
    }
}*/


repositories {
    // gradle plugins scope
    google()
    jcenter()
}


dependencies {
    // gradle plugins scope
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin") // version inject by the IDE
    implementation("com.android.tools.build:gradle:3.2.1")
}

allprojects {
    // Libraries scope
    repositories {
        google()
        jcenter()
    }
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}