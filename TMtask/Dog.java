package TMtask;

public class Dog extends Animal {
	
	@Override
	void makeSound()
	{
		System.out.println("Dog is Barking.");
	}
	public static void main(String[] args) {
		Animal animals=new Dog();
		animals.makeSound();
	}
}
