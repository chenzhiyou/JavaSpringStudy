package spring_ioc_javaconfig.beans;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("吴彦祖")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
