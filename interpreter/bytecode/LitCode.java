package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LitCode extends MemOperationByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        vm.askRunStackPush(iarg);
    }
}
