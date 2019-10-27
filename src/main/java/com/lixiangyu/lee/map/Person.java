package com.lixiangyu.lee.map;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-01-30 17:32
 **/
public class Person {

    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return Objects.equals(getId(), person.getId()) &&
//            Objects.equals(getName(), person.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return 1;
//    }
}
