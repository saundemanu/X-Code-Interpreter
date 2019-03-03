package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends MemOperationByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        vm.askRunStackStore(iarg);

    }
}
