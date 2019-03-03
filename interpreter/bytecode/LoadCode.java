package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LoadCode extends  MemOperationByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        vm.askRunStackLoad(iarg);
    }
}
