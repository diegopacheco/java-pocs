import java.util.Arrays;

public final class EnvelopeEncryptedMessage {

    private byte[] encryptedKey;
    private String ciphertext;

    public byte[] getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(byte[] encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    @Override
    public String toString() {
        return "EnvelopeEncryptedMessage{" +
                "encryptedKey=" + Arrays.toString(encryptedKey) +
                ", ciphertext='" + ciphertext + '\'' +
                '}';
    }
}