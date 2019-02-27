package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
//     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        for(int i = 0;  i < this.getSize() - 1; i++){
            if(program.get(i) instanceof JumpByteCode){
                String label = ((JumpByteCode) program.get(i)).getLabel();
            for(int j = 0; j < this.getSize(); i++){
                if(program.get(j) instanceof LabelCode &&
                         ((LabelCode) program.get(j)).getLabel().equals(label)){
                        ((JumpByteCode) program.get(i)).setAddress(i);
                }
            }
            }
        }
    }

    protected void addByteCode(ByteCode newByteCode){
        this.program.add(newByteCode);
    }


}
