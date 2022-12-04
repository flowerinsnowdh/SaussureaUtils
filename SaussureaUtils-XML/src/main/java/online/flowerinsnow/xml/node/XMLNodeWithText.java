package online.flowerinsnow.xml.node;

import org.w3c.dom.Node;

/**
 * 有文本的节点
 * 例如文本和注释
 */
public abstract class XMLNodeWithText extends WrappedXMLNode {
    protected XMLNodeWithText(Node wrapped) {
        super(wrapped);
    }

    /**
     * 获取文本
     *
     * @return 文本
     */
    public String getValue() {
        return getWrapped().getNodeValue();
    }

    /**
     * 设置文本
     *
     * @param value 文本
     */
    public void setValue(String value) {
        getWrapped().setNodeValue(value);
    }
}
