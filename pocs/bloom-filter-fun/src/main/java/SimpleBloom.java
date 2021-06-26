import java.util.HashSet;
import java.util.Random;

public class SimpleBloom {

    static int bloom[]= new int[10000];
    static HashSet<Integer> set=new HashSet<Integer>();
    static int result[]= new int[4];

    public static int getRandom(int l,int h){
        Random r = new Random();
        int low = l;
        int high = h;
        int result = r.nextInt(high-low) + low;
        return result;
    }
    public  static void getLookUpResult(){
        for(int i=0;i<2000;i++){

            if (i<0){
                i = i * -1;
            }

            if(isPresent(i)){
                if(set.contains(i)){ // true positive
                    result[0]++;
                }
                else{  // false positive
                    result[2]++;
                }
            }else{
                if(set.contains(i)){ // falsenegative
                    result[3]++;
                }
                else{
                    result[1]++;  //true negative
                }
            }
        }
    }
    public static boolean isPresent(int number){
        int h1=(number*number*number)%2000;
        int h2=(number*19)%2000;
        int h3=(number*number)%2000;

        if (h1<0){
            h1 = h1 * -1;
        }
        if (h2<0){
            h2 = h2 * -1;
        }
        if (h3<0){
            h3 = h3 * -1;
        }

        return (bloom[h1]==1 && bloom[h2]==1 && bloom[h3]==1);
    }

    public static void main(String[] args) {
        populate();
        getLookUpResult();
        for(int i : result){
            System.out.println(i);
        }
    }

    static void populate(){
        for(int i=0;i<1000;i++){
            int numb=getRandom(0,2000);
            set.add(numb);
            int h1=(numb*numb*3)%2000;
            bloom[h1]=1;
            int h2=(numb*19)%2000;
            bloom[h2]=1;
            int h3=(numb*numb)%2000;
            bloom[h3]=1;
        }
    }
}
