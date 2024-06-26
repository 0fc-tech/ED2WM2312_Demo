pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Demonstrations"
include(":app")
include(":mod2variables")
include(":mod2conditions")
include(":mod2boucles")
include(":mod2fonctions")
include(":mod2poo")
include(":mod3compose")
include(":mod4gestioninteraction")
include(":mod4notemagasin")
include(":mod5navigation")
include(":mod6datastore")
include(":mod7retrofit")
include(":mod7quizz")
