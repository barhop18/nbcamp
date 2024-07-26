package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float[] arr = new float[10];
        int indexNum = 0;

        while(true){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            sc.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            char x = sc.nextLine().charAt(0);
            float result = 0;

            switch (x){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '/':
                    if (num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    result = (float)num1 / num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                default:
                    System.out.println("유효하지 않은 연산 기호입니다.");
                    continue;
            }
            System.out.println("결과: " + result);

            if (indexNum <10){
                arr[indexNum] = result;
                indexNum++;
            }
            else{
                for(int i = 0; i < 9; i++){
                    arr[i] = arr[i+1];
                }
                arr[9] = result;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = sc.nextLine();
            if(input.equals("exit")){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
