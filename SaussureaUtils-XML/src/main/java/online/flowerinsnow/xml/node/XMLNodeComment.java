package online.flowerinsnow.xml.node;

import org.w3c.dom.Comment;

public class XMLNodeComment extends XMLNodeWithText {
    public XMLNodeComment(Comment wrapped) {
        super(wrapped);
    }

    @Override
    public Comment getWrapped() {
        return (Comment) super.getWrapped();
    }
}
