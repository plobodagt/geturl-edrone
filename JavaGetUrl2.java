import java.io.*;
import java.net.*;

public class JavaGetUrl2 {

   public static void main (String[] args) {

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

      } catch (MalformedURLException mue) {

         System.out.println("Ouch - a MalformedURLException happened.");
         mue.printStackTrace();
         System.exit(1);

      } catch (IOException ioe) {

         System.out.println("Oops- an IOException happened.");
         ioe.printStackTrace();
         System.exit(1);

      } finally {

         try {
            is.close();
         } catch (IOException ioe) {
         }

      } // end of 'finally' clause
	
	
	
   }  // end of main
	
} // end of class definition
