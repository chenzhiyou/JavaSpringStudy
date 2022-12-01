package spring_ioc_javaconfig.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


@Component
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 可以以字符串的形式返注册多个bean
        // 字符串必须是类的完整限定名，getBean不能根据名字获取，必须根据类型获取
        return new String[]{
                "spring_ioc_javaconfig.beans.Person",
                Wife.class.getName()};
    }
}
