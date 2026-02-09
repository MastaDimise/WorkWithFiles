import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //ЗАДАЧА 1: УСТАНОВКА

        StringBuilder finalLog = new StringBuilder();

        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp.

        File src = new File("src");
        if (src.mkdir()) {
            finalLog.append("дериктория  src создана");
        }

        File res = new File("res");
        if (res.mkdir()) {
            finalLog.append("дериктория res создана");
        }

        File savegames = new File("savegames");
        if (savegames.mkdir()) {
            finalLog.append("дериктория savegame создана");
        }

        File temp = new File("temp");
        if (temp.mkdir()) {
            finalLog.append("дериктория temp создана");
        }

        // 2. В каталоге src создайте две директории: main, test.

        File main = new File("/Users/rakaevdmitriy/Desktop/Games/src", "main");
        if (main.mkdir()) {
            finalLog.append("в дериктории src создана дериктория main");
        }

        File test = new File("/Users/rakaevdmitriy/Desktop/Games/src", "test");
        if (test.mkdir()) {
            finalLog.append("в дериктории src создана дериктория test");
        }

        // 3. В подкаталоге main создайте два файла: Main.java, Utils.java

        File fileMain = new File(main, "Main.java");
        try {
            if (fileMain.createNewFile()) {
                finalLog.append("файл Main.java создан");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File fileUtils = new File(main, "Utils.java");
        try {
            if (fileUtils.createNewFile()) {
                finalLog.append("файл Utils.java создан");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // 4. В каталог res создайте три директории: drawables, vectors, icons.

        File darwbles = new File("/Users/rakaevdmitriy/Desktop/Games/res", "drawbles");
        if (darwbles.mkdir()) {
            finalLog.append("в дериктории drawbles создана дериктория res");
        }

        File vectors = new File("/Users/rakaevdmitriy/Desktop/Games/res", "vectors");
        if (vectors.mkdir()) {
            finalLog.append("в дериктории res создана дериктория vectors");
        }
        File icons = new File("/Users/rakaevdmitriy/Desktop/Games/res", "icons");
        if (icons.mkdir()) {
            finalLog.append("в дериктории res создана дериктория icons");
        }

        // 5. В директории temp создайте файл temp.txt.

        File fileTemp = new File(temp, "temp.txt");
        try {
            if (fileTemp.createNewFile()) {
                finalLog.append("файл temp.txt создан");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // создаем лог всей программы
        try (FileWriter writer = new FileWriter("/Users/rakaevdmitriy/Desktop/Games/temp/temp.txt", false)) {
            writer.write(finalLog.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        //ЗАДАЧА 2: СОХРАНЕНИНЕ

        // 1. Создать три экземпляра класса GameProgress.

        GameProgress game1 = new GameProgress(100, 1, 1, 0);
        GameProgress game2 = new GameProgress(99, 1, 1, 10);
        GameProgress game3 = new GameProgress(50, 3, 10, 1000);

        // 2. Сохранить сериализованные объекты GameProgress в папку savegames из предыдущей задачи.

        GameProgress.saveGame(game1);
        GameProgress.saveGame(game2);
        GameProgress.saveGame(game3);

        // 3. Созданные файлы сохранений из папки savegames запаковать в один архив zip.

        List<String> filesToZip = Arrays.asList(
                "/Users/rakaevdmitriy/Desktop/Games/savegames/save1.dat",
                "/Users/rakaevdmitriy/Desktop/Games/savegames/save2.dat",
                "/Users/rakaevdmitriy/Desktop/Games/savegames/save3.dat"
        );
        String zipPath = "/Users/rakaevdmitriy/Desktop/Games/savegames/saves.zip";
        GameProgress.zipFiles(zipPath, filesToZip);

    }
}

