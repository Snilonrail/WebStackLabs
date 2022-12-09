import originalDownloaders.SimpleDownloader;
import proxyDownloaders.SmartDownloader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        SmartDownloader smartDownloader = new SmartDownloader(new SimpleDownloader());
        List<String> urls =
                Arrays.asList("https://a.com", "https://b.com", "https://a.com",
                        "https://a.com", "https://c.com", "https://b.com");
        List<String> downloadAttempts = urls.stream().map(url -> new String(smartDownloader.downloadFile(url))).collect(Collectors.toList());
        downloadAttempts.forEach(System.out::println);
        System.out.println("All URLs were downloaded: " + new HashSet<>(downloadAttempts).equals(smartDownloader.getCachedURLS()));

    }
}