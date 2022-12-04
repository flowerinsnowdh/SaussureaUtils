package online.flowerinsnow.xml.node;

import org.w3c.dom.Document;

public class XMLNodeDocument extends XMLNodeWithChildren {
    public XMLNodeDocument(Document document) {
        super(document);
    }

    @Override
    public Document getWrapped() {
        return (Document) super.getWrapped();
    }
}
