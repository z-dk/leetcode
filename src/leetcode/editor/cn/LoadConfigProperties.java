package leetcode.editor.cn;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b>类 名 称</b> :  LoadConfigProperties<br/>
 * <b>类 描 述</b> :  加载配置文件<br/>
 * <b>创 建 人</b> :  zhudengkui<br/>
 * <b>创建时间</b> :  2021/1/1 16:01<br/>
 * <b>修 改 人</b> :  zhudengkui<br/>
 * <b>修改时间</b> :  2021/1/1 16:01<br/>
 * <b>修改备注</b> :
 */
public class LoadConfigProperties {
    
    private Map<String,String> configs;
    
    public boolean load(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> list = Files.readAllLines(path);
        configs = new HashMap<>();
        list.forEach(kv -> {
            String[] split = kv.split(":", 2);
            configs.put(split[0],split[1]);
        });
        return true;
    }
    
    public String getConfig(String config) throws IOException {
        if (configs == null) {
            throw new IOException("配置文件尚未初始化！");
        }
        return configs.getOrDefault(config,"");
    }
    
    public String setConfig(String key, String value) throws IOException {
        if (configs == null) {
            throw new IOException("配置文件尚未初始化！");
        }
        return configs.put(key, value);
    }
    
    public boolean store(String fileName) throws IOException {
        List<String> properties = configs.entrySet().stream().map(entry -> entry.getKey() + ":" + entry.getValue()).collect(Collectors.toList());
        Files.write(Paths.get(fileName),properties);
        return true;
    }
    
}
