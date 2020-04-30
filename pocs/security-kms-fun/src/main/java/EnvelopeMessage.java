import java.util.Arrays;

public final class EnvelopeMessage {

    private byte[] encryptedDEK;
    private String cypherText;

    public byte[] getEncryptedDEK() {
        return encryptedDEK;
    }
    public void setEncryptedDEK(byte[] encryptedDEK) {
        this.encryptedDEK = encryptedDEK;
    }

    public String getCypherText() {
        return cypherText;
    }
    public void setCypherText(String cypherText) {
        this.cypherText = cypherText;
    }

    @Override
    public String toString() {
        return "EnvelopeEncryptedMessage{" +
                "  encryptedDEK=" + Arrays.toString(encryptedDEK) +
                ", cypherText='" + cypherText + '\'' +
                '}';
    }
}