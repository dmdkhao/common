package com.dmdk.common.yitter;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;

public class IdUtil {
    static {
        IdGeneratorOptions options = new IdGeneratorOptions((short) 2);
        YitIdHelper.setIdGenerator(options);
    }

    public static void main(String[] args) {
        long newId = genId();
        System.out.println(newId);

    }
    public static long genId() {
        long newId = YitIdHelper.nextId();
        return newId;
    }
}
