import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MessageAppCore1 {

    String userN;
    String passW;
    String fName;
    String lName;
    String cell;

    String inUser;
    String inPass;

    String sUser;
    String sPass;
    String sFirst;
    String sLast;
    String sCell;

    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> disregardedMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();

    public MessageAppCore1(String u, String p, String f, String l, String c) {
        this.userN = u;
        this.passW = p;
        this.fName = f;
        this.lName = l;
        this.cell = c;
    }

    public boolean nameCheck() {
        return userN.contains("_") && userN.length() <= 5;
    }

    public boolean passCheck() {
        return passW.length() >= 8 &&
               passW.matches(".*[A-Z].*") &&
               passW.matches(".*[0-9].*") &&
               passW.matches(".*[^a-zA-Z0-9].*");
    }

    public boolean numCheck() {
        return cell.matches("(\\+27|0)[6-8][0-9]{8}");
    }

    public String userReg() {
        if (!nameCheck()) {
            return "Invalid username: must include an underscore and be no longer than 5 characters.";
        }
        if (!passCheck()) {
            return "Invalid password: must be at least 8 characters, with one uppercase letter, number, and symbol.";
        }
        if (!numCheck()) {
            return "Cell number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }

        sUser = userN;
        sPass = passW;
        sFirst = fName;
        sLast = lName;
        sCell = cell;

        return "Username stored successfully\nPassword stored successfully";
    }

    public boolean authCheck() {
        return inUser.equals(sUser) && inPass.equals(sPass);
    }

    public String login(String user, String pass) {
        this.inUser = user;
        this.inPass = pass;

        if (authCheck()) {
            return "Welcome back, " + sFirst + " " + sLast + "!";
        } else {
            return "Access denied: incorrect username or password.";
        }
    }

    public static void showReport() {
        StringBuilder sb = new StringBuilder("--- Sent Message Report ---\n");
        for (String entry : sentMessages) {
            sb.append(entry).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static String findLongestMessage() {
        String longest = "";
        for (String msg : sentMessages) {
            String[] parts = msg.split("\\nMessage: ");
            if (parts.length > 1 && parts[1].length() > longest.length()) {
                longest = parts[1];
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String fn = JOptionPane.showInputDialog("First Name:");
        String ln = JOptionPane.showInputDialog("Last Name:");
        String cn = JOptionPane.showInputDialog("Cell Number (+27... or 0...):");
        String un = JOptionPane.showInputDialog("Create Username:");
        String pw = JOptionPane.showInputDialog("Create Password:");

        MessageAppCore1 core = new MessageAppCore1(un, pw, fn, ln, cn);
        String reg = core.userReg();
        JOptionPane.showMessageDialog(null, reg);

        if (!reg.contains("successfully")) {
            return;
        }

        String logU = JOptionPane.showInputDialog("Username:");
        String logP = JOptionPane.showInputDialog("Password:");
        JOptionPane.showMessageDialog(null, core.login(logU, logP));

        if (!core.authCheck()) {
            return;
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        int totalMsgs = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            String[] choices = {"Send Messages", "Advanced Options", "Quit"};
            int opt = JOptionPane.showOptionDialog(null, "Choose an option:", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);

            switch (opt) {
                case 0:
                    int msgLimit = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
                    int sent = 0;
                    while (sent < msgLimit) {
                        String rec;
                        String recCheck;
                        do {
                            rec = JOptionPane.showInputDialog("Enter recipient number (+27...):");
                            RefMsg refMsgTemp = new RefMsg(sent + 1, rec, "");
                            recCheck = refMsgTemp.numValidate();
                            if (!recCheck.contains("successfully")) {
                                JOptionPane.showMessageDialog(null, recCheck);
                            }
                        } while (!recCheck.contains("successfully"));

                        String text;
                        do {
                            text = JOptionPane.showInputDialog("Enter message (max 250 characters):");
                            if (text != null && text.length() > 250) {
                                JOptionPane.showMessageDialog(null, "Message is too long. Please enter 250 characters or fewer.");
                            }
                        } while (text != null && text.length() > 250);

                        RefMsg msgObj = new RefMsg(sent + 1, rec, text);
                        String summary = msgObj.showMsg();
                        JOptionPane.showMessageDialog(null, summary);

                        String action = msgObj.menu();
                        JOptionPane.showMessageDialog(null, action);

                        switch (action) {
                            case "Message successfully sent.":
                                sentMessages.add(summary);
                                messageHashes.add(msgObj.msgHash());
                                messageIDs.add(msgObj.msgID);
                                sent++;
                                break;
                            case "Message deleted.":
                                disregardedMessages.add(summary);
                                break;
                            case "Message successfully stored.":
                                storedMessages.add(summary);
                                break;
                        }
                    }
                    totalMsgs += sent;
                    JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMsgs);
                    break;

                case 1:
                    String[] advOpts = {"Show All Sent", "Search by ID", "Search by Recipient", "Delete by Hash", "Show Longest", "Show Report", "Back"};
                    int advChoice = JOptionPane.showOptionDialog(null, "Choose advanced option:", "Advanced Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, advOpts, advOpts[0]);

                    switch (advChoice) {
                        case 0:
                            JOptionPane.showMessageDialog(null, String.join("\n\n", sentMessages));
                            break;
                        case 1:
                            String idSearch = JOptionPane.showInputDialog("Enter Message ID:");
                            for (String entry : sentMessages) {
                                if (entry.contains("MessageID: " + idSearch)) {
                                    JOptionPane.showMessageDialog(null, entry);
                                    break;
                                }
                            }
                            break;
                        case 2:
                            String recSearch = JOptionPane.showInputDialog("Enter recipient number:");
                            StringBuilder found = new StringBuilder();
                            for (String entry : sentMessages) {
                                if (entry.contains("Recipient: " + recSearch)) {
                                    found.append(entry).append("\n\n");
                                }
                            }
                            JOptionPane.showMessageDialog(null, found.toString());
                            break;
                        case 3:
                            String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
                            sentMessages.removeIf(entry -> entry.contains("Message Hash: " + hash));
                            JOptionPane.showMessageDialog(null, "Deleted message with hash: " + hash);
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Longest Message: " + findLongestMessage());
                            break;
                        case 5:
                            showReport();
                            break;
                        case 6:
                        default:
                            break;
                    }
                    break;

                case 2:
                default:
                    keepRunning = false;
                    break;
            }
        }
    }
}

class RefMsg {
    public String msgID;
    private int order;
    private String to;
    private String body;

    public RefMsg(int ord, String to, String body) {
        this.msgID = createID();
        this.order = ord;
        this.to = to;
        this.body = body;
    }

    private String createID() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(r.nextInt(10));
        }
        return sb.toString();
    }

    public String lenCheck() {
        int l = body.length();
        return l <= 250 ? "Message ready to send." : "Message exceeds 250 characters by " + (l - 250) + ", please reduce size.";
    }

    public String verifyMessageIDExists() {
        return (msgID != null && !msgID.isEmpty()) ? "Message ID generated: " + msgID : "Message ID not generated";
    }

    public String numValidate() {
        return to.matches("\\+27[0-9]{9}") ? "Cell phone number successfully captured." :
               "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String msgHash() {
        String[] split = body.trim().split("\\s+");
        if (split.length < 2) return "INVALID HASH";
        String f = split[0].toUpperCase();
        String l = split[split.length - 1].toUpperCase();
        return msgID.substring(0, 2) + ":" + order + ":" + f + l;
    }

    public String menu() {
        String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Message Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        return actionReply(options[choice]);
    }

    public String actionReply(String option) {
        switch (option) {
            case "Send Message": return "Message successfully sent.";
            case "Disregard Message": return "Message deleted.";
            case "Store Message to send later": saveMsg(); return "Message successfully stored.";
            default: return "Invalid decision.";
        }
    }

    public String showMsg() {
        return "MessageID: " + msgID +
               "\nMessage Hash: " + msgHash() +
               "\nRecipient: " + to +
               "\nMessage: " + body;
    }

    public void saveMsg() {
        Map<String, String> map = new HashMap<>();
        map.put("MessageID", msgID);
        map.put("MessageHash", msgHash());
        map.put("Recipient", to);
        map.put("Message", body);

        try (FileWriter file = new FileWriter("stored_messages.json", true)) {
            ObjectWriter writer = new ObjectMapper().writer();
            String json = writer.writeValueAsString(map);
            file.write(json + System.lineSeparator());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while storing the message: " + e.getMessage());
        }
    }
}
