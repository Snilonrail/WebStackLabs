package proxyDownloaders;

import originalDownloaders.Downloader;
import originalDownloaders.SimpleDownloader;

import java.util.*;

public class SmartDownloader implements Downloader {

    private final Map<String, byte[]> downloadsCache = new HashMap<>();
    private final SimpleDownloader downloader;

    public SmartDownloader(SimpleDownloader downloader) {
        this.downloader = downloader;
    }

    @Override
    public byte[] downloadFile(String fileUrl) {
        if (downloadsCache.containsKey(fileUrl)) {
            System.out.println("extracting file from cash");
            return downloadsCache.get(fileUrl);
        } else {
            byte [] fileContent = downloader.downloadFile(fileUrl);
            System.out.println("not in cash, putting file");
            downloadsCache.put(fileUrl, fileContent);
            return fileContent;
        }
    }

    public Set<String> getCachedURLS(){
        return downloadsCache.keySet();
    }

}
