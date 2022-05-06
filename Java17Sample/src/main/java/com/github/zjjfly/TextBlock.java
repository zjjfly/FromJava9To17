package com.github.zjjfly;

import org.junit.jupiter.api.Assertions;

/**
 * Java15引入的text block，类似scala的多行string，但不支持行起始符
 *
 * @author zijunjie[https://github.com/zjjfly]
 * @date 2022/5/6
 */
public class TextBlock {

    public static void main(String[] args) {
        String s = """
            <html>
                <p>Ciao, hello</p>
            </html>""";
        Assertions.assertEquals("<html>\n    <p>Ciao, hello</p>\n</html>", s);

        //可以使用\来防止添加换行符
        s = """
            1\
            2""";
        Assertions.assertEquals("12", s);
        //可以使用\s来表示空格
        s = """
            1\s
            2""";
        Assertions.assertEquals("1 \n2", s);
    }

}
