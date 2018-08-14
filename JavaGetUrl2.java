import java.io.*;
import java.net.*;

@SpringBootApplication
@EnableCircuitBreaker

public class JavaGetUrl2 {

   public static void main (String[] args) {
	
      SpringApplication.run(HystrixExampleApplication.class, args);
      URL u;
      InputStream is = null;
      DataInputStream dis;
      String s;
      int ink;

      try {

         u = new URL("https://edrone.me/");
	 
	 
	 
	 is = u.openStream();         // throws an IOException

         dis = new DataInputStream(new BufferedInputStream(is));

	 ink = 0;
	 
         while ((s = dis.readLine()) != null) {
		//byte[] b=s.getBytes();
		byte[] b=s.getBytes("UTF-8");
		ink=ink+(b.length);
		System.out.println(s);
         }
         System.out.println(ink);

      } catch (IOException ioe) {

         System.out.println("Oops- an IOException happened.");
         ioe.printStackTrace();
         System.exit(1);

      } finally {

         try {
            is.close();
         } catch (IOException ioe) {
         }

      } // finally
   }  // main
} //class
