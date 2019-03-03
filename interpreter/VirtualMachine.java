package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.GotoCode;
import interpreter.bytecode.ReturnCode;

import java.util.Stack;

public class  VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs = new Stack<Integer>();
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
        pc = 0;
//        for(int i = 0; i < this.program.getSize(); i++){
//            System.out.println(program.getCode(i).getClass());
//        }

        while (isRunning) {
            ByteCode code = program.getCode(pc);
           System.out.println(code.getClass());
//           if(code instanceof CallCode) System.out.println(((CallCode) code).getLabel() + "|" + pc );
           code.execute(this);
            if(dump){
            }
            pc++;
        }
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }


    public void pushReturnStack(){
        this.returnAddrs.push(pc);
    }

    public int popReturnAddrs() {
        return (int)returnAddrs.pop();
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
            System.out.println("Error: " + e.getMessage());
        }
        return topOfStack;
    }

    public int askRunStackPeek() {
        int topOfStack = -999;
        try {
            topOfStack = runStack.peek();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
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
            System.out.println("Error:" + e.getMessage());
        }
    }
}
