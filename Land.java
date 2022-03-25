import java.util.*;
public class Land {
    public static void main(String args[])
    {
        Scanner scan_obj=new Scanner(System.in);
        int number=scan_obj.nextInt(),ind=0,ind2=0,num[]=new int[number],tot_score=0,vow_count=0;
        String ele[]=new String[number],emote[]=new String[number];
        Map<String,Integer>data_map=new HashMap<>();
        // Land, Road, People, Stone, Clouds, House, Forest, Gates, Water, Electricity, Agricultural, Farms, Shops, Transport, Mountains
        data_map.put("Happy",10);
        data_map.put("Sad",5);
        data_map.put("Neutral",2);
        data_map.put("None",1);
        Map<String,Integer>vow_map=new HashMap<>();
        vow_map.put("Land",1);
        vow_map.put("Road",2);
        vow_map.put("People",2);//
        vow_map.put("Stone",2);
        vow_map.put("Clouds",2);
        vow_map.put("House",3);
        vow_map.put("Forest",2);
        vow_map.put("Gates",2);
        vow_map.put("Water",2);
        vow_map.put("Electricity",2);//
        vow_map.put("Agricultural",3);//
        vow_map.put("Farms",1);
        vow_map.put("Shops",1);
        vow_map.put("Transport",2);
        vow_map.put("Mountains",4);
        for(ind=0;ind<number;ind+=1)
        {
            String str=scan_obj.next();
            for(ind2=0;ind2<str.length();ind2++)
            {
                char chr=str.charAt(ind2);
                if(chr>='0'&&chr<='9')
                {
                    num[ind]=num[ind]*10+chr-'0';
                }
                else
                {
                    ele[ind]=str.substring(ind2, str.length());
                vow_count+=vow_map.get(ele[ind])*num[ind];
                    break;
                }
            }
        }
        for(ind=0;ind<number;ind+=1)
        {
            String str="";
            str=scan_obj.next();
            tot_score+=data_map.get(str)*num[ind];
        }
        int is_prime_number=tot_score/vow_count;
        List<Integer>prime_lst=new ArrayList<>();
        prime_lst.add(2);
        prime_lst.add(3);
        prime_lst.add(5);
        prime_lst.add(7);
        if(prime_lst.indexOf(is_prime_number)!=-1)
        {
            System.out.print("YES ");
        }
        else
        {
            System.out.print("NO ");
        }
        switch(is_prime_number)
        {
            case 0:
            System.out.println("Zero ");
            break;
            case 1:
            System.out.println("One ");
            break;
            case 2:
            System.out.println("Two ");
            break;
            case 3:
            System.out.println("Three ");
            break;
            case 4:
            System.out.println("Four ");
            break;
            case 5:
            System.out.println("Five ");
            break;
            case 6:
            System.out.println("Six");
            break;
            case 7:
            System.out.println("Seven");
            break;
            case 8:
            System.out.println("Eight");
            break;
            case 9:
            System.out.println("Nine");
            break;
        }
    }
}
