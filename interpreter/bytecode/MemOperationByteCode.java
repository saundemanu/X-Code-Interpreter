package interpreter.bytecode;

import java.util.ArrayList;

public abstract class MemOperationByteCode extends ByteCode {



    private int intArg;
    private String strArg;

    public void init(ArrayList<String> args) {
        this.intArg = Integer.parseInt(args.get(0));
        if(args.size() > 1 )
    this.strArg = args.get(1);
    }

    public int getIntArg() {
        return intArg;
    }

    public String getStrArg() {
        return strArg;
    }
}
//LOAD, LIT, STORE