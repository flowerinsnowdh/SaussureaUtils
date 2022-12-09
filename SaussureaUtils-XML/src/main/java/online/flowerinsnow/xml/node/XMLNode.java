package online.flowerinsnow.xml.node;

import org.w3c.dom.Node;

/**
 * <p>代表一个XML节点</p>
 * <p>XML中所有的内容都是一个节点</p>
 * <p></p>
 * <p>这一整个是一个文档节点</p>
 * <p>&lt;book&gt; - 这是一个元素节点</p>
 * <p>&emsp;&lt;!-- 123 --&gt; - 这是一个注释节点</p>
 * <p>&emsp;&lt;name&gt; - 这是一个元素节点</p>
 * <p>&emsp;&emsp;Java手册 - 这是一个文本节点</p>
 * <p>&emsp;&lt;&#47;name&gt;</p>
 * <p>&lt;&#47;book&gt;</p>
 * <p></p>
 *
 * <p>其实&lt;id="10"&#47;&gt;中的 'id="10"' 也是一个节点，但是这里直接将其当做属性来处理，这样方便一点</p>
 *
 * <p>每个节点都必须拥有根节点</p>
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
