import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GenRandomConfiguration {

  static int SEED=593428753;

  public static void main(String[] args) {

    if (args == null || args.length != 1) {
      System.err.println("please, inform list of features on input.\n  format: java -DNUMCONFS=<number-configurations> GenRandomConfiguration <feature1 ... featureN>");
      System.exit(1);
    }

    String prop = System.getProperty("NUMCONFS");
    if (prop == null) {
      System.err.println("please, inform number of configurations on input.\n  format: java -DNUMCONFS=<number-configurations> GenRandomConfiguration <feature1 ... featureN>");
      System.exit(1);
    }
    int numconfs = Integer.parseInt(prop);

    String[] features = args[0].split(" ");
    Random r = new Random(SEED);

    Set<String> set = new HashSet<String>();

    if (numconfs > Math.pow(2, features.length)) {
      System.err.printf("cannot satisfy you request for NUMCONF(=%d) configurations: not enough combinations.\n", numconfs);
      System.exit(1);
    }

    while (set.size() < numconfs) {
      StringBuffer sb = new StringBuffer();
      for (String feature: features) {
        if (r.nextBoolean()) {
          sb.append(feature);
          sb.append(" ");
        }
      }
      set.add(sb.toString());
    }

    for (String s : set) {
      System.out.println(s);
    }

  }
}