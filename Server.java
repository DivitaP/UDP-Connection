// Divita Phadakale 8626

// Experiment No 13
// Write a UDP client server  menu based application 


import java.io.*;
import java.net.*;
import java.util.*;

class Calculator
{
	DatagramPacket dp_in;
	DatagramPacket dp_out;
	String str;
	byte[] receive;
	byte[] send;
	int val;

	// Constructor
	Calculator(int a, DatagramSocket ds)
	{
		try
		{
			InetAddress ia = InetAddress.getLocalHost();
			switch(a)
			{
				case 1:	receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						val = Integer.parseInt(str.trim());

						String f = fact(val);

						send = ("Factorial of " + val + " is " + f).getBytes();
						dp_out = new DatagramPacket(send, send.length, ia, dp_in.getPort());
						ds.send(dp_out);

						break;

				case 2:	receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						int b = Integer.parseInt(str.trim());


						receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						int p = Integer.parseInt(str.trim());


						String pow = power(b,p);

						send = ("Power is " + pow).getBytes();
						dp_out = new DatagramPacket(send, send.length, ia, dp_in.getPort());
						ds.send(dp_out);

						break;

				case 3:	receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						val = Integer.parseInt(str.trim());

						String pal = isPalindrome(val);

						send = (pal).getBytes();
						dp_out = new DatagramPacket(send, send.length, ia, dp_in.getPort());
						ds.send(dp_out);

						break;

				case 4:	receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						val = Integer.parseInt(str.trim());

						String arm = isArmstrong(val);

						send = (arm).getBytes();
						dp_out = new DatagramPacket(send, send.length, ia, dp_in.getPort());
						ds.send(dp_out);

						break;

				case 5:	receive = new byte[10];
						dp_in = new DatagramPacket(receive, receive.length);
						ds.receive(dp_in);
						str = new String(dp_in.getData());
						val = Integer.parseInt(str.trim());

						String prime = isPrime(val);

						send = (prime).getBytes();
						dp_out = new DatagramPacket(send, send.length, ia, dp_in.getPort());
						ds.send(dp_out);

						break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

	// Performs factorial
	String fact(int a)
	{
		int f = 1;
		for(int i=1 ; i<=a ; i++)
		{
			f *= i;
		}
		return Integer.toString(f);
	}

	// Performs power
	String power(int b,int p)
	{
		int pow = 1;
		for(int i = 0 ; i<p ; i++)
		{
			pow *= b;
		}

		return Integer.toString(pow);
	}

	// Checks if Palindrome
	String isPalindrome(int a)
	{
		int[] arr = new int[10];
		int i = -1;
		int j = 0;
		while(a>0)
		{
			arr[++i] = a%10;
			a /= 10;
		}

		while( i > j)
		{
			if( arr[i] != arr[j])
				return "It is not a Palindrome";
			i--;
			j++;
		}

		return "It is a Palindrome";
	}

	// Checks if Armstrong
	String isArmstrong(int a)
	{
		int b = a;
		int sum = 0;
		int t;
		while(b>0)
		{
			t = b%10;
			sum += Integer.parseInt(power(t,3));
			b /= 10;
		}

		if (sum == a)
			return "It is an Armstrong number";
		else
			return "It is not an Armstrong number";

	}

	// Checks if Prime no.
	String isPrime(int a)
	{
		for(int i = 2 ; i<=Math.sqrt(a) ; i++)
		{
			if (a%i == 0)
				return "It is not a Prime number";
		}

		return "It is a Prime number";
	}
}

public class Server
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("Server has started");
		String input;
		int a;
		while(true)
		{
			byte[] rc = new byte[1024];

			DatagramPacket dp = new DatagramPacket(rc, rc.length);		
			ds.receive(dp);
			input = new String(dp.getData());
			input = input.trim();
			try
			{
				a = Integer.parseInt(input);
				Calculator obj = new Calculator(a,ds);	// Creates a Calculator object and does the remaining calculation in there
			}
			catch( Exception e)
			{
				continue;
			}

		}
	}
}
