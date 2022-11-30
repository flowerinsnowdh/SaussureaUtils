package online.flowerinsnow.xml;

import online.flowerinsnow.xml.exception.XMLUnsupportedException;
import online.flowerinsnow.xml.exception.XMLWrongTypeException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

/**
 * 使用w3c dom包裹解析的节点
 */
public class WrappedXMLNode implements XMLNode {
    private final Node wrapped;
    private final Document root;
    private String name;
    private NodeType type;
    private String value;
    private HashMap<String, String> attributes;
    private ArrayList<XMLNode> nodeList;

    public WrappedXMLNode(Node wrapped, Document root) throws XMLUnsupportedException {
        Objects.requireNonNull(wrapped);
        this.wrapped = wrapped;
        this.root = root;
        parse();
    }

    private void parse() throws XMLUnsupportedException {
        name = wrapped.getNodeName();

        NodeList children = wrapped.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                type = NodeType.ELEMENT;
                break;
            } else if (child.getNodeType() == Node.TEXT_NODE && !child.getNodeValue().isEmpty()) {
                type = NodeType.TEXT;
                value = child.getNodeValue();
                break;
            }
        }
        if (type == null) {
            throw new XMLUnsupportedException("Node type unknown.");
        }

        attributes = new HashMap<>();
        NamedNodeMap attrs = wrapped.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            Node attr = attrs.item(i);
            attributes.put(attr.getNodeName(), attr.getNodeValue());
        }

        nodeList = new ArrayList<>();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                nodeList.add(new WrappedXMLNode(child, root));
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public NodeType getType() {
        return null;
    }

    @Override
    public Document getRoot() {
        return null;
    }

    @Override
    public Map<String, String> getAttributes() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public List<XMLNode> getNodes() {
        return null;
    }

    @Override
    public List<XMLNode> getElementNodes() {
        return null;
    }

    @Override
    public XMLNode getElementNode(String name) {
        return null;
    }

    @Override
    public List<XMLNode> getElementNodes(String name) {
        return null;
    }

    @Override
    public String getValue() throws XMLWrongTypeException {
        return null;
    }

    @Override
    public String getString(String name) {
        return null;
    }

    @Override
    public List<String> getList(String name) {
        return null;
    }

    @Override
    public Byte getByte(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public byte getByteValue(String name) throws XMLWrongTypeException {
        return 0;
    }

    @Override
    public Short getShort(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public short getShortValue(String name) throws XMLWrongTypeException {
        return 0;
    }

    @Override
    public Integer getInt(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public Integer getIntValue(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public Long getLong(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public long getLongValue(String name) throws XMLWrongTypeException {
        return 0;
    }

    @Override
    public Float getFloat(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public float getFloatValue(String name) throws XMLWrongTypeException {
        return 0;
    }

    @Override
    public Double getDouble(String name) throws XMLWrongTypeException {
        return null;
    }

    @Override
    public double getDoubleValue(String name) throws XMLWrongTypeException {
        return 0;
    }

    @Override
    public Boolean getBoolean(String name) {
        return null;
    }

    @Override
    public boolean getBooleanValue(String name) {
        return false;
    }

    @Override
    public void set(String name, Object object) {

    }

    @Override
    public void set(String name, List<Object> objectList) {

    }

    @Override
    public void add(XMLNode node) {

    }

    @Override
    public void setValue(Object value) {

    }

    @Override
    public void removeNode(String name) {

    }

    @Override
    public void rootString() {

    }

    @Override
    public Node getWrapped() {
        return null;
    }
}
