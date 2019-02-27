
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.JumpByteCode;
import interpreter.bytecode.MemOperationByteCode;
import interpreter.bytecode.BOPCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private StringTokenizer tokenizer;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() throws Exception {
        String line, code, label;
        int argument;
        Program newProgram = new Program();

        while ((line = byteSource.readLine()) != null) {

            tokenizer = new StringTokenizer(line, " ");
            code = tokenizer.nextToken();
            String className = CodeTable.getClassName(code);
            Class c = Class.forName("interpreter.bytecode." + className);
            ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();

            while (tokenizer.hasMoreElements()) {
                if (bc instanceof BOPCode) {

                } else if (bc instanceof JumpByteCode) {
                    label = tokenizer.nextToken();
                    ((JumpByteCode) bc).init(label);
                } else if (bc instanceof MemOperationByteCode) {
                    argument = (int) tokenizer.nextElement();
                    if (tokenizer.hasMoreElements()) {
                        label = tokenizer.nextToken();
                        ((MemOperationByteCode) bc).init(argument, label);
                    } else {
                        bc.init(argument);
                    }

                }


            }
            newProgram.addByteCode(bc);
        }
        return newProgram;
    }
}
