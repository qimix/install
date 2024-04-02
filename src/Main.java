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

        makeDir(dirs, files);
        writeLog("C://Games//temp//temp.txt");
    }

    public static void makeDir(List<String> dirs,List<String> files){
        for (String i : dirs) {
            if (new File(i).mkdir()) {
                stringBuilder.append("Директория " + i + " создана" + "\n");
            } else {
                stringBuilder.append("Директорию " + i + " создать не удалось" + "\n");
            }
        }

        try {
            for (String i : files) {
                if (new File(i).createNewFile()) {
                    stringBuilder.append("Файл " + i + " создан" + "\n");
                } else {
                    stringBuilder.append("Не удалось создать файл " + i + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeLog(String logPath){
        try(FileWriter fileWriter = new FileWriter(new File(logPath))) {
            fileWriter.write(stringBuilder.toString().toCharArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
