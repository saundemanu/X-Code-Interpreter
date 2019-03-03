package interpreter.bytecode;

import interpreter.VirtualMachine;

public class DumpCode extends ByteCode {
    @Override
    public void execute(VirtualMachine vm) {
        if(sarg.equals("ON"))
        vm.setDump(true);
        else{
            vm.setDump(false);
        }
    }
}
