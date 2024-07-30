package calculator;

import java.util.List;
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
                    List<Double> results = calculator.getResults();
                    if (!results.isEmpty()) {
                        results.remove(0);  // Remove from the returned list copy
                        calculator.setResults(results);  // Update the Calculator's results
                        System.out.println("0번째 index가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                } else if (input.equals("inquiry")) {
                    List<Double> results = calculator.getResults();
                    System.out.println("결과 리스트: ");
                    for (Double num : results) {
                        System.out.println(num);
                    }
                } else {
                    break;
                }
            }
        }
        sc.close();
    }
}
