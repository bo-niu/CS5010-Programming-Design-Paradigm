package assignment7;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException, ParseException, UndefinedNonTerminalException {
        Scanner scanner = new Scanner(System.in);
        File[] grammarFileArray = null;
        List<Grammar> grammarList = new ArrayList<>();

        while (grammarFileArray == null) {
            System.out.println("Enter grammar folder name:");
            String folderName = scanner.nextLine();
            File folder = new File("src/main/resources/" + folderName);
            grammarFileArray = folder.listFiles();
        }

        List<File> grammarFileList = new ArrayList<>();
        for (File file : grammarFileArray) {
            if (!file.getName().endsWith("DS_Store"))
                grammarFileList.add(file);
        }

        System.out.println("Loading grammars...\n");
        StringBuilder welcomeMsg = new StringBuilder("The following grammars are available:\n");
        for (int i = 0; i < grammarFileList.size(); i++) {
            ReadGrammar readGrammar = new ReadGrammar(grammarFileList.get(i).getPath());
            Grammar grammar = new Grammar(readGrammar.load());
            grammarList.add(grammar);
            String entry = i + 1 + "." + grammarFileList.get(i).getName().replaceFirst("[.][^.]+$", "") + "\n";
            welcomeMsg.append(entry);
        }

        while (true) {
            System.out.println(welcomeMsg);
            System.out.println("Which would you like to use? (q to quit)");
            String cmd = scanner.nextLine();
            if ("q".equals(cmd)) System.exit(0);
            if (cmd.matches("[1-" + grammarList.size() + "]")) {
                Grammar chosenGrammar = grammarList.get(Integer.parseInt(cmd) - 1);
                String repeat;
                do {
                    String start = chosenGrammar.getProduction("start");
                    Expression expression = new NonTerminalExpression(start);
                    try {
                        String result = expression.interpreter(chosenGrammar);
                        System.out.println("\n" + result);
                    } catch (UndefinedNonTerminalException e) {
                        System.out.println(e.getMsg());
                    }
                    System.out.println("\nWould you like another? (y/n)");
                    repeat = scanner.nextLine();
                } while (!"n".equals(repeat));
            }
        }
    }
}
