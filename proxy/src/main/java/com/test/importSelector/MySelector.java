package com.test.importSelector;


import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        System.out.println("======= "+importingClassMetadata.toString());

        return new String[]{};
    }
}
