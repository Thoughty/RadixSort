import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Radix {
static int count = 1;
	
	public static int FindMax(int[] Number)
	{
		int MaxNumber = Number[0];
		for(int A : Number)
		{
			if(MaxNumber < A)
			{
				MaxNumber = A;
			}
		}
		return MaxNumber;
	}
	
	
	public static void CountSort(int[] num,int size,int expo)
	{
		int output[] = new int[size];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		for(int i = 0;i<size;i++)
		{
			count[(num[i]/expo)%10]++;
		}
		
		for(int i=1;i<10;i++)
		{
			count[i] += count[i-1];
		}
		
		for(int i = size - 1; i >= 0;i--)
		{
			output[count[(num[i]/expo)%10]-1] = num[i];
			count[(num[i]/expo)%10]--;
		}
		
		for(int i = 0; i<size;i++)
		{
			num[i] = output[i];
		}
	}
	public static void RadixSort(int num[],int size,int base)
	{
		int max = FindMax(num);
		
		for(int expo = 1 ; max/expo > 0 ;expo*=10)
		{
			CountSort(num, size, expo);
			System.out.println("["+count+" Digit Sorted]");
			count++;
			Display(num, size,base);
			System.out.println("\n");
		}
	}
	public static void Display(int num[],int size,int base)
	{
		System.out.print("[");
		if(base == 1)
		{
			for(int i=0;i<size;i++)
			{
				String numberAsString = String.format("%06d", num[i]);
				System.out.print(numberAsString+" ");
			}
		}
		if(base == 2)
		{
			for(int i=0;i<size;i++)
				{
					System.out.print(num[i]+ " ");
				}
		}
		System.out.println("]");
	}
	public static void main(String args[])
	{
		int baseSelect;
		Scanner input =  new Scanner(System.in);
		System.out.println("Which base number do you want to convert?");
		System.out.println("[1] Base 2");
		System.out.println("[2] Base 10");
		System.out.println("Enter your choice : ");
		baseSelect = input.nextInt();
		System.out.print("Enter number of element : ");
		int nElement = input.nextInt();
		int[] Unsorted = new int[nElement];
		System.out.println("Enter number : ");
		if(baseSelect == 1)
		{
			for(int i=0;i<nElement;i++)
			{
				Unsorted[i] =  Integer.parseInt(input.next(),10);
				//System.out.println(Unsorted[i]);
			}
		}
		if(baseSelect == 2)
		{
			for(int i=0;i<nElement;i++)
			{
				Unsorted[i] =  input.nextInt();
			}
		}
		System.out.print("Before Sorting : \n");
		Display(Unsorted, nElement,baseSelect);
		System.out.println("Max number is : "+FindMax(Unsorted));
		RadixSort(Unsorted, nElement,baseSelect);
		System.out.print("After Sorting : \n");
		
		Display(Unsorted, nElement,baseSelect);
		
	}
	
}
