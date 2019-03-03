package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends JumpByteCode{

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnStack();
        vm.jump(this.getAddress());
    }
}
