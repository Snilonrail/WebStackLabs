import model.StorageUser;
import storageImpl.NTFSStorage;
import storageImpl.S3Storage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.asList(
                new StorageUser("user1", NTFSStorage.getInstance()),
                new StorageUser("user2", NTFSStorage.getInstance()),
                new StorageUser("user3", S3Storage.getInstance()),
                new StorageUser("user4", NTFSStorage.getInstance()),
                new StorageUser("user5", S3Storage.getInstance()),
                new StorageUser("user6", S3Storage.getInstance())
        );
    }
}