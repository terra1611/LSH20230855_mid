import java.util.Scanner;
import java.util.Random;

public class LSH20230855_mid2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ra = new Random();

        int goal = 0;

        //게임 설명 출력
        System.out.println("이 게임은 총 n개의 계단을 오르면 승리하는 게임입니다.");
        System.out.println("이기면 1칸 상승, 지면 1칸 하강 합니다.");

        //목표 칸 수 입력 (2~5)
        while (goal < 2 || goal > 5) {
            System.out.print("몇 칸을 오르면 승리로 할까요? (2~5 입력): ");
            goal = sc.nextInt();
            if (goal < 2 || goal > 5) {
                System.out.println("2~5 사이의 숫자를 입력해 주세요.");
            }
        }

        int ul = 0; //사용자 위치 (userlocation)
        int cl = 0; //컴퓨터 위치 (comloaction)

        while (ul < goal && cl < goal) {
            System.out.println("가위(0), 바위(1), 보(2) 중 하나를 숫자로 입력하세요.");
            int user = sc.nextInt();
            int computer = ra.nextInt(3);

            //잘못된 숫자 처리
            if (user < 0 || user > 2) {
                System.out.println("0,1,2 중 하나를 입력해 주세요");
                continue;
            }

            //선택 출력
            System.out.println("당신의 선택: " + change(user));
            System.out.println("컴퓨터의 선택: " + change(computer));

            //승패 판단 & 이동
            if (user == computer) {
                System.out.println("비겼습니다.");
            } else if ((user == 0 && computer == 2) ||
                       (user == 1 && computer == 0) ||
                       (user == 2 && computer == 1)) {
                System.out.println("당신의 승리입니다!");
                if (ul < goal) ul++;
                if (cl > 0) cl--;
            } else {
                System.out.println("당신의 패배입니다..");
                if (cl < goal) cl++;
                if (ul > 0) ul--;
            }

            //위치 출력
            System.out.print("당신: ");
            userlocation(ul, goal);

            System.out.print("컴퓨터: ");
            comlocation(cl, goal);

            System.out.println("----------------------------------");
        }

        if (ul == goal) {
            System.out.println("당신이 계단 끝에 먼저 도달했습니다! 승리!");
        } else {
            System.out.println("컴퓨터가 계단 끝에 먼저 도달했습니다. 패배..");
        }

        sc.close();
    }

    //가위, 바위, 보 > 0,1,2로 바꾸기
    public static String change(int choice) {
        if (choice == 0) return "가위";
        else if (choice == 1) return "바위";
        else if (choice == 2) return "보";
        return "에러";
    }

    //사용자 위치 출력
    public static void userlocation(int step, int goal) {
        for (int i = 0; i < step; i++) {
            System.out.print("o ");
        }
        for (int i = step; i < goal; i++) {
            System.out.print("x ");
        }
        System.out.println();
    }

    //컴퓨터 위치 출력
    public static void comlocation(int step, int goal) {
        for (int i = 0; i < step; i++) {
            System.out.print("o ");
        }
        for (int i = step; i < goal; i++) {
            System.out.print("x ");
        }
        System.out.println();
    }
}
