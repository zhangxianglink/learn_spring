package org.spring3.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.spring3.beans.BeanDefinition;
import org.spring3.beans.factory.BeanFactory;
import org.spring3.beans.factory.support.DefaultBeanFactory;
import org.spring3.service.v1.PetStoreService;

/**
 * @author xiangzhang
 * @since 2022-05-03 13:44
 */
public class BeanFactoryTest {

    @Test
    public void  testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");
        Assert.assertEquals("org.spring3.service.v1.PetStoreService",bd.getBeanClassName());
        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");
        Assert.assertNotNull(petStore);

    }
}
