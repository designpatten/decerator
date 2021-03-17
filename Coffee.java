//咖啡抽象类
abstract class Beverage{
	abstract double cost();
	void description(){
		System.out.println("咖啡描述");
	}
}

/*HouseBlend,DardRoast,Espresso,Decaf 为具体咖啡组件类*/
//混合咖啡
class HouseBlend extends Beverage{
	@Override
	double cost(){
		return 0.99;
	}

	@Override
	void description(){
		System.out.println("HouseBlend Coffee");
	}
}

class DarkRoast extends Beverage{
	@Override
	double cost(){
		return 1.1;
	}

	@Override
	void description(){
		System.out.println("深培咖啡");
	}
}

class Espresso extends Beverage{
	@Override
	double cost(){
		return 2.2;
	}

	@Override
	void description(){
		System.out.println("特浓咖啡");
	}
}

class Decaf extends Beverage{
	@Override
	double cost(){
		return 3.3;
	}

	@Override
	void description(){
		System.out.println("低咖啡因咖啡");
	}
}

/*
抽象装饰类
注意：此处的抽象装饰类与具体咖啡组件同样继承自Beverage，
并不是为了获取到抽象类中的相同方法，而是为了有共同的行为
*/
abstract class CondimentDecorator extends Beverage{
	abstract void description();
}

/*具体装饰类*/
class Milk extends CondimentDecorator{
	Beverage beverage;
	public Milk(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	double cost(){
		return 0.5 + this.beverage.cost();
	}

	@Override
	void description(){
		System.out.println("牛奶");
	}
}

class Mocha extends CondimentDecorator{
	Beverage beverage;
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	double cost(){
		return 0.6 + this.beverage.cost();
	}

	@Override
	void description(){
		System.out.println("摩卡");
	}
}

class Soy extends CondimentDecorator{
	Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage = beverage;
	}

	@Override
	double cost(){
		return 0.7 + this.beverage.cost();
	}

	@Override
	void description(){
		System.out.println("豆浆");
	}
}

class Whip extends CondimentDecorator{
	Beverage beverage;
	public Whip(Beverage beverage){
		this.beverage = beverage;
	}


	@Override
	double cost(){
		return 0.8 + this.beverage.cost();
	}

	@Override
	void description(){
		System.out.println("奶泡");
	}
}


public class Coffee{
	public static void main(String[] args) {
		//来一杯：奶泡+摩卡 味道的 深培咖啡
		Beverage coffee = new DarkRoast();
		// new Whip()
		coffee = new Whip(coffee);
		coffee = new Mocha(coffee);
		double v = coffee.cost();
		System.out.println("v==="+v);

		//来一杯：双倍奶泡+豆浆 口味的 混合咖啡
		Beverage coffee2 = new HouseBlend();
		coffee2 = new Whip(coffee2);
		coffee2 = new Whip(coffee2);
		coffee2 = new Soy(coffee2);
		double v2 = coffee2.cost();
		System.out.println("最终价格v="+v2);
	}
}




