package cn.maodun.proxy;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author DELL
 * @date 2023/5/18
 */
public class MyFactoryBean implements FactoryBean {

    Class tMapper ;

    @Override
    public Object getObject() throws Exception {
        return MySqlSession.getMapper(tMapper);
    }

    @Override
    public Class<?> getObjectType() {
        return tMapper;
    }

    public void settMapper(Class tMapper) {
        this.tMapper = tMapper;
    }
}
