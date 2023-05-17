package cn.maodun.mapper;

import cn.maodun.anno.Select;
import cn.maodun.model.Person;

/**
 * @author DELL
 * @date 2023/5/17
 */
public interface PersonMapper {

    @Select(value = {"select * from user"})
    public Person selectAll();
}
