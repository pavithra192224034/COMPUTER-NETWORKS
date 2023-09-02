import java.util.*;
import java.io.*;
import java.net.*;
public class Serverdate
{
public static void main(String a[])
{
    String ip;
ServerSocket ss;
Socket c;
BufferedReader input;
PrintStream ps;
try
{
ss=new ServerSocket(4444);
System.out.println("server starter");
System.out.println("waiting for the client");
c=ss.accept();
Date d=new Date();
ps=new PrintStream(c.getOutputStream());
ps.println(d);
input=new BufferedReader(new InputStreamReader
  (c.getInputStream()));
ip=input.nextLine();
System.out.println(ip);
input.close();
ss.close();
c.close();
ps.close();
}
catch(IoException i)
{
System.out.println(i);
}}}