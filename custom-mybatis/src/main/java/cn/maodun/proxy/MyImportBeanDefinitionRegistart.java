package cn.maodun.proxy;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.BeanFactoryPostProcessor
 *          postProcessBeanFactory
 * 2.BeanDefinitionRegistryPostProcessor
 *          postProcessBeanDefinitionRegistry
 * 3.ImportBeanDefinitionRegistrar
 *
 * @author DELL
 * @date 2023/5/18
 */
public class MyImportBeanDefinitionRegistart implements ImportBeanDefinitionRegistrar {

    Map<String, BeanDefinition> map = new HashMap<>();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
        // scan();
        for (String key : map.keySet()) {
            AbstractBeanDefinition mapperBd = (AbstractBeanDefinition)
                    map.get(key);
            Class mapperClz = mapperBd.getBeanClass();
            System.out.println("before:{}" + mapperBd.getBeanClass().getName());
            mapperBd.setBeanClass(MyFactoryBean.class);
            System.out.println("after:{}" + mapperBd.getBeanClass().getName());
            mapperBd.getPropertyValues().add("mapperInterface", mapperClz.getName());
            registry.registerBeanDefinition(key, mapperBd);
        }
    }

}
