# XML
XML模块可以帮助解析和创建XML文件或文本，基于w3c DOM，改变了原本奇怪的API

# 注意
XML模块下的所有方法均不是线程安全的，同时操作get和set可能会出现问题

# 用法
我们这个教学使用这个xml内容
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<book>
    <name id="1">Java手册</name>
    <!-- 作者列表 -->
    <author>flowerinsnow</author>
    <author>w3c dom</author>
    <readable>true</readable>
</book>
```
## 生成
想要生成这个内容，可以使用如下代码
```java
XMLNodeDocument document = XMLFactory.newDocument(); // 创建新的文档
XMLNodeElement root = XMLFactory.newElement(document, "book"); // 创建根元素“root”
document.append(root); // 将根节点追加到文档中

XMLNodeElement name = XMLFactory.newElement(document, "name"); // 创建一个名为name的元素
name.setAttribute("id", 1); // 设置元素属性
XMLNodeText text = XMLFactory.newText(document, "Java手册"); // 创建一个文本节点，内容为"Java手册"
name.append(text); // 在name元素下追加text节点
root.append(name); // 在根元素下追加name元素

root.append(document.newComment("作者列表")); // 在这里插入一个注释

XMLNodeElement author = XMLFactory.newElement(document, "author"); // 创建一个名为author的元素
author.append(document.newText("flowerinsnow")); // 或者这样创建一个内容为"flowerinsnow"的文本，并直接追加到author元素下
author.append(document.newText("w3c dom"));
root.append(author);

// 考虑到操作API可以更像YAML和JSON，可以使用这样直接一键创建节点
root.set("readable", true);

// 输出
try {
    XMLFactory.save(document, System.out);
    System.out.println(); // 它输出不会自动换行，这里手动换个行
} catch (TransformerException e) {
    e.printStackTrace();
}
```
## 解析
本类最大的特点还是可以解析XML内容

### 读取
```java
XMLNodeDocument document = XMLFactory.parse(new File("book.xml"));
XMLNodeElement root = document.getElement("book"); // 获取文档下名为book的根节点
```

### 阅读节点
由于本类把XML视为节点，所以可以一键获取当前元素或文档下的所有节点
```java
root.getChildNodes();
```
执行结果为

|   名称/内容    |   类型    |
|:----------:|:-------:|
|   `name`   | Element |
|   '作者列表'   | Comment |
|  `author`  | Element |
|  `author`  | Element |
| `readable` | Element |

***

你几乎可以把它当做YAML或JSON解析器来用
```java
XMLNodeElement name = root.getElement("name");
```
执行结果为`<name id="1">Java手册</name>`

***

元素是有属性的
```java
name.getAttribute("id");
```
就可以获取`1`

***

`name`元素可以像`root`元素一样操作，当然前提是有子节点的情况下  
`name`元素下有一个文本节点，通过`getTextList()`方法即可获取它
```java
name.getTextList()
```
执行结果为`[Java手册]`

***

更快速地，你干脆把它当做单独变量来读
```java
name.getBooleanValue("readable")
```
可以直接获取这个`true`

***

而XML是可以在一个地方拥有两个同名元素的，`getXXX()`方法只会获取第一个  
例如：
```java
root.getString("author")
```
执行结果为第一个`flowerinsnow`

***

多个同名元素可以当做数组来读
```java
root.getStringList("author")
```
执行结果为`[flowerinsnow, w3c dom]`