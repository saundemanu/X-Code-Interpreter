package interpreter;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public Integer pop() throws Exception{
        if(runTimeStack.size() <= 1)
    return runTimeStack.remove(runTimeStack.size()-1);
        else throw new EmptyStackException();
    }

    public Integer push(Integer newArg) throws Exception{
         runTimeStack.add(newArg);
         return this.peek();
    }

    public void dump(){

    }

    public Integer peek() throws Exception{
        if(runTimeStack.size() <= 1)
            return runTimeStack.get(runTimeStack.size() - 1);
        else throw new EmptyStackException();
    }

   

    public void popFrame(){
    Integer index = runTimeStack.size()-1;
    while(index <= this.getFrameStart()){
        runTimeStack.remove(index);
    }
    framePointer.pop();
    }

    public Integer store(int offset)throws Exception{
            Integer currentFrame = getFrameStart();
            Integer value = this.pop();
            runTimeStack.add(currentFrame + offset, value);
            return value;
    }

    public void load(int offset){
    Integer currentFrame = this.getFrameStart();
    Integer temp = runTimeStack.get(currentFrame + offset);
    Integer topOfStack =  runTimeStack.get(runTimeStack.size() - 1);
    runTimeStack.set(currentFrame + offset, topOfStack);
    runTimeStack.set(runTimeStack.size()-1, temp);

    }



    public void newFrameAt(int offset){
        if(runTimeStack.size() <= offset)
            framePointer.push(runTimeStack.size() - offset);
        else throw new EmptyStackException();
}

    public Integer getFrameStart(){
    return this.framePointer.peek();
    }

}


