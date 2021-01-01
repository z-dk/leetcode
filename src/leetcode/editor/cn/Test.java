package leetcode.editor.cn;

import java.io.IOException;

/**
 * <b>类 名 称</b> :  Test<br/>
 * <b>类 描 述</b> :  测试类<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/1 16:46<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/1 16:46<br/>
 * <b>修改备注</b> :
 */
public class Test {
    
    public static void main(String[] args) throws IOException {
        configTest();
    }
    
    public static void configTest() throws IOException {
        LoadConfigProperties configProperties = new LoadConfigProperties();
        configProperties.load("F:\\LeetCode\\project\\src\\leetcode\\editor\\cn\\common.properties");
        System.out.println(configProperties.getConfig("status"));
        System.out.println(configProperties.getConfig("url"));
        System.out.println(configProperties.setConfig("status","close"));
        System.out.println(configProperties.setConfig("second","true"));
        configProperties.store("F:\\LeetCode\\project\\src\\leetcode\\editor\\cn\\common2.properties");
    }
    
}
