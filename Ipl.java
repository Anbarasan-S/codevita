import java.util.*;
public class Ipl
{
    public static void main(String args[])
    {
        int ind=0,score1=0,score2=0,ball1=0,ball2=0,values=0;
        String team_data[]=new String[100],team1="",team2="",res="",tms="";
        Scanner scan_obj=new Scanner(System.in);
        double calc=0.0,predict=0.0,ans=0.0,rr=0.0;
        Map<String,Double>run_rate=new HashMap<>();
        Map<String,Integer>points=new HashMap<>();
        Map<Integer,ArrayList<String>>total=new TreeMap<>(Collections.reverseOrder());
        Map<Double,ArrayList<String>>nrr=new TreeMap<>(Collections.reverseOrder());
        run_rate.put("CSK",0.0);
        run_rate.put("MI",0.0);
        run_rate.put("RCB",0.0);
        run_rate.put("SRH",0.0);
        run_rate.put("PBKS",0.0);
        run_rate.put("RR",0.0);
        run_rate.put("KKR",0.0);
        run_rate.put("DC",0.0);
        points.put("CSK",0);
        points.put("MI",0);
        points.put("RCB",0);
        points.put("SRH",0);
        points.put("PBKS",0);
        points.put("RR",0);
        points.put("KKR",0);
        points.put("DC",0);
        for(ind=0;ind<56;ind+=1)
        {
            team_data=scan_obj.nextLine().split(" ");
            res=team_data[1].split("/")[0];
            score1=Integer.parseInt(res);
            res=team_data[4].split("/")[0];
            score2=Integer.parseInt(res);
            ball1=Integer.parseInt(team_data[2]);
            ball2=Integer.parseInt(team_data[5]);
            team1=team_data[0];
            team2=team_data[3];
            if(score1==score2)
            {
                points.put(team1, points.get(team1)+1);
                points.put(team2, points.get(team2)+1);
            }
            else if(score1>score2)
            {
                rr=run_rate.get(team1)+((score1-score2)*0.05);
                run_rate.put(team1,rr);
                tms=team1;
                points.put(team1, points.get(team1)+2);
                run_rate.put(team2,run_rate.get(team2)-((score1-score2)*0.05));
            }
            else
            {
                    calc=Double.parseDouble(ball2/6+"."+ball2%6);
                    predict=score2/calc;
                    calc=Double.parseDouble(ball1/6+"."+ball1%6);
                    ans=score1/calc;
                    rr=run_rate.get(team2)+predict-ans;
                    tms=team2;
                    run_rate.put(team2,rr);
                    points.put(team2,points.get(team2)+2);
                    run_rate.put(team1,run_rate.get(team1)-(predict-ans));
            }
        }
        Iterator<Map.Entry<String, Integer>> itr=points.entrySet().iterator();
        while (itr.hasNext()) 
        {
        Map.Entry<String, Integer> pair = itr.next();
        values=pair.getValue();
        if(!total.containsKey(values))
        {
            ArrayList<String> arlst=new ArrayList<>();
            arlst.add(pair.getKey());
            total.put(values,arlst);

        }
        else
        {
            ArrayList<String> arlst=total.get(values);
            arlst.add(pair.getKey());
            total.put(values,arlst);
        }
        rr=run_rate.get(pair.getKey());
        if(nrr.containsKey(rr))
            {
               ArrayList<String> arlst=new ArrayList<>();
               arlst.add(pair.getKey());
               nrr.put(rr,arlst); 
            }
            else
            {
                ArrayList<String> arlst=new ArrayList<>();
                arlst.add(pair.getKey());
                nrr.put(rr,arlst);
            }
        }    
        Iterator<Map.Entry<Integer, ArrayList<String>>> itr2=total.entrySet().iterator();
       while (itr2.hasNext()) 
        {
        Map.Entry<Integer,ArrayList<String>> pair = itr2.next();
        if(pair.getValue().size()==1)
        {
            System.out.println(pair.getValue().get(0));
        }
        else
        {
            ArrayList<String>arlst=pair.getValue();
            Iterator<Map.Entry<Double, ArrayList<String>>> itr3=nrr.entrySet().iterator();
       while (itr3.hasNext()) 
        {
        Map.Entry<Double,ArrayList<String>> pair2 = itr3.next();
        if(arlst.indexOf(pair2.getValue().get(0))!=-1)
        {
            String final_val=pair2.getValue().get(0);
            System.out.println(final_val);
        }
        }    
}
}
}
}