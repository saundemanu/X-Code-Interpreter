package interpreter.bytecode;

 public abstract class ByteCode {

    int iarg;
    String sarg;

     public void init(int arg){
         this.iarg = arg;
     }


     public abstract void execute();


}
