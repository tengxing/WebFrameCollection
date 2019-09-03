package cn.littleterry.sb;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author terry
 * @since 19/07/2019
 */
@Mapper
public interface CityMapper {

    @Select("select id, name, state, country from city where state = #{state}")
    City findByState(@Param("state") String state);

    @Insert("insert into city values(#{city.id},#{city.name},#{city.state},#{city.country})")
    int insert(@Param("city") City city);

    @Insert("insert into city values(#{id},#{name},#{state},#{country})")
    int insertSimple(City city);

}
