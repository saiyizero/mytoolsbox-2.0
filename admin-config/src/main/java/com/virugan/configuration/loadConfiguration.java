package com.virugan.configuration;

import com.virugan.api.localJdbcOperate;
import com.virugan.myUtlis.myBeanUtils;
import com.virugan.myUtlis.myLogUtils;
import com.virugan.tables.mytoolConfPrprties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * 从数据库加载配置信息并注入到内存中
 * **/
@Configuration
public class loadConfiguration {
    @Autowired
    private ConfigurableEnvironment environment;
    @Autowired
    localJdbcOperate localjdbcoperate;

    @PostConstruct
    public void initProperty() {
        Map<String, Object> collect = myBeanUtils.getMap();
        List<mytoolConfPrprties> list = localjdbcoperate.selectListByInput(new mytoolConfPrprties());
        for(mytoolConfPrprties confprprties:list){
            collect.put(confprprties.getCansunme(),confprprties.getCansuval());
        }

        MutablePropertySources propertySources = environment.getPropertySources();
        Properties properties = new Properties();
        properties.putAll(collect);

        PropertiesPropertySource constants = new PropertiesPropertySource("mytool-config", properties);
        Pattern p = Pattern.compile("^applicationConfig.*");
        String name = null;
        boolean flag = false;
        for (PropertySource<?> source : propertySources) {
            if (p.matcher(source.getName()).matches()) {
                name = source.getName();
                flag = true;
                break;
            }
        }
        if (flag) {
            propertySources.addBefore(name, constants);
        } else {
            propertySources.addFirst(constants);
        }
     }

}
