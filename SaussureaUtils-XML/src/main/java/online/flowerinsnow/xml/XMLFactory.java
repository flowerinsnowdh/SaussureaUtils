package online.flowerinsnow.xml;

import online.flowerinsnow.xml.exception.XMLParseException;
import online.flowerinsnow.xml.node.XMLNodeComment;
import online.flowerinsnow.xml.node.XMLNodeDocument;
import online.flowerinsnow.xml.node.XMLNodeElement;
import online.flowerinsnow.xml.node.XMLNodeText;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class XMLFactory {
    private XMLFactory() {
    }

    /**
     * 使用w3c的文档解析成XMLNodeDocument
     *
     * @param document w3c文档
     * @return XMLNodeDocument
     */
    public static XMLNodeDocument fromW3c(Document document) {
        return new XMLNodeDocument(document);
    }

    /**
     * 新建一个文档
     *
     * @return 新建文档
     */
    public static XMLNodeDocument newDocument() {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            return new XMLNodeDocument(document);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在文档下创建新的元素节点
     *
     * @param owner 文档
     * @param name 元素名
     * @return 创建的元素
     */
    public static XMLNodeElement newElement(XMLNodeDocument owner, String name) {
        return new XMLNodeElement(owner.getWrapped().createElement(name));
    }

    /**
     * 在文档下创建新的文本节点
     *
     * @param owner 文档
     * @param value 文本内容
     * @return 创建的文本
     */
    public static XMLNodeText newText(XMLNodeDocument owner, String value) {
        return new XMLNodeText(owner.getWrapped().createTextNode(value));
    }

    /**
     * 在文档下创建新的注释节点
     *
     * @param owner 文档
     * @param value 注释内容
     * @return 创建的注释
     */
    public static XMLNodeComment newComment(XMLNodeDocument owner, String value) {
        return new XMLNodeComment(owner.getWrapped().createComment(value));
    }

    /**
     * 将输入流内的内容解析为文档
     *
     * @param in 输入流
     * @return 解析出的文档
     * @throws IOException 当出现IO异常时抛出
     */
    public static XMLNodeDocument parse(InputStream in) throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            return new XMLNodeDocument(db.parse(in));
        } catch (SAXException e) {
            throw new XMLParseException(e);
        }
    }

    /**
     * 将文件内的内容解析为文档
     *
     * @param file 文件
     * @return 解析出的文档
     * @throws IOException 当出现IO异常时抛出
     */
    public static XMLNodeDocument parse(File file) throws IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            return new XMLNodeDocument(db.parse(file));
        } catch (SAXException e) {
            throw new XMLParseException(e);
        }
    }

    /**
     * 将文档写入输出流
     *
     * @param document 文档
     * @param out 输出流
     * @throws TransformerException 当文档转换或IO异常时抛出
     */
    public static void save(XMLNodeDocument document, OutputStream out) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = factory.newTransformer();
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
        DOMSource source = new DOMSource(document.getWrapped());
        StreamResult result = new StreamResult(out);
        transformer.transform(source, result);
    }
}
