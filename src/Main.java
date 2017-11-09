import java.io.*;

public class Main {

    // Recursively prints an entire directory
    // prefix is used to maintain spacing in a recursive context
    static void printDirectory(PrintWriter out, String dirName, String prefix) {

        File folder = new File(dirName);
        if (!folder.isDirectory()) return; // don't do anything if this isn't a folder
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            String curStr = listOfFiles[i].getName();
            if (listOfFiles[i].isFile()) {
                out.println(prefix + curStr);
            } else if (listOfFiles[i].isDirectory()) {
                out.println(prefix + curStr);
                printDirectory(out, curStr, "--" + prefix);
            }
        }
    }

    public static void main(String[] args) {
        try {
            String origstr = System.getProperty("user.dir");
            String str = origstr;
            System.out.println(str);
            for (int i = str.length() - 1; i >= 0; i--) { // cut out everything before the rightmost '/'
                if (str.charAt(i) == '\\' || str.charAt(i) == '/') {
                    str = str.substring(i + 1, str.length());
                    break;

                }

            }
            try (PrintWriter out = new PrintWriter(new File("DirectoryTree_of_" + str + ".txt"))) {
                //PrintWriter out = new PrintWriter(new File("TESTING.txt"));
                out.println("Directory : " + str);
                printDirectory(out, origstr, "->");
//              out.close();
            }

        } catch(Exception E) { E.printStackTrace(); }

    }
}