package cn.littleterry.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件
 * @author terry
 * @since 06/09/2019
 */
public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    private static final String DEFAULT_PROPERTIES="application.properties";

    private PropertiesUtil(){
    	
    }
    /**
     * 获取properties属性值
     * @param str
     * @return
     */
    public static String prop(String str){
        Resource resource;
        Properties props;
        try {
            resource = new ClassPathResource(DEFAULT_PROPERTIES);
            props = PropertiesLoaderUtils.loadProperties(resource);
            return props.getProperty(str);
        }catch (IOException e){
            logger.error(e.getMessage());
        }
        return null;
    }


    /**
     * 获取properties属性值
     * @param str
     * @return
     */
    public static String prop(String str,String fileName){
        Resource resource;
        Properties props;
        if (!StringUtils.isEmpty(fileName)){
            try {
                resource = new ClassPathResource(fileName);
                props = PropertiesLoaderUtils.loadProperties(resource);
                return props.getProperty(str);
            }catch (IOException e){
                logger.error(e.getMessage());
            }
        }else {
            return prop(str);
        }

        return null;
    }

}
