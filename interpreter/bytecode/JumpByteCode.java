package interpreter.bytecode;

import java.util.ArrayList;

public abstract class JumpByteCode extends ByteCode {

    private int address;
    private String label;

    @Override
    public void init(ArrayList<String> args){
            this.label = args.get(0);
    }

    public int getAddress() {
        return address;
    }

    public String getLabel() {
        return label;
    }

    public void setAddress(int address) {
        this.address = address;
    }

}

// FALSEBRANCH, GOTO, CALL, RETURN, LABEL