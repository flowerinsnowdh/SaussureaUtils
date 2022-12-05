package online.flowerinsnow.xml.node;

import online.flowerinsnow.xml.XMLFactory;
import online.flowerinsnow.xml.exception.XMLIllegalOperationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;

public class XMLNodeDocument extends XMLNodeWithChildren {
    public XMLNodeDocument(Document document) {
        super(document);
    }

    @Override
    public Document getWrapped() {
        return (Document) super.getWrapped();
    }

    @Override
    public void append(XMLNode node) {
        try {
            super.append(node);
        } catch (DOMException e) {
            if (e.getMessage().startsWith("HIERARCHY_REQUEST_ERR")) {
                throw new XMLIllegalOperationException("XML根文档只能插入一个元素", e);
            }
            throw e;
        }
    }

    /**
     * 在文档下创建新的元素节点
     *
     * @param name 元素名
     * @return 创建的元素
     */
    public XMLNodeElement newElement(String name) {
        return XMLFactory.newElement(this, name);
    }

    /**
     * 在文档下创建新的文本节点
     *
     * @param value 文本内容
     * @return 创建的文本
     */
    public XMLNodeText newText(String value) {
        return XMLFactory.newText(this, value);
    }

    /**
     * 在文档下创建新的注释节点
     *
     * @param value 注释内容
     * @return 创建的注释
     */
    public XMLNodeComment newComment(String value) {
        return XMLFactory.newComment(this, value);
    }
}
