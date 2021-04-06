import com.github.diegopacheco.java.pocs.utils.OSEnvUtils;

public class Main{
  public static void main(String args[]){

    System.out.println("Are we running on AWS/Ec2 now? " + OSEnvUtils.isThisCodeRunningOnEC2());

    System.out.println("myvar=="+System.getenv("myvar"));
    OSEnvUtils.setOSEnvVar("myvar","42");
    System.out.println("myvar=="+System.getenv("myvar"));
  }
}
