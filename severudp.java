import java.io.*;//input output process
import java.net.*; //network related process
public class Serverudp
{
 public static void main(String a[])
{
DatagramSocket s;
DatagramPacket ps;
BufferedReader inp;
DatagramPacket pr;
InetAddress ip=null;
int port=0;
byte[] senddata=new byte[1024];
try 
{
s=new DatagramSocket(1306);
inp=new BufferedReader(new InputStreamReader(System.in));
while(true)
{
byte[] receivedata=new byte[1024];
pr=new DatagramPacket(receivedata,receivedata.length);
s.receive(pr);
String m= new String(pr.getData());
System.out.println("Client message"+m.trim());//shows msg to user
if(m.trim().equalsIgnoreCase("Bye "))
{
String m2="bye";
senddata=m2.getBytes();
ps=new DatagramPacket(senddata,senddata.length,ip,port);
s.send(ps);
break;
}
System.out.println("Enter server message ");
String m1=inp.readLine();
senddata=m1.getBytes();
ip=pr.getAddress();
port=pr.getPort();
ps=new DatagramPacket(senddata,senddata.length,ip,port);
s.send(ps);
s.close();
}
}
catch(IOException i)
{
  System.out.println(i);
}}}