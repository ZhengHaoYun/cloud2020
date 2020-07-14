package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhengHaoYun  2020/7/4 16:48
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    private int incrementAndGetModulo(int serverCount) {
        int current;
        int next;
        do {
            current = nextServerCyclicCounter.get() >= Integer.MAX_VALUE ? 0 : nextServerCyclicCounter.get();
            next = (current + 1) % serverCount;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if (serviceInstances == null || serviceInstances.size() == 0)
            return null;
        int serverCount = serviceInstances.size();
        int nextServerIndex = incrementAndGetModulo(serverCount);
        return serviceInstances.get(nextServerIndex);
    }
}
