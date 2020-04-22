public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Simple Encryption... ");
        SimpleCryptoService cs = SimpleCryptoService.getInstance();
        String cipherText = cs.encrypt("Diego");
        System.out.println("Cipher text as Base64: " + cipherText);
        System.out.println("Decrypted: " + cs.decrypt(cipherText));

        System.out.println("Envelope Encryption... ");
        EnvelopeCrypoService ecs = EnvelopeCrypoService.getInstance();
        EnvelopeMessage envelope = ecs.encrypt("Diego");
        System.out.println("Encrypt: " + envelope);
        String data = ecs.decrypt(envelope);
        System.out.println("Decrypted: " + data);
    }

}