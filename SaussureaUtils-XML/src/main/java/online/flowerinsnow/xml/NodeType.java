package online.flowerinsnow.xml;

/**
 * XML节点类型
 */
public enum NodeType {
    /**
     * 元素，也就是一个标签
     */
    ELEMENT(1),
    /**
     * 属性
     */
    ATTRIBUTE(2),
    /**
     * 文本
     */
    TEXT(3),
    /**
     * CDATA
     */
    CDATA_SECTION(4),
    ENTITY_REFERENCE(5),
    ENTITY(6),
    PROCESSING_INSTRUCTION(7),
    /**
     * 注释
     */
    COMMENT(8),
    /**
     * 文档，通常是根节点
     */
    DOCUMENT(9),
    DOCUMENT_TYPE(10),
    DOCUMENT_FRAGMENT(11),
    NOTATION(12);
    public final int id;

    NodeType(int id) {
        this.id = id;
    }

    public static NodeType getByID(int id) {
        for (NodeType value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }
}
