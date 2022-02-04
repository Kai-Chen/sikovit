package sikovit.app

import javafx.stage.Stage
import tornadofx.*
import java.util.logging.ConsoleHandler
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.LogManager

fun main(args: Array<String>) {
    launch<Main>(args)
}

class Main: App(MainView::class) {
    override fun start(stage: Stage) {
        parseArgs()
        // configLogger()
        super.start(stage)
    }

    private fun configLogger() {
        val logger = LogManager.getLogManager().getLogger("")
        logger.level = Level.FINEST
        val logHandler = FileHandler("webkit.log")
        logHandler.level = Level.ALL
        logger.addHandler(logHandler)
    }

    private fun parseArgs() {
        val lastArgIndex = parameters.raw.lastIndex
        val location = parameters.raw.getOrElse(lastArgIndex) { "https://www.duckduckgo.com" }
        config["window.location"] = location
        config.save()
    }
}

class MainView: View("Main Web View") {
    override val root = vbox {
        webview {
            engine.load(app.config.string("window.location"))
        }
    }
}
