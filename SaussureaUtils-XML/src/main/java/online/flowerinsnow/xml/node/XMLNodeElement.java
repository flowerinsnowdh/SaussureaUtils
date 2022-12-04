package online.flowerinsnow.xml.node;

import org.w3c.dom.Element;

public class XMLNodeElement extends XMLNodeWithChildren {
    public XMLNodeElement(Element wrapped) {
        super(wrapped);
    }

    @Override
    public Element getWrapped() {
        return (Element) super.getWrapped();
    }
}
