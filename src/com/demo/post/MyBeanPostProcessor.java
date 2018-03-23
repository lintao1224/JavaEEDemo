package com.demo.post;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.demo.service.IUserService;

public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		 // TODO Auto-generated method stub  
        System.out.println(beanName+"初始化之后进行增强处理。。。");  
        //重新改编userService实例的属性值  
        if(beanName.equals("userService")){  
        	IUserService service=(IUserService) bean;  
            System.out.println("after call userService..."); 
        }  
        return bean;  
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		System.out.println(beanName+"初始化之前进行增强处理。。。");  
		return bean;
	}

}
