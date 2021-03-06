package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;

public class Analizy {
    boolean currState = false;
    boolean prevState = false;
    String begInterval;
    String endInterval;
    int counter = 0;
    ArrayList<ServerState> sList = new ArrayList<>();

    public boolean isCurrentState() {
        return currState;
    }

    ArrayList<ServerState> unavList = new ArrayList<>();

    public void unavailable(String source, String target) throws FileNotFoundException {
        String line;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while ((line = in.readLine()) != null) {
                if (!checkLine(line)) {
                    fillList(sList, line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        PrintWriter pw = new PrintWriter(new FileOutputStream(target));
        for (ServerState sl : sList)
            pw.println(sl.startInterval + " : " + sl.endInterval + "  ^  " + sl.state);
        pw.close();
    }


    public static boolean checkLine(String resp) {
        return resp.isBlank();
    }

    public boolean serverStatus(String st) {
        boolean res;
        if ((st.equals("400")) || (st.equals("500"))) {
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    public void fillList(ArrayList<ServerState> svList, String record) {
        String status;
        String timeValue;


        int posA = record.indexOf(' ');
        status = record.substring(0, posA);
        timeValue = record.substring(posA + 1);

        if (counter == 0) {
            this.begInterval = timeValue;
            this.endInterval = timeValue;
            this.currState = serverStatus(status);
            this.prevState = serverStatus(status);
            counter++;
        }
        if (serverStatus(status) == this.currState) {
            this.endInterval = timeValue;
        } else {
            this.endInterval = timeValue;

            this.sList.add(new ServerState(this.begInterval, this.endInterval, this.currState));
            this.begInterval = timeValue;
            this.currState = !this.currState;

        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String source = "server.log";
        String target = "target.log";

        Analizy analizy = new Analizy();
        try {
            analizy.unavailable(source, target);
            for (ServerState sl : analizy.sList) {
                System.out.println(sl.startInterval + " : " + sl.endInterval + "  ^  " + sl.state);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class ServerState {
    String startInterval;
    String endInterval;
    boolean state;

    public ServerState(String startInt, String endInt, boolean stat) {
        this.startInterval = startInt;
        this.endInterval = endInt;
        this.state = stat;
    }

    public String getStartInterval() {

        return startInterval;
    }

    public void setStartInterval(String startInterval) {

        this.startInterval = startInterval;
    }

    public String getEndInterval() {

        return endInterval;
    }

    public void setEndInterval(String endInterval) {

        this.endInterval = endInterval;
    }

    public boolean isState() {

        return state;
    }

    public void setState(boolean state) {

        this.state = state;
    }
}