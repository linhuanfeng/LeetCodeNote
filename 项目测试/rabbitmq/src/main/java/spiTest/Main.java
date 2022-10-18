package spiTest;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ServiceLoader<UploadCDN> uploadCDNS = ServiceLoader.load(UploadCDN.class);
        for (UploadCDN uploadCDN : uploadCDNS) {
            uploadCDN.upload("file");
        }
    }
}
