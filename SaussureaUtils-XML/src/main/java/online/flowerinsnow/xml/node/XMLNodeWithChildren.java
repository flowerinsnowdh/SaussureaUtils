package online.flowerinsnow.xml.node;

import online.flowerinsnow.xml.XMLFactory;
import online.flowerinsnow.xml.exception.XMLWrongTypeException;
import org.w3c.dom.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 有子节点的Node
 * 例如Document和Element
 */
public abstract class XMLNodeWithChildren extends WrappedXMLNode {
    protected XMLNodeWithChildren(Node wrapped) {
        super(wrapped);
    }

    /**
     * 获取节点名
     *
     * @return 节点名
     */
    public String getName() {
        return wrapped.getNodeName();
    }

    /**
     * 获取节点下所有子节点
     *
     * @return 子节点列表
     */
    public List<XMLNode> getChildNodes() {
        NodeList children = wrapped.getChildNodes();
        List<XMLNode> childNodes = new ArrayList<>();
        for (int i = 0; i < children.getLength(); i++) {
            Node item = children.item(i);
            switch (item.getNodeType()) {
                case Node.ELEMENT_NODE:
                    childNodes.add(new XMLNodeElement((Element) item));
                    break;
                case Node.TEXT_NODE:
                    if (!item.getNodeValue().isEmpty()) {
                        childNodes.add(new XMLNodeText((Text) item));
                    }
                    break;
                case Node.COMMENT_NODE:
                    childNodes.add(new XMLNodeComment((Comment) item));
                    break;
            }
        }
        return childNodes;
    }

    /**
     * 获取节点下所有元素子元素节点列表
     *
     * @return 元素下子元素节点列表
     */
    public List<XMLNodeElement> getElementList() {
        return getChildNodes().stream().collect(
                ArrayList::new,
                (list, node) -> {
                    if (node instanceof XMLNodeElement) {
                        list.add((XMLNodeElement) node);
                    }
                },
                ArrayList::addAll
        );
    }

    /**
     * 获取子元素
     *
     * @param name 子元素名
     * @return 子元素，若不存在返回null
     */
    public XMLNodeElement getElement(String name) {
        Objects.requireNonNull(name);
        return getElementList().stream().filter(node -> name.equals(node.getName())).findFirst().orElse(null);
    }

    /**
     * 获取节点下所有元素子节点列表
     * @param name 节点名
     *
     * @return 元素子节点列表
     */
    public List<XMLNodeElement> getElementList(String name) {
        Objects.requireNonNull(name);
        return getElementList().stream().filter(node -> name.equals(node.getName())).collect(Collectors.toList());
    }

    /**
     * 获取节点下的字符串值
     *
     * @return 节点下的字符串值
     */
    public List<String> getTextList() {
        NodeList children = wrapped.getChildNodes();
        List<String> textList = new ArrayList<>();
        for (int i = 0; i < children.getLength(); i++) {
            Node item = children.item(i);
            if (item.getNodeType() == Node.TEXT_NODE && !item.getNodeValue().isEmpty()) {
                textList.add(item.getNodeValue());
            }
        }
        return textList;
    }

    /**
     * 获取子节点下的字符串值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的字符串值
     */
    public String getString(String name) {
        Objects.requireNonNull(name);
        return getStringList(name).stream().findFirst().orElse(null);
    }

    /**
     * 获取子节点下的字符串值列表
     *
     * @param name 子节点名
     * @return 字符串值列表
     */
    public List<String> getStringList(String name) {
        Objects.requireNonNull(name);
        List<String> list = new ArrayList<>();
        for (XMLNode childNode : getChildNodes()) {
            if (childNode instanceof XMLNodeElement) {
                XMLNodeElement element = (XMLNodeElement) childNode;
                if (name.equals(element.getName())) {
                    List<String> textList = element.getTextList();
                    if (!textList.isEmpty()) {
                        list.add(textList.get(0));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 获取子节点下的byte值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的byte值
     * @throws XMLWrongTypeException 当数据类型不是byte或是元素时抛出
     */
    public Byte getByte(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Byte.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的byte数值
     * 如果无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的byte数值，若不存在返回0
     * @throws XMLWrongTypeException 当数据类型不是byte或是元素时抛出
     */
    public byte getByteValue(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getByte(name)).orElse((byte) 0);
    }

    /**
     * 获取子节点下的short值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的short值
     * @throws XMLWrongTypeException 当数据类型不是short或是元素时抛出
     */
    public Short getShort(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Short.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的short数值
     * 如果无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的short数值，若不存在返回0
     * @throws XMLWrongTypeException 当数据类型不是short或是元素时抛出
     */
    public short getShortValue(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getShort(name)).orElse((short) 0);
    }

    /**
     * 获取子节点下的Int值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的Int值
     * @throws XMLWrongTypeException 当数据类型不是Int或是元素时抛出
     */
    public Integer getInt(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的Int数值
     * 如果无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的Int数值，若不存在返回0
     * @throws XMLWrongTypeException 当数据类型不是Int或是元素时抛出
     */
    public int getIntValue(String name) throws XMLWrongTypeException {
        return Optional.ofNullable(getInt(name)).orElse(0);
    }

    /**
     * 获取子节点下的long值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的long值
     * @throws XMLWrongTypeException 当数据类型不是long或是元素时抛出
     */
    public Long getLong(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Long.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的long数值
     * 如果无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的long数值，若不存在返回0
     * @throws XMLWrongTypeException 当数据类型不是long或是元素时抛出
     */
    public long getLongValue(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getLong(name)).orElse(0L);
    }

    /**
     * 获取子节点下的float值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的float值
     * @throws XMLWrongTypeException 当数据类型不是float或是元素时抛出
     */
    public Float getFloat(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Float.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的float数值
     * 如果无这个节点返回0.0
     *
     * @param name 子节点名
     * @return 子节点下的float数值，若不存在返回0.0
     * @throws XMLWrongTypeException 当数据类型不是float或是元素时抛出
     */
    public float getFloatValue(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getFloat(name)).orElse(0.0F);
    }

    /**
     * 获取子节点下的double值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的double值
     * @throws XMLWrongTypeException 当数据类型不是double或是元素时抛出
     */
    public Double getDouble(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的double数值
     * 如果无这个节点返回0.0
     *
     * @param name 子节点名
     * @return 子节点下的double数值，若不存在返回0.0
     * @throws XMLWrongTypeException 当数据类型不是double或是元素时抛出
     */
    public double getDoubleValue(String name) throws XMLWrongTypeException {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getDouble(name)).orElse(0.0);
    }

    /**
     * 获取子节点下的boolean值
     * 如果无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的boolean值
     */
    public Boolean getBoolean(String name) {
        Objects.requireNonNull(name);
        String str = getString(name);
        if (str != null) {
            try {
                return Boolean.valueOf(str);
            } catch (NumberFormatException e) {
                throw new XMLWrongTypeException(e);
            }
        }
        return null;
    }

    /**
     * 获取子节点下的boolean数值
     * 如果无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的boolean数值，若不存在返回false
     */
    public boolean getBooleanValue(String name) {
        Objects.requireNonNull(name);
        return Optional.ofNullable(getBoolean(name)).orElse(false);
    }

    /**
     * 设置第一个子节点的值
     *
     * @param name 子节点名
     * @param value 子节点值
     */
    public void set(String name, Object value) {
        Objects.requireNonNull(name);
        for (XMLNode childNode : getChildNodes()) { // 遍历已有的子节点
            if (!(childNode instanceof XMLNodeWithChildren)) { // 不是可以操作的元素
                continue;
            }
            XMLNodeWithChildren node = (XMLNodeWithChildren) childNode;
            if (!name.equals(node.getName())) { // 不是想要的元素
                continue;
            }
            // 开始更改
            for (XMLNode nodeChildNode : node.getChildNodes()) { // 遍历子元素的子节点
                if (nodeChildNode instanceof XMLNodeText) {
                    ((XMLNodeText) nodeChildNode).setValue(String.valueOf(value));
                }
                return;
            }
        }
        // 没有名为name的元素，添加元素
        XMLNodeElement element = XMLFactory.newElement(getOwner(), name); // 添加的元素
        XMLNodeText text = XMLFactory.newText(getOwner(), String.valueOf(value));
        element.append(text);
        this.append(element);
    }

    /**
     * 设置第一个文本节点的值
     *
     * @param value 值
     */
    public void set(Object value) {
        for (XMLNode childNode : getChildNodes()) {
            if (childNode instanceof XMLNodeText) {
                XMLNodeText text = (XMLNodeText) childNode;
                text.setValue(String.valueOf(value));
                return;
            }
        }
        // 没有节点
        append(XMLFactory.newText(getOwner(), String.valueOf(value))); // 追加
    }

    /**
     * 替换子节点
     *
     * @param old 旧子节点
     * @param _new 新子节点
     */
    public void replace(XMLNode old, XMLNode _new) {
        Objects.requireNonNull(old);
        Objects.requireNonNull(_new);
        wrapped.replaceChild(old.getWrapped(), _new.getWrapped());
    }

    /**
     * 删除子节点
     *
     * @param childNode 需要删除的子节点
     */
    public void remove(XMLNode childNode) {
        Objects.requireNonNull(childNode);
        wrapped.removeChild(childNode.getWrapped());
    }

    /**
     * 追加一个子节点
     *
     * @param node 需要追加的子节点
     */
    public void append(XMLNode node) {
        Objects.requireNonNull(node);
        wrapped.appendChild(node.getWrapped());
    }
}
