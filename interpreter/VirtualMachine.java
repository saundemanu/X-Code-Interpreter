package interpreter;

import interpreter.bytecode.*;


import java.util.Stack;

public class  VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int programCounter;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    protected void executeProgram() {
        this.setRunning(true);
        runStack = new RunTimeStack();
        this.programCounter = 0;
        returnAddrs = new Stack<>();
        int pcBeforeExe;

        while (isRunning) {
            pcBeforeExe = programCounter;
            ByteCode code = program.getCode(this.programCounter);

            code.execute(this);

            if (dump && !(code instanceof DumpCode)) {
                System.out.println(code);
                runStack.dump();
            }
            if (programCounter == pcBeforeExe) this.programCounter++;
        }
    }

    public String argsAsString() {
        return this.runStack.peekFrame();
    }

    public void pushReturnStack(){
        this.returnAddrs.push(this.programCounter + 1);
    }

    public int popReturnStack(){
        return this.returnAddrs.pop();
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setDump(boolean dump) {
        this.dump = dump;
    }

    public void askRunStackPush(int newArg) {
          this.runStack.push(newArg);
      }

    public int askRunStackPop() {
        return runStack.pop();
    }

    public int askRunStackPeek() {
        return runStack.peek();
    }

    public void askNewFrame(int offset){
        runStack.newFrameAt(offset);
    }

    public void askPopFrame() {
        if (runStack.size() - 1 < runStack.getFrameStart()) {
            runStack.popFrame();
            return;
        }
        Integer i = this.askRunStackPop();
        this.runStack.popFrame();
        this.runStack.push(i);
    }


    public void jump(int address){
        this.programCounter = address;
    }

    public void askRunStackLoad(int offset){
        this.runStack.load(offset);
    }

    public void askRunStackStore(int offset){
            this.runStack.store(offset);
    }

    public void vmReturn() {
        this.askPopFrame();
        this.jump(this.popReturnStack());
    }
}
