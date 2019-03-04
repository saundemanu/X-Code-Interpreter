package interpreter;

import interpreter.bytecode.*;


import java.util.EmptyStackException;
import java.util.Stack;

public class  VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {
        this.setRunning(true);
        runStack = new RunTimeStack();
        this.pc = 0;
        returnAddrs = new Stack<>();
        int pcBeforeExe;
        while (isRunning) {
            pcBeforeExe = pc;
            ByteCode code = program.getCode(this.pc);
            System.out.println(code.getClass());

            code.execute(this);
            if(dump){
                runStack.dump();
            }
            if(pc == pcBeforeExe) this.pc++;
        }
    }

    public void pushReturnStack(){
        this.returnAddrs.push(this.pc + 1);
    }

    public int popReturnStack(){
        if(returnAddrs.size() >= 1) return this.returnAddrs.pop();
    throw new EmptyStackException();
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }

    public void askRunStackPush(int newArg) {
      try {
          this.runStack.push(newArg);
      }
      catch (Exception e){
          System.out.println(e.getMessage());
      }
    }

    public int askRunStackPop() {
        int topOfStack = -999;
        try {
           topOfStack = runStack.pop();
        } catch (Exception e) {
            System.out.println("Error Popping Stack: " + e.getMessage());
        }
        return topOfStack;
    }

    public int askRunStackPeek() {
        int topOfStack = -999;
        try {
            topOfStack = runStack.peek();
        } catch (Exception e) {
            System.out.println("Error Peeking Stack: " + e.getMessage());
        }

        return topOfStack;
    }
    public void askNewFrame(int offset){
        runStack.newFrameAt(offset);
    }

    public void askPopFrame(){ runStack.popFrame();}

    public void jump(int address){
        this.pc = address;
    }

    public void askRunStackLoad(int offset){
        this.runStack.load(offset);
    }

    public void askRunStackStore(int offset){
        try {
            this.runStack.store(offset);
        }catch (Exception e){
            System.out.println("Error Storing:" + e.getMessage());
        }
    }
}
