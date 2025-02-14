package org.example;
import java.util.*;

import static org.example.Memory.printVariables;
import static org.example.Memory.variables;

public class SlaveCore extends Thread {
   Process currentProcess;
   boolean isIdle;
   String name;

   public SlaveCore() {
      isIdle = true;
   }
   public SlaveCore(String name) {
      this.name = name;
      isIdle = true;
   }

   @Override
    public void run() {
      Scanner scanner = new Scanner(System.in);
      isIdle= currentProcess.burst<=0;
      System.out.println(name+" "+"Process ID: " + currentProcess.pcb.ID);
      ArrayList<String> instruction=currentProcess.instructions.get(currentProcess.pcb.pc++);
      currentProcess.burst--;
     // for (String[] instruction : instructions)
         switch (instruction.get(0)) {
            case "assign":
               handleAssign(instruction, scanner);
               break;
            case "print":
               handlePrint(instruction);
               break;
            default:
               System.out.println("Unknown command: " + String.join(" ", instruction));
         }

            isIdle= currentProcess.burst<=0;
      printVariables();

    }
   public  void handleAssign(ArrayList<String> instruction, Scanner scanner) {
      String variable = instruction.get(1);
      if (instruction.get(2).equals("input")) {
         System.out.print("Enter value for " + variable + ": ");
         int value = scanner.nextInt();
         variables.get(currentProcess.pcb.ID).put(variable, Integer.toString(value));

      } else {
         try {


         String operation = instruction.get(2);
         int value1 =Integer.parseInt( variables.get(currentProcess.pcb.ID).get(instruction.get(3)));
         int value2 = Integer.parseInt( variables.get(currentProcess.pcb.ID).get(instruction.get(4)));
         int result = performOperation(operation, value1, value2);
         variables.get(currentProcess.pcb.ID).put(variable, Integer.toString(result));
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
         } catch (Exception e) {
            System.out.println("Error: Variable " + e.getMessage() + " not found in memory.");
         }
      }
   }

   // Handle 'print' instructions
   public  void handlePrint(ArrayList<String> instruction) {
      String variable = instruction.get(1);
      if (variables.get(currentProcess.pcb.ID).containsKey(variable)) {
         System.out.println(variable + " = " + variables.get(currentProcess.pcb.ID).get(variable));
      } else {
         System.out.println("Error: Variable " + variable + " not found in memory.");
      }
   }

   // Perform arithmetic operations
   public static int performOperation(String operation, int value1, int value2) throws ArithmeticException, IllegalArgumentException {
      switch (operation) {
         case "add":
            return value1 + value2;
         case "subtract":
            return value1 - value2;
         case "multiply":
            return value1 * value2;
         case "divide":
            if (value2 != 0) {
               return value1 / value2;
            } else {
               throw new ArithmeticException("Division by zero.");
            }
         default:
            throw new IllegalArgumentException("Unknown operation: " + operation);
      }
   }

}
