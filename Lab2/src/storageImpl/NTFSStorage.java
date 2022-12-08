package storageImpl;

import java.nio.ByteBuffer;
import java.util.Objects;

public class NTFSStorage implements Storage {

    private static volatile Storage STORAGE_INSTANCE;

    private NTFSStorage() {
        System.out.println("Created NTFS storage");
    }

    public static Storage getInstance() {
        if (Objects.nonNull(STORAGE_INSTANCE)) {
            return STORAGE_INSTANCE;
        }
        synchronized (NTFSStorage.class) {
            if (Objects.isNull(STORAGE_INSTANCE)) {
                STORAGE_INSTANCE = new NTFSStorage();
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
