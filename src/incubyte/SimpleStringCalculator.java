package incubyte;
import java.util.*;
public class SimpleStringCalculator
{
static private boolean hasDelimeter;
private static String getDelimeter(String args) throws IllegalArgumentException
{
int endIndex;
hasDelimeter=false;
endIndex=args.indexOf("]\n");
if(args.startsWith("//[")==false && endIndex!=-1)
 throw new IllegalArgumentException("Invalid string : "+args);
if(args.startsWith("//[") && endIndex==-1)
 throw new IllegalArgumentException("Invalid string : "+args);
if(args.startsWith("//[")==false && endIndex==-1) return ",";
hasDelimeter=true;
return args.substring(3,endIndex);
}
private static List<String> getDelimeters(String args) throws IllegalArgumentException
{
int startIndex,endIndex;
List<String> delimeters;
hasDelimeter=false;
endIndex=args.indexOf("]");
delimeters=new ArrayList<String>();
if(args.startsWith("//[")==false && endIndex!=-1)
 throw new IllegalArgumentException("Invalid string : "+args);
if(args.startsWith("//[") && endIndex==-1)
 throw new IllegalArgumentException("Invalid string : "+args);
if(args.startsWith("//[")==false && endIndex==-1) delimeters.add(",");
if(delimeters.size()==1) return delimeters;
startIndex=2;
while(true)
{
delimeters.add(args.substring(startIndex+1,endIndex));
startIndex=endIndex+1;
if(args.charAt(startIndex)!='[') break;
endIndex=args.indexOf("]",startIndex);
if(endIndex==-1) throw new IllegalArgumentException("Invalid string : "+args);
}
hasDelimeter=true;
return delimeters;
}
private static boolean isValid(String args,String delimeter)
{
if(args.indexOf("\n"+delimeter)!=-1 || args.indexOf(delimeter+"\n")!=-1) return false;
return true;
}
public static int Add(String args) throws IllegalArgumentException
{
int sum,i;
//String delimeter,
String exceptionString;
List<String> delimeters;
if(args.trim().isEmpty()) return 0;
//delimeter=getDelimeter(args);
delimeters=getDelimeters(args);
//if(!isValid(args,delimeter)) throw new IllegalArgumentException("Invalid string : "+args);
String nums[];
if(!hasDelimeter) nums=args.replaceAll("\n",",").trim().split(",");
//else nums=args.substring(args.indexOf("]\n")+2).replaceAll("\n",delimeter).trim().split(delimeter);
else
{
for(String delimeter:delimeters) args=args.replaceAll(delimeter,",");
args=args.substring(args.indexOf("]\n")+2).replaceAll("\n",",");
nums=args.trim().split(",");
}
sum=0;
exceptionString="Negative number(s) : ";
for(String num:nums)
{
i=Integer.parseInt(num.trim());
if(i>1000) continue;
if(i<0) exceptionString+=i+",";
sum+=Integer.parseInt(num.trim());
}
if(exceptionString.length()>21) throw new IllegalArgumentException(exceptionString);
return sum;
}
}
