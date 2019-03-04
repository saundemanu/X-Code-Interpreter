package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{

    private String label;
    private int address;

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            label = args.get(0);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        this.address = vm.popReturnStack();
       vm.jump(this.address);
    }

    public String getLabel() {
        return label;
    }
}
