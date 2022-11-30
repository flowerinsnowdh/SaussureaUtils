package online.flowerinsnow.xml;

import online.flowerinsnow.xml.exception.XMLWrongTypeException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Map;

/**
 * 代表一个XML节点
 */
public interface XMLNode {
    /**
     * 获取节点名
     *
     * @return 节点名
     */
    String getName();

    /**
     * 获取节点类型
     *
     * @return 节点类型
     */
    NodeType getType();

    /**
     * 获取根节点，若没有返回null
     *
     * @return 根节点，若没有返回null
     */
    Document getRoot();

    /**
     * 获取所有节点属性
     *
     * @return 所有节点属性
     */
    Map<String, String> getAttributes();

    /**
     * 获取节点属性
     *
     * @param name 属性名
     * @return 节点属性
     */
    String getAttribute(String name);

    /**
     * 获取节点下所有子节点
     *
     * @return 子节点列表
     */
    List<XMLNode> getNodes();

    /**
     * 获取节点下所有元素子元素节点列表
     *
     * @return 元素下子元素节点列表
     */
    List<XMLNode> getElementNodes();

    /**
     * 获取子节点
     *
     * @param name 子节点名
     * @return 子节点
     */
    XMLNode getElementNode(String name);

    /**
     * 获取节点下所有元素子节点列表
     * @param name 节点名
     *
     * @return 元素子节点列表
     */
    List<XMLNode> getElementNodes(String name);

    /**
     * 获取节点下的字符串值
     *
     * @return 节点下的字符串值
     * @throws XMLWrongTypeException 如果节点值不是字符串返回null
     */
    String getValue() throws XMLWrongTypeException;

    /**
     * 获取子节点下的字符串值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的字符串值
     */
    String getString(String name);

    /**
     * 获取子节点下的字符串值列表
     *
     * @param name 子节点名
     * @return 字符串值列表
     */
    List<String> getList(String name);

    /**
     * 获取子节点下的byte值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的byte值
     * @throws XMLWrongTypeException 当数据类型不是byte或是元素时抛出
     */
    Byte getByte(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的byte数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的byte数值
     * @throws XMLWrongTypeException 当数据类型不是byte或是元素时抛出
     */
    byte getByteValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的short值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的short值
     * @throws XMLWrongTypeException 当数据类型不是short或是元素时抛出
     */
    Short getShort(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的short数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的short数值
     * @throws XMLWrongTypeException 当数据类型不是short或是元素时抛出
     */
    short getShortValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的Int值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的Int值
     * @throws XMLWrongTypeException 当数据类型不是Int或是元素时抛出
     */
    Integer getInt(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的Int数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的Int数值
     * @throws XMLWrongTypeException 当数据类型不是Int或是元素时抛出
     */
    Integer getIntValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的long值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的long值
     * @throws XMLWrongTypeException 当数据类型不是long或是元素时抛出
     */
    Long getLong(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的long数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的long数值
     * @throws XMLWrongTypeException 当数据类型不是long或是元素时抛出
     */
    long getLongValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的float值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的float值
     * @throws XMLWrongTypeException 当数据类型不是float或是元素时抛出
     */
    Float getFloat(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的float数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的float数值
     * @throws XMLWrongTypeException 当数据类型不是float或是元素时抛出
     */
    float getFloatValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的double值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的double值
     * @throws XMLWrongTypeException 当数据类型不是double或是元素时抛出
     */
    Double getDouble(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的double数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的double数值
     * @throws XMLWrongTypeException 当数据类型不是double或是元素时抛出
     */
    double getDoubleValue(String name) throws XMLWrongTypeException;

    /**
     * 获取子节点下的boolean值
     * 如果该节点是元素或无这个节点返回null
     *
     * @param name 子节点名
     * @return 子节点下的boolean值
     */
    Boolean getBoolean(String name);

    /**
     * 获取子节点下的boolean数值
     * 如果该节点是元素或无这个节点返回0
     *
     * @param name 子节点名
     * @return 子节点下的boolean数值
     */
    boolean getBooleanValue(String name);

    /**
     * 设置第一个名为name的子节点的数值为object
     *
     * @param name 子节点名
     * @param object 子节点值
     */
    void set(String name, Object object);

    /**
     * 设置节点下的子节点列表
     *
     * @param name 子节点名
     * @param objectList 子节点列表
     */
    void set(String name, List<Object> objectList);

    /**
     * 在当前节点下追加子节点
     *
     * @param node 追加节点
     */
    void add(XMLNode node);

    /**
     * 设置当前节点的值
     *
     * @param value 节点的值
     */
    void setValue(Object value);

    /**
     * 删除节点下名为name的节点
     *
     * @param name 节点名
     */
    void removeNode(String name);

    /**
     * 将根节点转为字符串
     * 必须拥有根节点才能转换
     */
    void rootString();

    Node getWrapped();
}
