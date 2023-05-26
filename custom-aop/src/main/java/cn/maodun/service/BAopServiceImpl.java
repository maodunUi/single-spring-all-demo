package cn.maodun.service;

import org.springframework.stereotype.Component;

@Component("b")
public class BAopServiceImpl implements AopService {
	@Override
	public void m() {
		System.out.println("b -BAopServiceImpl");
	}
}
