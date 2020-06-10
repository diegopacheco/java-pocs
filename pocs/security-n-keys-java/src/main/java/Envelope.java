import java.util.Arrays;
import java.util.Base64;

public class Envelope {

    private byte[] encKek;
    private byte[] encDek;
    private byte[] encData;

    public Envelope(){}

    public Envelope(byte[] encKek, byte[] encDek, byte[] encData) {
        this.encKek = encKek;
        this.encDek = encDek;
        this.encData = encData;
    }

    public byte[] getEncKek() {
        return encKek;
    }
    public void setEncKek(byte[] encKek) {
        this.encKek = encKek;
    }

    public byte[] getEncDek() {
        return encDek;
    }
    public void setEncDek(byte[] encDek) {
        this.encDek = encDek;
    }

    public byte[] getEncData() {
        return encData;
    }
    public void setEncData(byte[] encData) {
        this.encData = encData;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "encKek=" + getBase64String(encKek) +
                ", encDek=" + getBase64String(encDek) +
                ", encData=" + getBase64String(encData) +
                '}';
    }

    private String getBase64String(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Envelope envelope = (Envelope) o;
        return Arrays.equals(getEncKek(), envelope.getEncKek()) &&
                Arrays.equals(getEncDek(), envelope.getEncDek()) &&
                Arrays.equals(getEncData(), envelope.getEncData());
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(getEncKek());
        result = 31 * result + Arrays.hashCode(getEncDek());
        result = 31 * result + Arrays.hashCode(getEncData());
        return result;
    }
}
