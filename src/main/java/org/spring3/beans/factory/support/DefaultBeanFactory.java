package org.spring3.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.spring3.beans.BeanDefinition;
import org.spring3.beans.factory.BeanFactory;
import org.spring3.utils.ClassUtils;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiangzhang
 * @since 2022-05-03 13:58
 */
public class DefaultBeanFactory implements BeanFactory {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private final Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public DefaultBeanFactory(String configFile) {
        loadBeanDefinition(configFile);
    }

    /**
     * 读取文件，实例化对象
     * @param configFile xml文件
     */
    private void loadBeanDefinition(String configFile) {
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        try (InputStream is = cl.getResourceAsStream(configFile);){
             SAXReader reader = new SAXReader();
             Document doc = reader.read(is);
            final Element root = doc.getRootElement();
            final Iterator iterator = root.elementIterator();
            while (iterator.hasNext()){
                Element element = (Element) iterator.next();
                final String id = element.attributeValue(ID_ATTRIBUTE);
                final String beanClassName = element.attributeValue(CLASS_ATTRIBUTE);
                final GenericBeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id,bd);
            }
        }catch (Exception e){
            throw new RuntimeException("加载失败");
        }

    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return  this.beanDefinitionMap.get(beanId);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);
        if (bd == null ){
            return null;
        }
         ClassLoader cl = ClassUtils.getDefaultClassLoader();
         String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("获取bean失败");
        }
    }
}
