package acwing.basic.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.HashMap;

public class ExpressionEvaluation_3302 {

    static LinkedList<Integer> num;
    static LinkedList<Character> op;
    static HashMap<Character, Integer> priority;

    static {
        num = new LinkedList<>();
        op = new LinkedList<>();

        priority = new HashMap<>();
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String exp = br.readLine();
        for(int i = 0; i < exp.length(); i ++){
            if(Character.isDigit(exp.charAt(i))){
                int x = 0;
                while(i < exp.length() && Character.isDigit(exp.charAt(i))){
                    x = x * 10 + (exp.charAt(i ++) - '0');
                }
                num.push(x);
                i --;
            }
            else if(exp.charAt(i) == '('){
                op.push('(');
            }
            else if(exp.charAt(i) == ')'){
                while('(' != op.peek()) eval();
                op.pop();
            }
            else{
                while(priority.containsKey(op.peek()) && priority.get(exp.charAt(i)) <= priority.get(op.peek())) eval();
                op.push(exp.charAt(i));
            }
        }
        while(op.size() > 0) eval();
        System.out.println(num.pop());

        br.close();
    }

    static void eval(){
        int b = num.pop(), a = num.pop();
        char c = op.pop();
        int t = 0;
        if(c == '+') t = a + b;
        if(c == '-') t = a - b;
        if(c == '*') t = a * b;
        if(c == '/') t = a / b;
        num.push(t);
    }
}
