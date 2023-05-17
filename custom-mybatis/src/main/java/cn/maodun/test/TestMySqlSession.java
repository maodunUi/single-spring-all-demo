package cn.maodun.test;

import cn.maodun.mapper.PersonMapper;
import cn.maodun.proxy.MySqlSession;

/**
 * @author DELL
 * @date 2023/5/17
 */
public class TestMySqlSession {

    public static void main(String[] args) {
        PersonMapper mapper = (PersonMapper) MySqlSession.getMapper(PersonMapper.class);

        mapper.selectAll();

    }

}
