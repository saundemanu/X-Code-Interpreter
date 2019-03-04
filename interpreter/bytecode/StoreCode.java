package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends MemOperationByteCode{

    private int offset;

    @Override
    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.askRunStackStore(offset);

    }
}
