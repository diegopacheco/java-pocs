import jdk.incubator.vector.VectorSpecies;
import jdk.incubator.vector.FloatVector;
import java.util.Arrays;

/**
 * --add-modules=jdk.incubator.vector
 */
public class Main{
  public static void main(String args[]){
    final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_PREFERRED;
    float[] arr = new float[1_200_000];
    Arrays.fill( arr, 23.74F );

    var v8sum = FloatVector.zero( SPECIES );
    for( int i = 0; i < arr.length; i+=SPECIES.length() ) {
      var v8temp = FloatVector.fromArray( SPECIES, arr, i );
      v8sum = v8sum.add( v8temp );
    }
    System.out.println(v8sum);

  }
}
