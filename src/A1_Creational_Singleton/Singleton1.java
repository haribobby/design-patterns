package A1_Creational_Singleton;

import java.lang.reflect.Constructor;

public class Singleton1 {

	private static Singleton1 soleInstance = new Singleton1();

//	static {
//		System.out.println("Static block...");
//	}
//
//	{
//		System.out.println("Instance block...");
//	}

	private Singleton1() {
		System.out.println("Creating...");
	}

	public static Singleton1 getInstance() {
		return soleInstance;
	}

}

class Client {

	public static void main(String[] args) throws Exception {

		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		Singleton1 s3 = Singleton1.getInstance();

		print("s1", s1);
		print("s2", s2);
		print("s3", s3);

		// 1. Reflection
		Class clazz = Class.forName("A1_Creational_Singleton.Singleton1");
		Constructor<Singleton1> ctor = clazz.getDeclaredConstructor();
		ctor.setAccessible(true);
		Singleton1 s4 = ctor.newInstance();
		print("s4", s4);

		// 2. Serilaization and De-Serialization

	}

	private static void print(String name, Singleton1 singleton) {

		System.out.println(String.format("Object is : %s and hashcode is : %d", name, singleton.hashCode()));
	}
}
