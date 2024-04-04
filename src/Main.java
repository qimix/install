import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        List<String> dirs = new ArrayList<String>();
        dirs.add("C://Games");
        dirs.add("C://Games//src");
        dirs.add("C://Games//res");
        dirs.add("C://Games//savegames");
        dirs.add("C://Games//temp");
        dirs.add("C://Games//src//main");
        dirs.add("C://Games//src//test");
        dirs.add("C://Games//res//drawables");
        dirs.add("C://Games//res//vectors");
        dirs.add("C://Games//res//icons");

        List<String> files = new ArrayList<String>();
        files.add("C://Games//src//main//Main.java");
        files.add("C://Games//src//main//Utils.java");
        files.add("C://Games//temp//temp.txt");

        for (String i : dirs) {
            makeDir(i);
        }

        for (String i : files) {
            makeFiles(i);
        }

        writeLog("C://Games//temp//temp.txt");
    }

    public static void makeDir(String dir) {
        if (new File(dir).mkdir()) {
            stringBuilder.append("Директория " + dir + " создана" + "\n");
        } else {
            stringBuilder.append("Директорию " + dir + " создать не удалось" + "\n");
        }
    }

    static void makeFiles(String file) {
        try {
            if (new File(file).createNewFile()) {
                stringBuilder.append("Файл " + file + " создан" + "\n");
            } else {
                stringBuilder.append("Не удалось создать файл " + file + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeLog(String logPath) {
        if (new File(new File(logPath).getParent()).exists()) {
            try (FileWriter fileWriter = new FileWriter(logPath)) {
                fileWriter.write(stringBuilder.toString().toCharArray());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
