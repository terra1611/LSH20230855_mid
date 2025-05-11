import java.util.Scanner;
import java.util.Random;

public class LSH20230855_mid1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();

		//유저 선택
        System.out.println("가위(0), 바위(1), 보(2) 중 하나를 숫자로 입력하세요.");
        int user = sc.nextInt();
        int computer = ra.nextInt(3);
		
		//잘못된 숫자 처리
        if (user < 0 || user > 2) {
            System.out.println("0,1,2 중 하나를 입력해 주세요");
            sc.close();
            return;
        }

        //유저&컴퓨터 출력
        System.out.println("당신의 선택: " + change(user));
        System.out.println("컴퓨터의 선택: " + change(computer));

        //승패
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == 0 && computer == 2) ||
                   (user == 1 && computer == 0) ||
                   (user == 2 && computer == 1)) {
            System.out.println("당신의 승리입니다!");
        } else {
            System.out.println("당신의 패배입니다..");
        }
    }

    //가위, 바위, 보 > 0,1,2로 바꾸기
    public static String change(int choice) {
        if (choice == 0) return "가위";
        else if (choice == 1) return "바위";
		else if (choice == 2) return "보";
        return "에러";
    }
}