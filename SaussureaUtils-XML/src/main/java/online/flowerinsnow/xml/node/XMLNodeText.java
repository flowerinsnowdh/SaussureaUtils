package online.flowerinsnow.xml.node;

import org.w3c.dom.Text;

public class XMLNodeText extends XMLNodeWithText {
    public XMLNodeText(Text wrapped) {
        super(wrapped);
    }

    @Override
    public Text getWrapped() {
        return (Text) super.getWrapped();
    }
}
