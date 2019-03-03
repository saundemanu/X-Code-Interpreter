package interpreter.bytecode;

import interpreter.VirtualMachine;

public abstract class ByteCode {

    Integer iarg;
    String sarg;


     public void init(int arg){
         this.iarg = arg;
     }


     public abstract void execute(VirtualMachine vm);


}
