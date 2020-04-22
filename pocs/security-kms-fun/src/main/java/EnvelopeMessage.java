import java.util.Arrays;

public final class EnvelopeMessage {

    private byte[] encryptedKey;
    private String cypherText;

    public byte[] getEncryptedKey() {
        return encryptedKey;
    }
    public void setEncryptedKey(byte[] encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public void setCypherText(String cypherText) {
        this.cypherText = cypherText;
    }
    public String getCypherText() {
        return cypherText;
    }

    @Override
    public String toString() {
        return "EnvelopeEncryptedMessage{" +
                "encryptedKey=" + Arrays.toString(encryptedKey) +
                ", cypherText='" + cypherText + '\'' +
                '}';
    }
}