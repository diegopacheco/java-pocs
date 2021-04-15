public class Main {

    public static int sumArrayRange(int[] dataArray, int limit) {
        int sum = 0;
        for(int i=0;i<=dataArray.length;i++){
            if (dataArray[i]==limit)
                return sum;
            sum += dataArray[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] anArray = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Should be: 1");
        System.out.println("Got      : " + sumArrayRange(anArray, 2));

        anArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Should be: 10");
        System.out.println("Got      : " + sumArrayRange(anArray, 5));

        anArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Should be: 3");
        System.out.println("Got      : " + sumArrayRange(anArray, 3));

        anArray = new int[]{45, 43, 5, 6, 7, 23, 9, 6, 55, 4, 2, 32, 12};
        System.out.println("Should be: 237");
        System.out.println("Got      : " + sumArrayRange(anArray, 12));

        anArray = new int[]{45, 43, 5, 6, 7, 23, 9, 6, 55, 4, 2, 32, 12};
        System.out.println("Should be: 99");
        System.out.println("Got      : " + sumArrayRange(anArray, 7));

        anArray = new int[]{45, 43, 5, 6, 7, 23, 9, 6, 55, 4, 2, 32, 12};
        System.out.println("Should be: 88");
        System.out.println("Got      : " + sumArrayRange(anArray, 5));

        anArray = new int[]{45, 43, 5, 6, 7, 23, 9, 6, 55, 4, 2, 32, 12};
        System.out.println("Should be: 93");
        System.out.println("Got      : " + sumArrayRange(anArray, 6));

        anArray = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Should be: 0");
        System.out.println("Got      : " + sumArrayRange(anArray, 1));
    }
}
