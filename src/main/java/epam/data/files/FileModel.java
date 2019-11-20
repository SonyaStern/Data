package epam.data.files;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public class FileModel {

    private byte[] bytes;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FileModel fileModel = (FileModel) obj;
        return Arrays.equals(bytes, fileModel.getBytes());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }
}
