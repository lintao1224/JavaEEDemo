package com.demo.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.demo.service.IUserService;

public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 // TODO Auto-generated method stub  
        System.out.println(beanName+"��ʼ��֮�������ǿ��������");  
        //���¸ı�userServiceʵ��������ֵ  
        if(beanName.equals("userService")){  
        	IUserService service=(IUserService) bean;  
            System.out.println("after call userService..."); 
        }  
        return bean;  
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println(beanName+"��ʼ��֮ǰ������ǿ��������");  
		return bean;
	}

}
