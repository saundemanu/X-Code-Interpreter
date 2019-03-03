package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.Scanner;

public class ReadCode extends ByteCode {

    Scanner s;

    @Override
    public void execute(VirtualMachine vm) {
        Scanner s = new Scanner(System.in);
        this.iarg = s.nextInt(); //Int only
        vm.askRunStackPush(this.iarg);
        s.close();
    }
}
