package calculator;

import java.util.ArrayList;
import java.util.List;

// Calculator 클래스
public class Calculator {
    // 사칙연산 결과를 저장하는 리스트
    private List<Double> results;
    // 원의 넓이 결과를 저장하는 리스트
    private List<Double> circleAreas;

    // 원의 넓이 계산에 필요한 상수 PI
    private static final double PI = 3.141592653589793;

    // 생성자: 결과 리스트들을 초기화
    public Calculator() {
        this.results = new ArrayList<>();
        this.circleAreas = new ArrayList<>();
    }

    // 사칙연산 수행 메서드
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

        // 사칙연산 결과를 리스트에 저장
        results.add(result);
        return result;
    }

    // 원의 넓이를 구하는 메서드
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        double area = PI * radius * radius;
        // 계산된 넓이를 리스트에 저장
        circleAreas.add(area);
        return area;
    }

    // Getter 메서드: 사칙연산 결과를 반환
    public List<Double> getResults() {
        return new ArrayList<>(results); // 리스트의 복사본을 반환하여 외부에서 수정할 수 없도록 함
    }

    // Setter 메서드: 사칙연산 결과를 직접 수정할 수 있는 메서드
    public void setResults(List<Double> results) {
        if (results != null) {
            this.results = new ArrayList<>(results); // 리스트 복사본으로 설정하여 직접 수정 방지
        }
    }

    // Getter 메서드: 원의 넓이 결과를 반환
    public List<Double> getCircleAreas() {
        return new ArrayList<>(circleAreas); // 리스트의 복사본을 반환하여 외부에서 수정할 수 없도록 함
    }

    // Setter 메서드: 원의 넓이 결과를 직접 수정할 수 있는 메서드
    public void setCircleAreas(List<Double> circleAreas) {
        if (circleAreas != null) {
            this.circleAreas = new ArrayList<>(circleAreas); // 리스트 복사본으로 설정하여 직접 수정 방지
        }
    }

    // 가장 먼저 저장된 사칙연산 결과를 삭제하는 메서드
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 리스트의 첫 번째 요소를 삭제
        } else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }

    // 가장 먼저 저장된 원의 넓이 결과를 삭제하는 메서드
    public void removeCircleArea() {
        if (!circleAreas.isEmpty()) {
            circleAreas.remove(0); // 리스트의 첫 번째 요소를 삭제
        } else {
            System.out.println("삭제할 원의 넓이가 없습니다.");
        }
    }

    // 저장된 사칙연산 결과를 조회하는 메서드
    public void inquiryResults() {
        if (results.isEmpty()) {
            System.out.println("조회할 사칙연산 결과가 없습니다.");
        } else {
            System.out.println("사칙연산 결과 리스트: ");
            for (Double num : results) {
                System.out.println(num);
            }
        }
    }

    // 저장된 원의 넓이들을 조회하는 메서드
    public void inquiryCircleAreas() {
        if (circleAreas.isEmpty()) {
            System.out.println("조회할 원의 넓이가 없습니다.");
        } else {
            System.out.println("원의 넓이 리스트: ");
            for (Double area : circleAreas) {
                System.out.println(area);
            }
        }
    }
}
