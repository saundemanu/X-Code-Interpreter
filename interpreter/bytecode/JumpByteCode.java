package interpreter.bytecode;

public abstract class JumpByteCode extends ByteCode {


    private int address;

    public void init(String label){
        this.sarg = label;
    }

    public int getAddress() {
        return address;
    }

    public String getLabel() {
        return sarg;
    }

    public void setAddress(int address) {
        this.address = address;
    }

}

// FALSEBRANCH, GOTO, CALL, RETURN, LABEL