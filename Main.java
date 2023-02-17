import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main
{
    public static int l;
    public static void main(String[] args)
    {
        Scanner preLogue = new Scanner(System.in);
        System.out.println("How to play:\nH for left block || J for left middle block || K for right middle block || L for right block\nType in anything to play");
        preLogue.next();

        MyFrame frame = new MyFrame(); 
        
        String filepath = "bingbian.wav";           //music
        Music musicObject = new Music();
        musicObject.playMusic(filepath);

        Calendar c = Calendar.getInstance();        //Calendar
        int timer = (c.get(Calendar.MINUTE)*60) + c.get(Calendar.SECOND);
        
        /*JFrame jf = new JFrame();                   //Stage
        Movements t = new Movements();              //Player
        t.setBackground(Color.BLACK);
        GBlock g = new GBlock();                    //GBlock
        g.setBackground(Color.yellow);
        jf.setTitle("Penguin Music Labs");
        jf.setSize(2000, 1200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t,BorderLayout.CENTER);
        jf.add(g,BorderLayout.PAGE_END);*/

        while ((c.get(Calendar.MINUTE)*60) + c.get(Calendar.SECOND)-timer < musicObject.getLength())    //While start time is less than song time
        {}
        frame.setVictory(true);

        Object h = new Object();
        Art a = new Art();
        Art b = new Art("bingbian", "someone", 2019);
        Songs d = new Songs("binbian", "someone", 2019, "chinese", "hiphop");
        Songs z = new Songs("hollow", "scythe", 2000, "none", "craze");
        Songs y = new Songs("iphone", "drake2.0", 2020, "english", "hiphop");
        Art e = new Songs("lolol", "gnome", 2021, "gnome language", "troll");
        Art[] f = new Art[3];
        f[0] = d;
        f[1] = z;
        f[2] = y;
        ArrayList<Art> g = new ArrayList<Art>();
        System.out.println(subOfSup(y));
        g.add(d);
        g.add(z);
        g.add(y);
        System.out.println(hasAuthor(f, "binbian"));
        System.out.println(hasAuthor2(f, "binbian"));
        System.out.println(hasAuthor(g, "binbian"));
        System.out.println(hasAuthor2(g,"binbian"));
        int[] m = {1,5,7,2,8,4};
        ArrayList<Integer> n = new ArrayList<Integer>();
        n.add(4);
        n.add(9);
        n.add(0);
        n.add(4);
        n.add(2);
        n.add(7);
        arrMergeSort(m, 1, 8);
        arrListMerge(n, 0, 4, 9);
        iterativeBinarySearch(m, 1, 8, 2);

        

        
    }

    public static int iterativeBinarySearch(int[] array, int low, int high, int target)
  {
    int mid;
    int count = 0;
    while(low <= high)
    {
      count++;
      //find the middle
      mid = (high + low)/2;
      
      //if the middle is less, search the right half.
      if(array[mid]<target) low = mid + 1;
      
      //if it's more, search the left half.
      else if(array[mid]>target) high = mid - 1;
      
      //goldilocks, baby bear, et cetera.
      else 
      {
        System.out.println("iterative binary search count: " + count);
        return mid;
      }
    }
    //if you didn't find it, well...
    System.out.println("iterative binary search count: " + count);
    return -1;
  }

    public static void arrListMergeSort(ArrayList<Integer> arr, int low, int high)
    {
        //if the left index is less than right index
      if(low < high)
      {
        //split it roughly in half
        int mid = (low + high)/2;
        
        //recursively splitting the left in half
        arrListMergeSort(arr, low, mid);
        
        //then recursively split the right in half
        arrListMergeSort(arr, mid + 1, high);
        
        //then merge the subarrays in order
        arrListMerge(arr, low, mid, high);
      }
    }

    public static void arrListMerge(ArrayList<Integer> arr, int low, int mid, int high)
    {
      //copy the left "half" to a new array
      int[] left = new int[mid + 1 - low];
      
      //populate the copy
      for(int i = 0; i < left.length; i++)
        left[i] = arr.get(i+low);          //arr[i + low];
      
      //keep track of the leftmost index
      int leftIndex = 0;
      
      //as long as low < middle < high
      while(low < mid + 1 && mid + 1 <= high)
      {
        
        //if the right index is less than the left index
        if(arr.get(mid+1) < left[leftIndex])
        {
          //store the right index and increment
          arr.set(low,arr.get(mid+1));
          low++;
          mid++;
        }
        //otherwise...
        else
        {
          //take the left index and increment
          arr.set(low,left[leftIndex]); 
          low++;
          leftIndex++;
        }
      }
      //there may be leftovers in the left "half"
      while(low < mid + 1)
      {
        //so take them from the left "half"  and increment
        arr.set(low,left[leftIndex]); 
        low++;
        leftIndex++;
      }
    }

    public static void arrMergeSort(int[] arr, int low, int high)
    {
      //if the left index is less than right index
      if(low < high)
      {
        //split it roughly in half
        int mid = (low + high)/2;
        
        //recursively splitting the left in half
        arrMergeSort(arr, low, mid);
        
        //then recursively split the right in half
        arrMergeSort(arr, mid + 1, high);
        
        //then merge the subarrays in order
        merge(arr, low, mid, high);
      }
    }
    public static void merge(int[] arr, int low, int mid, int high)
    {
      //copy the left "half" to a new array
      int[] left = new int[mid + 1 - low];
      
      //populate the copy
      for(int i = 0; i < left.length; i++)
        left[i] = arr[i + low];
      
      //keep track of the leftmost index
      int leftIndex = 0;
      
      //as long as low < middle < high
      while(low < mid + 1 && mid + 1 <= high)
      {
        
        //if the right index is less than the left index
        if(arr[mid+1] < left[leftIndex])
        {
          //store the right index and increment
          arr[low] = arr[mid+1];
          low++;
          mid++;
        }
        //otherwise...
        else
        {
          //take the left index and increment
          arr[low] = left[leftIndex];
          low++;
          leftIndex++;
        }
      }
      //there may be leftovers in the left "half"
      while(low < mid + 1)
      {
        //so take them from the left "half"  and increment
        arr[low] = left[leftIndex];
        low++;
        leftIndex++;
      }
    }
      

    public static String subOfSup(Art e)
    {
        return e.getTitle();
    }

    public static boolean hasAuthor(Art[] a, String s)
    {
        l = a.length-1;
        if (a[l].getAuthor() == s )
        {
            return true;
        }
        if (l == 0)
        {
            return false;
        }
        l--;
        hasAuthor(a, s);
        return false;
    }

    public static boolean hasAuthor2(Art[] a, String s)
    {
        for (int i = a.length-1; i > 0; i--)
        {
            if (a[i].getAuthor() == s)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean hasAuthor(ArrayList<Art> a, String s)
    {
        if (a.get(a.size()-1).getAuthor() == s)
        {
            return true;
        }
        if (a.size()-1 == 0)
        {
            return false;
        }
        a.remove(a.size()-1);
        hasAuthor(a, s);
        return false;
    }

    public static boolean hasAuthor2(ArrayList<Art> a, String s)
    {
        for (int i = 0; i < a.size()-1; i++)
        {
            if(a.get(i).getAuthor() == s)
            {
                return true;
            }
        }
        return false;
    }

}
