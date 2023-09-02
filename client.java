import java.io.*;//input output process
import java.net.*; //network related process
public class client
{
public static void main(String a[])
{
String d; 
 InetAddress ia;
  Socket c;//interacting with client
  BufferedReader input;
  PrintStream ps;
  try 
{	
 c=new Socket(InetAddress.getLocalHost(),4444);
	 System.out.println("Connected");
	
  	 input=new BufferedReader(new InputStreamReader(c.getInputStream()));
  	d=input.readLine();
   	 System.out.println(d);
 	ps=new PrintStream(c.getOutputStream());
ia=InetAddress.getLocalHost();
ps.println(ia);
ps.close();
input.close();
c.close();
      }	
 catch(IOException i)
{
  System.out.println(i);
}}}