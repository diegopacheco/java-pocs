import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import javax.security.auth.x500.X500Principal;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Date;

public class Main{

  public static void main(String args[]) throws Exception{
    X509Certificate selfSignedX509Certificate = generate();
    System.out.println(selfSignedX509Certificate);
  }

  public static X509Certificate generate() throws Exception {
    Security.addProvider(new BouncyCastleProvider());

    // generate a key pair
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
    keyPairGenerator.initialize(4096, new SecureRandom());
    KeyPair keyPair = keyPairGenerator.generateKeyPair();

    // build a certificate generator
    X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
    X500Principal dnName = new X500Principal("cn=example");

    // add some options
    certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
    certGen.setSubjectDN(new X509Name("dc=name"));
    certGen.setIssuerDN(dnName); // use the same
    // yesterday
    certGen.setNotBefore(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
    // in 2 years
    certGen.setNotAfter(new Date(System.currentTimeMillis() + 2 * 365 * 24 * 60 * 60 * 1000));
    certGen.setPublicKey(keyPair.getPublic());
    certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");
    certGen.addExtension(X509Extensions.ExtendedKeyUsage,
            true,new ExtendedKeyUsage(KeyPurposeId.id_kp_timeStamping));

    // finally, sign the certificate with the private key of the same KeyPair
    X509Certificate cert = certGen.generate(keyPair.getPrivate(), "BC");

    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    char[] pwdArray = "pass".toCharArray();
    ks.load(null, pwdArray);

    ks.setKeyEntry("app_key", keyPair.getPrivate(), pwdArray,new X509Certificate[]{cert});
    ks.setCertificateEntry("app_cert",cert);
    try (FileOutputStream fos = new FileOutputStream("KeyStore.jks")) {
      ks.store(fos, pwdArray);
    }

    return cert;
  }

}
