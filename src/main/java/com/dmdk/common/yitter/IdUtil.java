package com.dmdk.common.yitter;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class IdUtil {
    @Value("${id.worker-id:2}")
    private short workerId;

    public static long genId() {
        long newId = YitIdHelper.nextId();
        return newId;
    }

    @PostConstruct
    public void init() {
        IdGeneratorOptions options = new IdGeneratorOptions(workerId);
        YitIdHelper.setIdGenerator(options);
    }
}
