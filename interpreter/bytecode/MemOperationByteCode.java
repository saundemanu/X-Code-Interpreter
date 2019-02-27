package interpreter.bytecode;

public abstract class MemOperationByteCode extends ByteCode {

    public void init(int arg1, String comment) {
    this.iarg = arg1;
    this.sarg = comment;
    }

}
//LOAD, LIT, STORE