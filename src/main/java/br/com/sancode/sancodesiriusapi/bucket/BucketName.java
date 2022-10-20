package br.com.sancode.sancodesiriusapi.bucket;

public enum BucketName {
    PROFILE_IMAGE("awf-sirius-app");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}