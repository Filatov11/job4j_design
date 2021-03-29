package ru.job4j.io;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String BOT_ANSWER = "/home/aster/IdeaProjects/job4j_design/src/data/answerList.lst";
    private static final String BOT_DIALOG = "/home/aster/IdeaProjects/job4j_design/src/data/dialog.log";
    //  private static  HashMap<String, String> answerMap ;
    private List<String> phrases = new ArrayList<>(100);
    private List<String> log = new LinkedList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        UsageEncoding encodReadFromFile = new UsageEncoding();
        for (String str : phrases) {
            encodReadFromFile.writeDataInFile(BOT_ANSWER, str);
        }


        boolean isContinue = true;
        System.out.println("Hello! Let's talk!!!");
        Scanner scan = new Scanner(System.in);

        while (isContinue) {

            UsageEncoding encoding = new UsageEncoding();
            String input = scan.nextLine();

            if (input.equalsIgnoreCase(OUT)) {
                log.add(String.format(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime()) + "user input: ", input));
                break;
            } else if (input.equalsIgnoreCase(STOP)) {
                log.add(String.format(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime()) + "user input: ", input));
                continue;
            } else if (input.equalsIgnoreCase(CONTINUE)) {

                Scanner scanQuest = new Scanner(System.in);
                String question = scanQuest.nextLine();
                encoding.writeDataInFile(path, question);
                this.botAnswers = phrases.get((int) (Math.random() * phrases.size()));
                System.out.println("botAnswers  : " + this.botAnswers);
                log.add(String.format(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime()) + "Question " + question + " bot  answer: ", this.botAnswers));

                log.add(String.format(new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(Calendar.getInstance().getTime()) + "user input: ", input));

            }
        }
        Files.write(Path.of(BOT_DIALOG), log);
    }


    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(BOT_ANSWER, BOT_DIALOG);
        cc.run();
    }
}
