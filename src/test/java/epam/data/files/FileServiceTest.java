package epam.data.files;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileServiceTest {

    FileService fileService = new FileService();

    @Test
    void replaceSimilarFiles() throws IOException {
        Path file1 = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\1.txt");
        Path file3 = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\2.txt");
        Path file2 = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\inner\\1.txt");
        System.out.println(System.identityHashCode(file1));
        System.out.println(System.identityHashCode(file2));
        System.out.println(System.identityHashCode(file3));
//        Assertions.assertEquals(System.identityHashCode(file1), System.identityHashCode(file2));
        fileService.replaceSimilarFiles("src\\test\\resources\\inner");
        Path file1a = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\1.txt");
        Path file3a = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\2.txt");
        Path file2a = Paths.get("C:\\Users\\Stern\\IdeaProjects\\data\\src\\test\\resources\\inner\\1.txt");
        System.out.println(System.identityHashCode(file1a));
        System.out.println(System.identityHashCode(file2a));
        System.out.println(System.identityHashCode(file3a));
    }
}