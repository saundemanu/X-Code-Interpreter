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

    public int askStackPop() throws Exception{
        if(runTimeStack.size() <= 1)
    return runTimeStack.remove(runTimeStack.size()-1);
        else throw new EmptyStackException();
    }

    public void askPush(int newArg){
         runTimeStack.add(newArg);
    }


}
