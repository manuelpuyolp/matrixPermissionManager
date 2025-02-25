package security


import groovy.xml.*

class XMLmanipulation {
    public static def nodeToString(def root) {
        StringWriter stringWriter = new StringWriter()
        XmlNodePrinter nodePrinter = new XmlNodePrinter(new PrintWriter(stringWriter))
        nodePrinter.setPreserveWhitespace(true)
        nodePrinter.setExpandEmptyElements(true)
        nodePrinter.setQuote("\"")

        nodePrinter.print(root)
        String xmlString = stringWriter.toString()
        return xmlString
    }
}