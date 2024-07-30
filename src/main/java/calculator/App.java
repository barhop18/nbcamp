package calculator;

import java.util.Scanner;

// App 클래스
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성

        boolean flag = true;

        while (flag) {
            System.out.println("사칙연산을 진행할까요, 원의 넓이를 구할까요? (enter 'calculation' for 사칙연산, 'circle' for 원의 넓이)");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("calculation")) {
                // 사칙연산 진행
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();
                sc.nextLine();  // Consume newline
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.nextLine().charAt(0);

                try {
                    double result = calculator.calculate(num1, num2, operator);
                    System.out.println("결과: " + result);
                } catch (DivisionByZeroException | InvalidOperatorException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                // 사칙연산 결과 조회
                System.out.println("저장된 사칙연산 결과들:");
                calculator.inquiryResults();

            } else if (choice.equals("circle")) {
                // 원의 넓이 구하기
                System.out.print("원의 반지름을 입력하세요: ");
                double radius = sc.nextDouble();
                sc.nextLine();  // Consume newline

                try {
                    double area = calculator.calculateCircleArea(radius);
                    System.out.println("원의 넓이: " + area);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                // 저장된 원의 넓이 값들 조회
                System.out.println("저장된 원의 넓이 값들:");
                calculator.inquiryCircleAreas();
            } else {
                System.out.println("유효하지 않은 선택입니다.");
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                flag = false;
            }
        }
        sc.close();
    }
}

