package domain;
import java.util.Scanner;

public class Racing {
	private Car cars[];
	private String carNames[];
	int length;
	
	public Racing() {
		init();
	}
	
	void init() {
		MakeCar();
	}
	
	void MakeCar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String names = sc.next();
		carNames = names.split(",");
		cars = new Car[carNames.length];
		
		for(int i=0 ; i<carNames.length ; i++) {
			cars[i] = new Car(carNames[i]);
		}
	}
	
}
