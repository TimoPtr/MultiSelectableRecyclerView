import timoptr.multiselectablelist.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId ="timoptr.multiselectablelist"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(Libs.kotlin)

    implementation(Libs.designLib)
    implementation(Libs.supportV4)
    implementation(Libs.appCompatLib)
    implementation(Libs.constraintLayout)
    implementation(Libs.pagingLib)

    add("testImplementation" , Libs.jUnit)
    add("androidTestImplementation", Libs.testRunner)
    add("androidTestImplementation", Libs.testExtJunit) {
        exclude(module = "junit") // bug in beta01 where junit dependencies isn't resolve well
    }
    add("androidTestImplementation", Libs.espressoCore)

}
