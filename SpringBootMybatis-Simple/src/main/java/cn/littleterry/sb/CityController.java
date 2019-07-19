package cn.littleterry.sb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author terry
 * @since 19/07/2019
 */
@RestController
public class CityController {
    @Resource
    private CityMapper cityMapper;

    @GetMapping(value = "/index")
    public City info(){
        return this.cityMapper.findByState("CA");
    }
}
