package sikovit.app

import tornadofx.*

fun main(args: Array<String>) {
    launch<Main>(args)
}

class Main: App(MainView::class)

class MainView: View() {
    override val root = vbox {
        webview {
            engine.load("https://www.duckduckgo.com")
        }
    }
}
