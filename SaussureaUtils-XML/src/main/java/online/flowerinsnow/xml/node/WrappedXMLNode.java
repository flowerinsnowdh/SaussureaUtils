package online.flowerinsnow.xml.node;

import org.w3c.dom.*;

import java.util.*;

/**
 * 使用w3c dom包裹解析的节点
 */
public class WrappedXMLNode implements XMLNode {
    protected final Node wrapped;

    protected WrappedXMLNode(Node wrapped) {
        Objects.requireNonNull(wrapped);
        this.wrapped = wrapped;
    }

    @Override
    public XMLNodeType getType() {
        return XMLNodeType.getByID(getWrapped().getNodeType());
    }

    @Override
    public XMLNodeDocument getOwner() {
        return this instanceof XMLNodeDocument ?
                (XMLNodeDocument) this :
                new XMLNodeDocument(wrapped.getOwnerDocument());
    }

    @Override
    public Node getWrapped() {
        return wrapped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WrappedXMLNode)) return false;
        WrappedXMLNode that = (WrappedXMLNode) o;
        return wrapped == that.wrapped;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + wrapped.hashCode();
        return result;
    }
}
