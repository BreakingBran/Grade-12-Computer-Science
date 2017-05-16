package dataBase;

import java.util.*;

interface Command {
    String runCommand();
}

public class testing {

    public static void main(String[] args) throws Exception {
       /* Map<Character, Command> methodMap = new HashMap<Character, Command>();

        methodMap.put('h', new Command() {
            public String runCommand() { return "Hello"; };
        });

        methodMap.put('t', new Command() {
            public String runCommand() { return "Hello"; };
        });

        char cmd = 'h';
        methodMap.get(cmd).runCommand();  // prints "Help"

        cmd = 't';
        methodMap.get(cmd).runCommand();  // prints "teleport"
*/
      
      Boolean yellow = true;
      if (yellow.booleanValue() == true){
        System.out.println(yellow.booleanValue());
      }
    }
}
