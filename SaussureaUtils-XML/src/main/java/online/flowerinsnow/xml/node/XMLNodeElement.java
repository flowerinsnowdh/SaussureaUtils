package online.flowerinsnow.xml.node;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class XMLNodeElement extends XMLNodeWithChildren {
    public XMLNodeElement(Element wrapped) {
        super(wrapped);
    }

    /**
     * 设置属性
     *
     * @param key 键
     * @param value 值
     */
    public void setAttribute(String key, Object value) {
        Attr attr = getOwner().getWrapped().createAttribute(key);
        attr.setValue(String.valueOf(value));
        wrapped.getAttributes().setNamedItem(attr);
    }

    /**
     * 获取所有节点属性
     *
     * @return 所有节点属性
     */
    public Map<String, String> getAttributes() {
        NamedNodeMap map = wrapped.getAttributes();
        Map<String, String> attributes = new HashMap<>();
        for (int i = 0; i < map.getLength(); i++) {
            Node node = map.item(i);
            attributes.put(node.getNodeName(), node.getNodeValue());
        }
        return attributes;
    }

    /**
     * 获取节点属性，若不存在返回null
     *
     * @param name 属性名
     * @return 节点属性
     */
    public String getAttribute(String name) {
        Objects.requireNonNull(name);
        return getAttributes().get(name);
    }

    /**
     * 移除属性
     *
     * @param key 值
     */
    public void removeAttribute(String key) {
        wrapped.getAttributes().removeNamedItem(key);
    }

    @Override
    public Element getWrapped() {
        return (Element) super.getWrapped();
    }
}
