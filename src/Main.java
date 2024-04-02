import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        makeDir();
        writeLog();
    }

    public static void makeDir(){
        for (String i : new Data().getDirs()) {
            if (new File(i).mkdir()) {
                stringBuilder.append("Директория " + i + " создана" + "\n");
            } else {
                stringBuilder.append("Директорию " + i + " создать не удалось" + "\n");
            }
        }

        try {
            for (String i : new Data().getFiles()) {
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

    public static void writeLog(){
        try(FileWriter fileWriter = new FileWriter(new File("C://Games//temp//temp.txt"))) {
            fileWriter.write(stringBuilder.toString().toCharArray());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
