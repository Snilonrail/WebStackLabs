package storageImpl;

import java.nio.ByteBuffer;
import java.util.Objects;

public class S3Storage implements Storage {

    private static volatile Storage STORAGE_INSTANCE;

    private S3Storage() {
        System.out.println("Created S3Storage");
    }

    public static Storage getInstance() {
        if (Objects.nonNull(STORAGE_INSTANCE)) {
            return STORAGE_INSTANCE;
        }
        synchronized (S3Storage.class) {
            if (Objects.isNull(STORAGE_INSTANCE)) {
                STORAGE_INSTANCE = new S3Storage();
            }
            return STORAGE_INSTANCE;
        }
    }

    @Override
    public void write(String path, ByteBuffer fileContainer) {
    }

    @Override
    public ByteBuffer read(String path, Integer size) {
        return ByteBuffer.allocate(size);
    }
}
