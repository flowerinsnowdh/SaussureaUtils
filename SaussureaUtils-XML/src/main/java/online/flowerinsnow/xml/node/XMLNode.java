package online.flowerinsnow.xml.node;

import org.w3c.dom.Node;

/**
 * <p>代表一个XML节点</p>
 * <p>XML中所有的内容都是一个节点</p>
 * <p>
 *     <p>&lt;book&gt; - 这是一个文档节点</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&lt;!-- 123 --&gt; - 这是一个注释节点</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&lt;name&gt; - 这是一个元素节点</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java手册 - 这是一个文本节点</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&lt;/name&gt;</p>
 *     <p>&lt;/book&gt;</p>
 * </p>
 *
 * <p>其实&lt;id="10"/&gt;中的 'id="10"' 也是一个节点，但是这里直接将其当做属性来处理，这样方便一点</p>
 *
 * <p>每个节点都必须拥有根节点</p>
 * <p>
 *     <p>&lt;owner&gt;</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&lt;parent&gt;</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;child>&lt;/child&gt;</p>
 *     <p>&nbsp;&nbsp;&nbsp;&nbsp;&lt;/parent&gt;</p>
 *     <p>&lt;/owner><p/>
 * </p>
 */
public interface XMLNode {
    /**
     * 获取节点类型
     *
     * @return 节点类型
     */
    XMLNodeType getType();

    /**
     * 获取根节点，若没有返回null
     *
     * @return 根节点
     */
    XMLNodeDocument getOwner();

    Node getWrapped();
}