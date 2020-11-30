package interpreter.bytecode;

import interpreter.VirtualMachine;


import java.util.ArrayList;

public class PopCode extends ByteCode {

    private int toPop;

    @Override
    public void init(ArrayList<String> args) {
        this.toPop = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
    for(int i = 0; i < toPop; i++){
            vm.askRunStackPop();
        }
    }
}
