package com.niit.enumTest;

public enum CarFactory {
	
	FordCar,BuickCar; //定义工厂类能生产汽车的类型
	
	//生产汽车
	public Car create() {
		switch (this) {
			case FordCar:
				return new FordCar();
			case BuickCar:
				return new BuickCar();
			default:
				throw new AssertionError("无效参数");
		}
	}
	
	public static void main(String[] args) {
		Car car = CarFactory.BuickCar.create();
	}
}
