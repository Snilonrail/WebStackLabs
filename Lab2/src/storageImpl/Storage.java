package storageImpl;

import java.nio.ByteBuffer;

public interface Storage {
    ByteBuffer read(String filePath, Integer fileSize);

    void write(String path, ByteBuffer data_builder);
}
