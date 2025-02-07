import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.meta

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "org.example.portfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
            head.add {
                meta("og:image", "/banner.png",)
                meta(name = "og:site_name", content = "Portfolio")
                meta(name = "og:type", content = "website")
                meta(name = "twitter:site", content = "Kobweb Portfolio")
                meta(name = "twitter:title", content = "Kobweb Portfolio")
                meta(name = "twitter:description", content = "A sample portfolio site made from kotlin using kobweb🗿")
                meta(name = "twitter:card", content = "summary_large_image")
                meta(name = "twitter:image:src", content = "/banner.png")
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("portfolio")

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            //implementation(libs.silk.animation)
            implementation(project(":worker"))
        }
    }
}
