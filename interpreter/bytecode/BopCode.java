package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{

    private String operation;

    public void init(ArrayList<String> args){
        this.operation = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
    Integer op2 = vm.askRunStackPop();
    Integer op1 = vm.askRunStackPop();

    switch(this.operation){
        case "+":
            vm.askRunStackPush(op1+op2);
            break;
        case "-":
            vm.askRunStackPush(op1-op2);
            break;
        case "/":
            vm.askRunStackPush(op1/op2);
            break;
        case "*":
            vm.askRunStackPush(op1*op2);
            break;
        case "==":
            vm.askRunStackPush(boolToInt(op1.equals(op2)));
            break;
        case "!=":
            vm.askRunStackPush(boolToInt(!op1.equals(op2)));
            break;
        case "<=":
            vm.askRunStackPush(boolToInt(op1 <= op2));
            break;
        case ">":
            vm.askRunStackPush(boolToInt(op1 > op2));
            break;
        case ">=":
            vm.askRunStackPush(boolToInt(op1 >= op2));
            break;
        case "<":
            vm.askRunStackPush(boolToInt(op1 < op2));
            break;
        case "|":
            vm.askRunStackPush(boolToInt(op1.equals(1) || op2.equals(1)));
            break;
        case "&":
            vm.askRunStackPush(boolToInt(op1.equals(1) && op2.equals(1)));
            break;


    }


        }
    private Integer boolToInt(boolean bool) {
        if (bool) return 1;
        return 0;
    }
}


