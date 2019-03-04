
package interpreter;

import interpreter.bytecode.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    public Program loadCodes() {
        String line, code;
        Program newProgram = new Program();
        ArrayList<String> args = new ArrayList<>();

        try {
            line = byteSource.readLine();
            if (line == null) throw new IOException("File Empty!");

            while (line != null) {
                args.clear();
                tokenizer = new StringTokenizer(line, " ");
                code = tokenizer.nextToken();
                String className = CodeTable.getClassName(code);
                Class c = Class.forName("interpreter.bytecode." + className);
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance();

                while (tokenizer.hasMoreElements()) {
                   args.add(tokenizer.nextToken());
                }
                if(!args.isEmpty()) {
                    bc.init(args);
                }
                newProgram.addByteCode(bc);
                line = byteSource.readLine();
            }
        }catch (Exception e){
            System.out.println("Error loading: " + e.getMessage());
        }
            newProgram.resolveAddrs();

            return newProgram;

    }

}
