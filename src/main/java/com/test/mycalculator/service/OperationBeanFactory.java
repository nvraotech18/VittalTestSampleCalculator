package com.test.mycalculator.service;

import com.test.mycalculator.operation.IOperation;
import com.test.mycalculator.operation.OperationType;
import com.test.mycalculator.operation.OpertionBeanHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OperationBeanFactory implements ApplicationContextAware, InitializingBean {

    @Autowired
    ListableBeanFactory listableBeanFactory;
    private ApplicationContext applicationContext;
    HashMap<OperationType, IOperation> operationBeanMap = new HashMap<>();

    IOperation getOperationBean(OperationType operationType) {
        return operationBeanMap.get(operationType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initializeOperationTypeBeanMap();

    }

    private void initializeOperationTypeBeanMap() {
        Map<String, Object> operationBeansWithAnnotation = applicationContext.getBeansWithAnnotation(OpertionBeanHandler.class);
        for(String beanName : operationBeansWithAnnotation.keySet()) {
            IOperation operation = listableBeanFactory.getBean(beanName,IOperation.class);
            OpertionBeanHandler beanHandler = listableBeanFactory.findAnnotationOnBean(beanName,OpertionBeanHandler.class);
            OperationType operationType = beanHandler.operationType();
            operationBeanMap.put(operationType,operation);
        }

    }

}
