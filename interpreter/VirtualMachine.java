package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class  VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram(){
    try{
        for(pc = 0 ; pc < this.program.getSize(); pc++ ){
            program.getCode(pc).execute();
        }
    }
    catch(Exception e){
    System.out.println("Error: " + e.getMessage());
    }

    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

}
