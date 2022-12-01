package cn.tulingxueyuan.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * 使用@Value设置依赖注入的竖线
     * 1、除了可以使用硬编码值
     * 2、还可以写${}、#{}
     */
    @Value("小花")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
