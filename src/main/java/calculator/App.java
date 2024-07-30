package calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성

        boolean flag = true;

        while (flag) {
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
                continue;
            }

            while (true) {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, remove 입력 시 0번째 index 삭제, inquiry 입력 시 출력)");
                String input = sc.nextLine();

                if (input.equals("exit")) {
                    flag = false;
                    break;
                } else if (input.equals("remove")) {
                    calculator.removeResult();  // 가장 먼저 저장된 결과를 삭제
                    System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
                } else if (input.equals("inquiry")) {
                    calculator.inquiryResults();  // 저장된 결과를 조회
                } else {
                    break;
                }
            }
        }
        sc.close();
    }
}
