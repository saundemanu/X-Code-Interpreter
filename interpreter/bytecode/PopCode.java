package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    @Override
    public void execute(VirtualMachine vm) {
    for(int i = 0; i < iarg; i++){
            vm.askRunStackPop();
        }
    }
}
