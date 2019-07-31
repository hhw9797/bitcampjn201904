package car;

class CarMain {

	public static void main(String[] args) {

		FireEngine fe = new FireEngine();
		if (fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		}
		if (fe instanceof Car) {
			System.out.println("This is a Car instance.");
		}
		if (fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
	}
} // class

class Car {
}

class FireEngine extends Car {
}