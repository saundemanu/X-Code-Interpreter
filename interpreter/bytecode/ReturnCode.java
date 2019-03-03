package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends JumpByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        vm.askPopFrame();
        vm.jump(vm.popReturnAddrs());
    }
}
