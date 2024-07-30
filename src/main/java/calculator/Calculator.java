package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 리스트 필드, 외부에서 직접 접근하지 못하도록 private으로 설정
    private List<Double> results;

    // 생성자: 결과 리스트를 초기화
    public Calculator() {
        this.results = new ArrayList<>();
    }

    // 연산 수행 메서드
    public double calculate(int a, int b, char operator) throws DivisionByZeroException, InvalidOperatorException {
        double result;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new DivisionByZeroException("Cannot divide by zero");
                }
                result = (double) a / b;
                break;
            default:
                throw new InvalidOperatorException("Invalid operator: " + operator);
        }

        // 연산 결과를 리스트에 저장
        results.add(result);
        return result;
    }

    // Getter 메서드: 연산 결과를 반환
    public List<Double> getResults() {
        return new ArrayList<>(results);  // List의 복사본을 반환하여 외부에서 수정할 수 없도록 함
    }

    // Setter 메서드: 연산 결과를 직접 수정할 수 있는 메서드
    public void setResults(List<Double> results) {
        if (results != null) {
            this.results = new ArrayList<>(results);  // 리스트 복사본으로 설정하여 직접 수정 방지
        }
    }

    // 가장 먼저 저장된 결과를 삭제하는 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);  // 리스트의 첫 번째 요소를 삭제
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 저장된 결과를 조회하는 메서드
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("조회할 결과가 없습니다.");
        } else {
            System.out.println("결과 리스트: ");
            for (Double num : results) {
                System.out.println(num);
            }
        }
    }
}
