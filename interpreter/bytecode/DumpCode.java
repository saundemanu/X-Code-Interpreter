package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private boolean dumpState = false;

    @Override
    public void init(ArrayList<String> args) {
        switch(args.get(0)){
            case "ON":
                dumpState = true;
                break;
            case "OFF":
                dumpState = false;
                break;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(dumpState);
    }
}
