package cs.uiowa.edu

// this requires JAR added to external libraries:
//    jsoup-1.11.2.jar (use File->project structure->libraries to add)
fun SoupBuild() {
    val doc = Jsoup.connect("https://now.uiowa.edu").get()
    println("\n*** News from University of Iowa " + doc.title())
    // read https://jsoup.org/cookbook/extracting-data/dom-navigation
    // to get some idea of what can be done
    val selected = doc.getElementsByClass("views-field")
    for (holder in selected) {
        val href = holder.getElementsByTag("a")
        println(href.text())
    }
}


//The following are noes
/*
This is a Link Object

<A AREF = "xy.hrm">
    Link to Content</A>
 */