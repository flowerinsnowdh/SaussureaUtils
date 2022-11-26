# SaussureaUtils
也就是[雪莲](https://zh.wikipedia.org/wiki/%E9%9B%AA%E8%8E%B2)Utils，只是[冬花](https://github.com/flowerinsnowdh)的小工具箱而已，我认为叫它`FlowerinsnowUtils`太过单调，就叫这个吧

# 模块列表
- `Common` - [java](https://zh.wikipedia.org/wiki/Java)基础常用类
- `SaussureaUtils-Spigot-1.8.8` - Spigot 1.8.8常用类

# 使用
我怎么不会用github packages啊，那算了，用我自己的仓库吧
```xml
<repositories>
    <repository>
        <id>flowerinsnow</id>
        <url>https://maven.flowerinsnow.online:10443/repository/maven-public/</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>online.flowerinsnow</groupId>
    <artifactId>SaussureaUtils-[模块]</artifactId>
    <version>1.1.1</version>
</dependency>
```
建议在shade时使用relocation来防止依赖冲突
```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.4.1</version>
    <configuration>
        <relocations>
            <relocation>
                <pattern>online.flowerinsnow.saussureautils</pattern>
                <shadedPattern>your.pack.here.shaded.online.flowerinsnow.saussureautils</shadedPattern>
            </relocation>
        </relocations>
    </configuration>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```