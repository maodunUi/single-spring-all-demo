package cn.maodun.service;

public interface AopService {

    public void m();

    default public String m1(Integer i) {

        return "m1";
    }
}
