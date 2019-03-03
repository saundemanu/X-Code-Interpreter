package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends JumpByteCode{

    @Override
    public void execute(VirtualMachine vm) {
        vm.jump(this.getAddress());
    }
}
