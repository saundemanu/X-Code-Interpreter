package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {

    private Scanner s;
    private int read;

    @Override
    public void init(ArrayList<String> args) {
        read = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        s = new Scanner(System.in);
        this.read = s.nextInt(); //Int only
        vm.askRunStackPush(this.read);
    }
}
