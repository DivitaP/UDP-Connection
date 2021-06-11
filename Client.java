// Divita Phadakale 8626

// Experiment No 13
// Write a UDP client server  menu based application 


import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dp_in, dp_out;
		byte[] receive, send;
		InetAddress ia = InetAddress.getLocalHost();

		int opt;
		String a;
		String dump;
		Scanner sc = new Scanner(System.in);

		System.out.println("Client has started");
		
		System.out.println("1: Factorial");
		System.out.println("2: Power");
		System.out.println("3: Check Palindrome");
		System.out.println("4: Check Armstrong");
		System.out.println("5: Check Prime");
		System.out.println("Which operation do you have to perform: ");
		opt = sc.nextInt();
		dump = sc.nextLine();

		switch(opt)
		{
			case 1:	System.out.println("Enter the number");
					a = sc.nextLine();

					send = ("1").getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = a.getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					break;

			case 2:	System.out.println("Enter the base");
					String b = sc.nextLine();
					System.out.println("Enter the power");
					String p = sc.nextLine();
					
					send = ("2").getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = (b).getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = (p).getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					break;

			case 3:	System.out.println("Enter the number");
					a = sc.nextLine();

					send = ("3").getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = (a).getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					break;

			case 4:	System.out.println("Enter the number");
					a = sc.nextLine();

					send = ("4").getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = (a).getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					break;

			case 5:	System.out.println("Enter the number");
					a = sc.nextLine();
					
					send = ("5").getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					send = (a).getBytes();
					dp_out = new DatagramPacket(send, send.length, ia, 9999);
					ds.send(dp_out);

					break;

			default:	System.out.println("Your input is invalid!!");
						return;
		}


		receive = new byte[1024];
		dp_in = new DatagramPacket(receive, receive.length);
		ds.receive(dp_in);
		a = new String(dp_in.getData());
		a = a.trim();
		System.out.println(a);


		 
	}

}
