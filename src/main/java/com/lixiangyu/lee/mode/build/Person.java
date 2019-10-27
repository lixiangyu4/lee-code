package com.lixiangyu.lee.mode.build;

/**
 * @program: leecode
 * @description: 构建器模式
 * @author: lixiangyu
 * @create: 2019-05-21 16:42
 **/
public class Person {

    private String name;
    private Integer age;

    public Person(PersonBuild personBuild) {
        this.name = personBuild.name;
        this.age = personBuild.age;
    }

    private static class PersonBuild {
        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public PersonBuild setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public PersonBuild setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }

    /**
     * 构建器模式，简化代码
     * @param args
     */
    public static void main(String[] args) {
        Person aa = new PersonBuild().setAge(11).setName("aa").build();
        System.out.println(aa);
    }

}
