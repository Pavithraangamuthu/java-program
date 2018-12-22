import java.io.*;
import java.util.*;
import java.lang.String;
public class Main{
public static void main(String args[]){
//String log="00:06:01,9987675643LF00:01:07,9987675643LF00:05:01,9967342312LF";

String temptime=new String();
String tempnumber=new String();
String temp_time_in_map=new String();
String temp=new String();
String date=new String();
String str2="",str1;
char[] original_time=new char[10];
//char[] tempnumber=new char[10];
int i,k,p,j=0,q=1,original_map_size=0,extra_time=0,time,l=0;
int[] cost=new int[10];
String[] ph_number=new String[10];
int f=0,n;
HashMap<String,String> hm=new HashMap<String,String>();
String[] log=new String[100];
        //String temptime,tempnumber;
        Scanner s=new Scanner(System.in);
      //  System.out.println("E")
        n=s.nextInt();
        //if(n>=1&&n<=100){
        for(i=0;i<n;i++){
            log[i]=s.next();
        }
        for(i=0;i<n;i++){
        //System.out.println(log[i]);
        
        temptime=log[i].substring(0,8);
       // System.out.println(temptime);
        tempnumber=log[i].substring(9,12)+log[i].substring(13,16)+log[i].substring(17,log[i].length());
           // System.out.println(tempnumber);



//char[] a=log.toCharArray(); 
//Scanner s=new Scanner(System.in);
//a=s.nextLine();
//int n=s.length(a);
//for(i=0;i<a.length;i++){
//if(a[i]=='L'&&a[i+1]=='F'){
k=0;
//System.out.println(log.substring(j,i));
//temptime=log.substring(j,(j+8));
//System.out.println(q+"  time : "+temptime);
/*for(p=j;p<8;p++){
temptime[k]=a[p];
k++;
}
temptime[k]='\0';*/

//p++;
//k=0;
//tempnumber=(log.substring((j+9),(i)));
int min=Integer.parseInt(temptime.substring(3,5));
int hour=Integer.parseInt(temptime.substring(0,2));
int sec=Integer.parseInt(temptime.substring(6,temptime.length()));

ph_number[f]=tempnumber;
if(min<5&&hour==0){
  min=min*60;
  min=min+sec;
  cost[f]=min*3;
  f++;
}
else if(min>=5){
  hour=hour*60;
  if(sec!=0)
  min=min+1;
  min=min+hour;
  cost[f]=150*min;
  f++;
}
//System.out.println("cost : "+cost[f-1]+"num : "+ph_number[f-1]);
hm.putIfAbsent(tempnumber,temptime);
//System.out.println("map : ");
for(Map.Entry m:hm.entrySet()){
//System.out.println(m.getKey()+"  "+m.getValue()); 
}
//System.out.println("out map : ");
int size_of_map=hm.size();
l=7;
int count=0;
//System.out.println("o_map_size : "+original_map_size+"size : "+size_of_map);
if(original_map_size==size_of_map){
  for(Map.Entry w:hm.entrySet()){
    temp=(String)w.getKey();
    //System.out.println("map key : "+temp+"tempnumber"+tempnumber);
   if(temp.equals(tempnumber)){
   //System.out.println("equal found");
     temp_time_in_map=(String)w.getValue();
   //  System.out.println("duration : "+temp_time_in_map+"temptime: "+temptime);
   //char[] chartemp=temp.toCharArray();
   //char[] chartempnumber=tempnumber.toCharArray();
   for(int e=(temp.length())-1;e>=0;e-=3){
  // System.out.println("time 1:"+temp_time_in_map.substring((e-2),e)+"time 2 :"+temptime.substring((e-2),e));
   int addtime=Integer.parseInt(temp_time_in_map.substring((e-2),e))+Integer.parseInt(temptime.substring((e-2),e));   
   addtime=addtime+extra_time;
 //System.out.println("int time : "+Integer.parseInt(temp_time_in_map.substring((e-2),e))+" int time : "+Integer.parseInt(temptime.substring((e-2),e)));
 // System.out.println("addtime : "+addtime);
   count++;
   if(addtime>60&&count<3){
     time=addtime-60;
      extra_time=addtime/60;
   }
   else{
     time=addtime;
   }
   date=String.valueOf(time);
   str1=temp_time_in_map.substring(0,l-1);
   if(l+2<=6){
    str2=temp_time_in_map.substring(l+1,temp_time_in_map.length()); 
   }
   l=l-3;
   temp_time_in_map=str1+date+str2;
   //System.out.println(temp_time_in_map);
   
   }hm.replace((String)(w.getKey()),temp_time_in_map);
  
   }
   else{
   //System.out.println("not equal");
   } 
    
  }
  
}
else{
  original_map_size=size_of_map;
}
/*while(p<i){
tempnumber[k]=a[p];
p++;
k++;
}
tempnumber[k]='\0';*/
//System.out.println(q+"  no : "+tempnumber);
q++;
j=i+2;
}



//System.out.println(a);


//for(Map.Entry m:hm.entrySet()){
//System.out.println(m.getKey()+"  "+m.getValue()); 
//}
int[][] duration=new int[10][10];
int order=0;
String final_map_time_string;
String appendstring="";
for(Map.Entry w:hm.entrySet()){
  final_map_time_string=(String)w.getValue();
  //System.out.println("String duration : "+final_map_time_string);
   String[] final_map_time_char=final_map_time_string.split(":"); 
   for(i=0;i<final_map_time_char.length;i++){
        duration[order][i]=Integer.parseInt(final_map_time_char[i]);
 }  
     
   order++;
   
  }
  int[] total_cost=new int[10];
  int max,index1=0,index2=-1;
  for(i=0;i<order;i++){
    max=0;
  for(j=0;j<3;j++){
  //System.out.println("duration "+i+"  "+j+"  "+duration[i][j]);
  if(j==0){
  max+=duration[i][j]*60*60;
  //System.out.println("duration "+i+"  "+j+"  "+duration[i][j]+"max "+max);
  }
  if(j==1){
  max+=duration[i][j]*60;
  //System.out.println("duration "+i+"  "+j+"  "+duration[i][j]+"max "+max);
  }
  if(j==2){
  max+=duration[i][j];
  //System.out.println("duration "+i+"  "+j+"  "+duration[i][j]+"max "+max);
  }
  }
  //System.out.println("total_cost : "+i+" "+max);
  total_cost[i]=max;
  }
  int max1;
  max1=total_cost[0];
  for(i=1;i<order;i++){
   // System.out.println("total cost "+i+" "+total_cost[i]);
    if(max1<total_cost[i]){
    max1=total_cost[i];
    index1=i;
    }
  }
  int max2=0;
  //System.out.println("index 1: "+index1);
  for(i=0;i<order;i++){
    while(max1==total_cost[i]&&index1!=i){
      max2=total_cost[i];
      index2=i;
    }
    
  }
 // System.out.println("index 2: "+index2);
 // System.out.println("max duration : "+max+"index1 : "+index1+"index2 : "+index2);
  String final_map_number_string1="";
  
 String final_map_number_string2="";
  int te=0;
   for(Map.Entry w:hm.entrySet()){
       if(index1>=te){
           te++;
      final_map_number_string1=(String)w.getKey();
       }
     }
     if(index2!=-1){
         
     te=0;
    for(Map.Entry w:hm.entrySet()){
       if(index2>=te){
           te++;
      final_map_number_string2=(String)w.getKey();
       }
     
     }
     }
    
  
  String delete_number;
 //System.out.println("number 1 : "+final_map_number_string1+"number 2 : "+final_map_number_string2);
  //System.out.println("number 1 : "+Long.parseLong(final_map_number_string1)+"number 2 : "+Long.parseLong(final_map_number_string2));
  if(index2!=-1){
      long large_number1=Long.parseLong(final_map_number_string1);
      long large_number2=Long.parseLong(final_map_number_string2);
      /*while(large_number1>0){
          long r=large_number1%y;
          sum1=sum1+r;
          large_number1=large_number1/y;
      }
        while(large_number2>0){
          long r=large_number2%y;
          sum2=sum2+r;
          large_number2=large_number2/y;
      }
  */
  if(large_number2>large_number1)
  delete_number=final_map_number_string1;
  else
  delete_number=final_map_number_string2;
}
else{
    long large_number1=Long.parseLong(final_map_number_string1);
    delete_number=final_map_number_string1;
}
int total_bill=0;
for(i=0;i<f;i++){
    //System.out.println("ph_no : "+ph_number[i]+"  cost : "+cost[i]);
}
//System.out.println("Delete no: "+delete_number);
for(i=0;i<f;i++){
  if(!ph_number[i].equals(delete_number)){
     // System.out.println("in if i "+i);
     //System.out.print("ph _ number : "+ph_number[i]+"delete number : "+delete_number);
     //  System.out.println("  cost : "+cost[i]+" bill : "+total_bill); 
  total_bill=total_bill+cost[i]; 
  //System.out.println("After add : "+total_bill);
  }
 // System.out.println("out if i"+i);
 //System.out.println("cost : "+cost[i]+"number : "+ph_number[i]); 
}

System.out.println("Total bill : "+total_bill);
//}
//else{
 //   System.out.println("Invalid value");
//}
}

}

