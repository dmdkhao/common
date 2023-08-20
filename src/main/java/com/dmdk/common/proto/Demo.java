package com.dmdk.common.proto;

public class Demo {
    public static void main(String[] args) {
        PersonP.Person zhangsan = PersonP.Person.newBuilder()
                .setId(20)
                .setName("zhangsan")
                .build();
        System.out.println(zhangsan.getName());

    }
}
