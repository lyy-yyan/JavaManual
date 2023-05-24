package com.lyy.test;

import com.lyy.entity.Order;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
    @Test
    public void testOrder() {

        KieServices kieServices = KieServices.Factory.get();
        // 获取Kie容器对象
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        // 从Kie容器对象中获取会话对象
        KieSession session = kieContainer.newKieSession();

        // Fact对象(事实对象)
        Order order = new Order();
        order.setOriginalPrice(500d);

        // 插入Fact
        session.insert(order);

        // 激活规则，由Drools框架自动进行规则匹配，如果匹配成功，则执行当前规则
        session.fireAllRules();

        // 关闭会话
        session.dispose();
    }
}
