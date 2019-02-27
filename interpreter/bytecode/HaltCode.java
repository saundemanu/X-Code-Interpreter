package interpreter.bytecode;


public class HaltCode extends ByteCode{


    public HaltCode(){

    }

    @Override
    public void execute() {
        System.exit(1);
    }

}
