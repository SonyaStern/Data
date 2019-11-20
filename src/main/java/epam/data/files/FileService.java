package epam.data.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FileService {

    private final static Map<FileModel, File> FILE_MAP = new HashMap<>();

    void replaceSimilarFiles(String path) throws IOException {
        checkDir(new File(path));
    }

    private void checkDir(File directory) throws IOException {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                checkDir(file);
            } else {
                FileModel fileModel = new FileModel(Files.readAllBytes(file.toPath()));
                if (FILE_MAP.containsKey(fileModel)) {
                    System.out.println(file.getName());
                    file.delete();
                    File targetFile = FILE_MAP.get(fileModel);
                    Path target = Paths.get(targetFile.toURI());
                    Path link = Paths.get(new File("new" + file.getName()).toURI());
                    Files.createLink(link, target);
                } else {
                    FILE_MAP.put(fileModel, file);
                }
            }
        }
    }


}
