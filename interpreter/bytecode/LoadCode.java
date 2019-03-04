package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends  MemOperationByteCode {

    private int intArg;

    @Override
    public void execute(VirtualMachine vm) {
        vm.askRunStackLoad(getIntArg());
    }
}
