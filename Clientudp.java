import java.io.*;
import java.net.*;

public class Clientudp {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        BufferedReader input = null;

        try {
            clientSocket = new DatagramSocket();
            input = new BufferedReader(new InputStreamReader(System.in));

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1306;

            while (true) {
                System.out.print("Enter a message to send to server: ");
                String message = input.readLine();
                byte[] sendData = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);

 if (message.trim().equalsIgnoreCase("bye")) {
                    System.out.println("Closing the client.");
                    break;
                }

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server response: " + receivedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 }