import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

import static com.github.diegopacheco.bb.BenchUtils.bench;
import static com.github.diegopacheco.bb.ByteBufferUtils.*;
import static com.github.diegopacheco.bb.EncryptionUtils.*;

public class Main {
    public static void main(String args[]) {

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                ByteBuffer r = encrypt(ByteBuffer.wrap("1".getBytes(StandardCharsets.UTF_8)));
                decrypt(r);
                System.out.println("Enc/Dec WARM UP DONE! ");
                return null;
            }
        });

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                String data = "123456789";
                ByteBuffer bb = stringToBB(data);
                String dataBack = bbToString(bb);
                assert (data.equals(dataBack));
                System.out.println("ByteBuffers OK");
                return null;
            }
        });

        String data = "123456789";
        ByteBuffer bb = stringToBB(data);
        ByteBuffer bbEnc =
                bench(new Supplier<ByteBuffer>() {
                    @Override
                    public ByteBuffer get() {
                        ByteBuffer bbEnc = encrypt(bb);
                        System.out.println("ByteBuffer Enc OK");
                        return bbEnc;
                    }
                });

        ByteBuffer bbDec =
                bench(new Supplier<ByteBuffer>() {
                    @Override
                    public ByteBuffer get() {
                        ByteBuffer bbDec = decrypt(bbEnc);
                        System.out.println("ByteBuffer Dec OK");
                        return bbDec;
                    }
                });
        System.out.println("got back from BB enc/dec: " + bbToString(bbDec));

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                for(int i=0;i<=1000;i++){
                    ByteBuffer bbEnc = encrypt(stringToBB(""+i));
                }
                System.out.println("Enc 1000 DONE");
                return null;
            }
        });

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                for(int i=0;i<=10000;i++){
                    ByteBuffer bbEnc = encrypt(stringToBB(""+i));
                }
                System.out.println("Enc 10000 DONE");
                return null;
            }
        });

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                for(int i=0;i<=100000;i++){
                    ByteBuffer bbEnc = encrypt(stringToBB(""+i));
                }
                System.out.println("Enc 100000 DONE");
                return null;
            }
        });

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                for(int i=0;i<=1000000;i++){
                    ByteBuffer bbEnc = encrypt(stringToBB(""+i));
                }
                System.out.println("Enc 1000000 DONE");
                return null;
            }
        });

        bench(new Supplier<Void>() {
            @Override
            public Void get() {
                for(int i=0;i<=100000000;i++){
                    ByteBuffer bbEnc = encrypt(stringToBB(""+i));
                }
                System.out.println("Enc 100000000 DONE");
                return null;
            }
        });

        System.out.println("FIN.");
    }
}
