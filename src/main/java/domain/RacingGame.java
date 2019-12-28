package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingGame {
	List<Car> carList;
	List<String> winnerList;
	
	int count = 0;

	Scanner sc = new Scanner(System.in);

	public RacingGame() {
		carList = new ArrayList<>();
		winnerList = new ArrayList<>();
	}

	/* 차 이름과 시도 횟수 입력 */
	public void settingGame() {
		inputCarName();
		inputCount();
	}

	/* 자동차 이름 입력 */
	public void inputCarName() {
		String nameList;

		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			nameList = sc.next();

			if (splitCarName(nameList)) {
				break;
			}
		}
	}

	/* 시도할 횟수 입력 */
	public void inputCount() {
		int input;
		
		System.out.println("시도할 횟수는 몇회인가요?");
		input = sc.nextInt();
		
		count = input;
	}
	
	/* 분리된 자동차 이름을 ArrayList에 저장 */
	public void storeCars(String[] names) {
		for(int i=0; i<names.length; i++) {
			carList.add(new Car(names[i]));
		}
	}

	/* 자동차 게임 리스트와 시도할 횟수를 받아 게임 시작, 종료 후 결과 출력 */
	public void run() {
		for (int i = 0; i < count; i++) {
			moveCar();
			printResult();
		}
		getWinner();
	}

	/* 자동차의 이름 쉼표로 구분하여 분리 후 리스트에 저장 */
	public boolean splitCarName(String nameList) {
		String[] names = nameList.split(",");
		
		for (int i = 0; i < names.length; i++) {
			if (!checkCarName(names[i])) {
				return false;
			}
		}
		storeCars(names);
		return true;
	}

	/* 자동차 이름 길이 체크 */
	public boolean checkCarName(String name) {
		return name.length() <= 5;
	}

	/* 랜덤값 생성 */
	public int makeRandomNum() {
		int num = (int) (Math.random() * 9);
		return num;
	}

	/* 랜덤값이 4이상일 경우 true */
	public boolean checkRandomNum(int num) {
		return num >= 4;
	}

	/* 랜덤값에 따라 이동 또는 정지 */
	public void moveCar() {
		for (int i = 0; i < carList.size(); i++) {
			int n = makeRandomNum();
			if (checkRandomNum(n)) {
				carList.get(i).carPosition();
			}
		}
	}

	/* 실행 결과 출력 */
	public void printResult() {
		for (int i = 0; i < carList.size(); i++) {
			System.out.println(carList.get(i).getName() + ":" + carList.get(i).getPosition());
		}
		System.out.println();
	}

	/* 가장 큰 위치값 반환 */
	public int getMaxPosition() {
		int max = 0;

		for (int i = 0; i < carList.size(); i++) {
			if (max < carList.get(i).getPosition()) {
				max = carList.get(i).getPosition();
			}
		}

		return max;
	}

	/* 우승자 리스트에 삽입 */
	public void getWinner() {
		for (int i = 0; i < carList.size(); i++) {
			int maxPosition = getMaxPosition();
			if (carList.get(i).getPosition() == maxPosition) {
				winnerList.add(carList.get(i).getName());
			}
		}
		printWinner();
	}

	public void printWinner() {
		int s = winnerList.size();

		for (int i = 0; i < winnerList.size(); i++) {
			System.out.print(winnerList.get(i));
			if (s-- > 1) {
				System.out.print(",");
			}
		}
		System.out.print("가 최종 우승했습니다.");
	}
}
