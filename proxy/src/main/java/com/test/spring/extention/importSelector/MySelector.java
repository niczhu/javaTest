package com.test.spring.extention.importSelector;


import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        System.out.println("======= "+importingClassMetadata.getClassName());

        return new String[]{TestSelect.class.getName()};
    }
}
