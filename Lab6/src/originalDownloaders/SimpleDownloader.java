package originalDownloaders;

import originalDownloaders.Downloader;

import java.util.Base64;

public class SimpleDownloader implements Downloader {

    @Override
    public byte[] downloadFile(String fileUrl) {
        System.out.println("Downloading: " + fileUrl);
        String encodedString = Base64.getEncoder().encodeToString(fileUrl.getBytes());
        return Base64.getDecoder().decode(encodedString);
    }

}
