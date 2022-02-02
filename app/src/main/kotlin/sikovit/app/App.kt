package sikovit.app

import javafx.stage.Stage
import tornadofx.*

fun main(args: Array<String>) {
    launch<Main>(args)
}

class Main: App(MainView::class) {
    override fun start(stage: Stage) {
        parseArgs()
        super.start(stage)
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
