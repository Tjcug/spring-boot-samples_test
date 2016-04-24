package com.basic.springboot.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Component;

import java.io.Writer;
import java.util.Map;
/**
 * Created by dell-pc on 2016/4/20.
 */
@Component("freeMarkerUtil")
public class FreeMarkerUtil {
    private static Configuration configuration = null;

    /*
    * spring注入的时候回调用它的默认构造方法
    *
     */
    private  FreeMarkerUtil(){
        if (null == configuration) {
            configuration = new Configuration(Configuration.VERSION_2_3_22);  // 这里Configurantion对象不能有两个，否则多线程访问会报错
            configuration.setDefaultEncoding("utf-8");
            configuration.setClassicCompatible(true);
        }
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public void process(Map<?, ?> root, String template, Writer out){

        if (null == root ) {
            throw new RuntimeException("数据不能为空");
        }

        if (null == template) {
            throw new RuntimeException("模板文件不能为空");
        }
        String templatePath = template.substring(0, template.lastIndexOf("/"));
        String templateName = template.substring(template.lastIndexOf("/") + 1, template.length());

        configuration.setClassForTemplateLoading(FreeMarkerUtil.class, templatePath);
        Template t = null;

        try {
            t = configuration.getTemplate(templateName);
            t.process(root, out);  // 这里out是一个输出地址，可以输出到任何位置，如控制台，网页等
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
