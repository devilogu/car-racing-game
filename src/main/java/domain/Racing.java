package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Racing {
	private Car cars[];
	private String carNames[];
	private int k;
	Scanner sc;
	
	public Racing() {
		init();
	}
	
	void init() {
		MakeCar();
		this.k = MakeTryNumber();
	}
	
	void MakeCar() {
		sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String names = sc.next();
		carNames = names.split(",");
		cars = new Car[carNames.length];
		
		for(int i=0 ; i<carNames.length ; i++) 
			cars[i] = new Car(carNames[i]);
		
	}
	
	int MakeTryNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		return sc.nextInt();
	}
	
	void PrintCarsPosition() {
		
		for(int i=0 ; i<cars.length ; i++) {
			System.out.print(cars[i].getName()+" : ");
			for(int j=0 ; j<cars[i].getPosition();j++)
				System.out.print("-");
			System.out.println();
		}
		System.out.println();
	}
	
	void carsMove() {
		int random;
		for(int i=0 ; i<cars.length ; i++) {
			random = (int)(Math.random()*9);
			if(random>3)
				cars[i].move();
		}
	}
	
	void road() {
		System.out.println("실행 결과");
		for(int i=0 ; i < k ; i++) {
			carsMove();		
			PrintCarsPosition();
		}
		findWinner();
		
	}
	
	void findWinner(){
		//position 가장 큰 Car 찾기
		List<String> winners;
		int maxValue = cars[0].getPosition();
		for(int i=0 ; i<cars.length ; i++) {
			if(maxValue < cars[i].getPosition()) {
				maxValue = cars[i].getPosition();
			}
		}
		winners = findCowinner(maxValue);
		for(String w : winners)
			System.out.print(w+" ");
		System.out.println("가 최종 우승했습니다.");
	}
	
	//중복되는 승자 객체 list에 넣기
	List<String> findCowinner(int maxValue) {
		List<String> winners = new ArrayList<String>();
		for(int i=0 ; i<cars.length ;i++) {
			if(maxValue==cars[i].getPosition()) {
				winners.add(cars[i].getName());
			}
		}
		return winners;
	}
	
	
	
}
