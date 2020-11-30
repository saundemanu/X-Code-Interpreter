package interpreter;

import java.util.ArrayList;
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

    public Integer pop() {
        return runTimeStack.remove(runTimeStack.size() - 1);
    }

    public Integer push(Integer newArg) {
        runTimeStack.add(newArg);
        return this.peek();
    }

    public void dump() {

        for (int i = 0; i < framePointer.size(); i++) {
            if (i + 1 < framePointer.size())
                System.out.print(runTimeStack.subList(framePointer.get(i), framePointer.get(i + 1)));
            else {
                System.out.print(runTimeStack.subList(framePointer.get(i), runTimeStack.size()));
            }
        }
        System.out.print("\n");
    }

    public Integer peek() {
            return runTimeStack.get(runTimeStack.size() - 1);

    }



    public void popFrame(){
        if (runTimeStack.size() > 0)
            runTimeStack.subList(framePointer.peek(), runTimeStack.size()).clear();
        framePointer.pop();
    }

    public Integer store(int offset) {
            Integer currentFrame = getFrameStart();
            Integer value = this.pop();
            runTimeStack.add(currentFrame + offset, value);
            return value;
    }

    public void load(int offset){
        int currentFrame = this.getFrameStart();
        int add = runTimeStack.get(offset + currentFrame);
        this.push(add);
    }

    public String peekFrame() {
        StringBuilder s = new StringBuilder();
        for (int i = framePointer.peek(); i < runTimeStack.size() - 1; i++) {
            s.append(runTimeStack.get(i));
            s.append(",");
        }
        if (runTimeStack.size() > 0)
            s.append(runTimeStack.get(runTimeStack.size() - 1));
        return s.toString();
    }

    public void newFrameAt(int offset){
        int index;
        if (runTimeStack.size() < 1) {
            index = 0;
        } else index = ((runTimeStack.size()) - offset);
        framePointer.push(index);
    }

    public Integer getFrameStart(){
    return this.framePointer.peek();
    }

    public int size() {
        return runTimeStack.size();
    }
}


