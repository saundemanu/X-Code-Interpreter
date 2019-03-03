package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {


     public abstract void init(int arg);


     public abstract void execute(VirtualMachine vm);


}
