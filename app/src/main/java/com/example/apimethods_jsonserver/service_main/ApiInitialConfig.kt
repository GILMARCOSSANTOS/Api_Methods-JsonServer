package com.example.apimethods_jsonserver.service_main

enum class EnviromentConfig(val env: String) {

    DEV("dev"), HML("hml"), SANDBOX("sandbox"), PRODUCTION("production")
}

class Enviroment() {

    var urlBase: String = ""
    var apiKey: String = ""
}

class ApiInitialConfig {

    private var RUN_ENV: String = "sandbox"

    fun getEnviroment(): Enviroment {

        val enviroment = Enviroment()

        when (RUN_ENV) {

            EnviromentConfig.DEV.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "http://10.0.2.2:3000/"
            }

            EnviromentConfig.HML.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "http://10.0.2.2:3000/"
            }

            EnviromentConfig.SANDBOX.env -> {

                enviroment.apiKey = ""
                enviroment.urlBase = "http://10.0.2.2:3000/"
            }

            else -> {

                enviroment.apiKey = ""
                enviroment.urlBase = ""
            }
        }
        return enviroment
    }
}