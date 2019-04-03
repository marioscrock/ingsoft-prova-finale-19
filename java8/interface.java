public interface FastFly extends Fly {
	public default void takeOff(){ 
		System.out.println("FastFly::takeOff");
	}
}

public interface Fly {
	public default void takeOff(){ System.out.println("Fly::takeOff");}
	public default void turn(){ System.out.println("Fly::turn");}
	public default void cruise(){ System.out.println("Fly::cruise");}
	public default void land(){ System.out.println("Fly::land");}
}

public interface Sail {
	public default void cruise(){ System.out.println("Sail::cruise");
}

public class Vehicle {
	public void land(){ System.out.println("Vehicle::land");
}

public class Plane extends Vehicle implements FastFly, Sail {
	public static void main(String[] args){
		Plane plane = new Plane();
		plane.takeOff();
		//metodo della superclasse "supera" implementazione default interfaccia
		//viene chiamata la land di Vehicle
		plane.land();
		plane.cruise();
	}

	//DEVO fare override se ho stesso metodo nelle due interfacce, devo "chiarire"
	//quale chiamare
	@Override
	public void cruise() {
	//Metto il .super poichè non si tratta di metodo statico
	FastFly.super.cruise();
	}
	
}