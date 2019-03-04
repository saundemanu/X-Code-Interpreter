package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends JumpByteCode{


    @Override
    public void execute(VirtualMachine vm) {
    if(vm.askRunStackPop() == 0){
    vm.jump(this.getAddress());
    }
    }
}
