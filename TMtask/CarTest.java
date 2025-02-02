package TMtask;

public class CarTest {
	public static void main(String[] args) {
		Car car=new Car("BMW","iX1 LWB",2025);
		ElectricCar ec=new ElectricCar("Mahindra","XUV 3XO ",2025,400);
		ElectricCar ec2=new ElectricCar("Mahindra","XUV700",2025,400);
		Car[] cars= {car,ec,ec2};
		for(int i=0;i<cars.length;i++) {
			cars[i].startEngine();
			
		}
		
	}

}
