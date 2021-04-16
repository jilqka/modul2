import java.util.Scanner;
import java.util.Stack;

public class Stack_8_5 {
    public static void main(String[] args) {
        System.out.println("Enter an expression");
        Scanner sc=new Scanner(System.in);
        String expression= sc.nextLine();
        try{
            System.out.println(evaluateExpression(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static int evaluateExpression(String expression) {
        Stack<Integer> operandStack=new Stack<>();
        expression=insertBlanks(expression);
        String[] tokens=expression.split(" ");
        for (String token : tokens) {
            if (token.charAt(0)=='+'||token.charAt(0)=='-'||token.charAt(0)=='*'||token.charAt(0)=='/'){
            processAnOperator(operandStack,token.charAt(0));
            }
            else {
                operandStack.push(Integer.valueOf(token));
            }
        }
        return operandStack.pop();

    }

    private static void processAnOperator(Stack<Integer> operandStack, char op) {
        int op1=operandStack.pop();
        int op2=operandStack.pop();
        if (op=='+'){
            operandStack.push(op1+op2);
        }
        else if (op=='-'){
            operandStack.push(op2-op1);
        }
        else if (op=='*'){
            operandStack.push(op1*op2);
        }
        else  if (op=='/'){
            operandStack.push(op2/op1);
        }
    }

    private static String insertBlanks(String expression) {
        String result="";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*'||expression.charAt(i)=='/'){
                result+=" "+expression.charAt(i)+" ";
            }
            else {
                result+= String.valueOf(expression.charAt(i));
            }
        }
        return result;
    }
}
