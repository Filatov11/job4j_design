package ru.job4j.io;


import java.io.*;
import java.nio.charset.Charset;
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
    private static final String MASK = "yyyy-mm-dd hh:mm:ss";
    //  private static  HashMap<String, String> answerMap ;
    private List<String> phrases = new ArrayList<>(100);
    private List<String> log = new LinkedList<>();

    public void readFile() {
        BufferedReader objReader = null;
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(BOT_ANSWER, Charset.forName("WINDOWS-1251")));
            while ((strCurrentLine = objReader.readLine()) != null) {
                phrases.add(strCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null) {
                    objReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void writeFile(String path, List<String> list) {
        String data;
        for (String dat : list) {
            try (BufferedWriter br = new BufferedWriter(
                    new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
                br.write(dat + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public String getAnswer() {
        String answer;
        answer = phrases.get((new Random()).nextInt(phrases.size()));
        return answer;
    }

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        readFile();
        for (String str : phrases) {
            System.out.println(str);
        }

        boolean isContinue = true;
        System.out.println("Hello! Let's talk!!!");
        Scanner scan = new Scanner(System.in);
        while (isContinue) {
            UsageEncoding encoding = new UsageEncoding();
            String input = scan.nextLine();
            if (input.equalsIgnoreCase(OUT)) {
                System.out.println(getAnswer());
                log.add(String.format((new SimpleDateFormat(MASK)).format(Calendar.getInstance().getTime())
                        + "  || "
                        + "Question " + input + " bot  answer: " + getAnswer()));
                break;
            } else if (input.equalsIgnoreCase(STOP)) {
                log.add(String.format((new SimpleDateFormat(MASK)).format(Calendar.getInstance().getTime())
                        + "  || "
                        + "Question " + input + " bot  answer: " + getAnswer()));
                continue;
            } else if (input.equalsIgnoreCase(CONTINUE)) {

                System.out.println(getAnswer());
                log.add(String.format((new SimpleDateFormat(MASK)).format(Calendar.getInstance().getTime())
                        + "  || "
                        + "Question "
                        + input
                        + " bot  answer: "
                        + getAnswer()));
            }
        }
        writeFile(BOT_DIALOG, log);
    }


    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(BOT_ANSWER, BOT_DIALOG);
        cc.run();
    }
}
