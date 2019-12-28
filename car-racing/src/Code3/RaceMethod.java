package Code3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RaceMethod {

	private static Car[] car;
	Scanner scan = new Scanner(System.in);
	private static HashMap<String, Integer> hash = new HashMap<String, Integer>();
	
	
	public void carName() {

		System.out.println("경주할 자동차 이름을 입력하세요.");
		String name = scan.next();
		String[] Carname = name.split(",");
		car = new Car[Carname.length];

		for (int i = 0; i < Carname.length; i++) {
			car[i] = new Car(Carname[i]);

		}

		StartPoint();
	}

	public void StartPoint() {

		System.out.println("시도할 회수는 몇회인가요?");
		int n = scan.nextInt();
		RandomCar(n);
	}

	public void MoveCar() {

		Random r = new Random();

		for (int i = 0; i < car.length; i++) {
			int k = r.nextInt(10);

			if (k > 3) {
				car[i].Move();
			}
			
		}
		
		for (int i = 0; i < car.length; i++) {
			System.out.print(car[i].getName() + ": " );
			for(int j=1;j<=car[i].getPosition();j++) {
				System.out.print("-");
			}
			
			System.out.println();

			hash.put(car[i].getName(), car[i].getPosition());
		}

	}

	public void RandomCar(int n) {

		for (int i = 1; i <= n; i++) {
			MoveCar();

		}

		Winner();
	}

	public void Winner() {

		int max = car[0].getPosition();

		Set<String> keys = hash.keySet();
		for (int i = 0; i < car.length; i++) {
			if (max < car[i].getPosition())
				max = car[i].getPosition();
		}

		for (int i = 0; i < car.length; i++) {
			if (car[i].getPosition() == max) {
				System.out.println(car[i].getName());
				continue;
			}
		}

	}

}
