package incubyte;

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
private static boolean isValid(String args,String delimeter)
{
if(args.indexOf("\n"+delimeter)!=-1 || args.indexOf(delimeter+"\n")!=-1) return false;
return true;
}
public static int Add(String args) throws IllegalArgumentException
{
int sum,i;
String delimeter,exceptionString;
if(args.trim().isEmpty()) return 0;
delimeter=getDelimeter(args);
if(!isValid(args,delimeter)) throw new IllegalArgumentException("Invalid string : "+args);
String nums[];
if(!hasDelimeter) nums=args.replaceAll("\n",delimeter).trim().split(delimeter);
else nums=args.substring(args.indexOf("]\n")+2).replaceAll("\n",delimeter).trim().split(delimeter);
sum=0;
exceptionString="Negative number(s) : ";
for(String num:nums)
{
i=Integer.parseInt(num.trim());
if(i<0) exceptionString+=i+",";
sum+=Integer.parseInt(num.trim());
}
if(exceptionString.length()>21) throw new IllegalArgumentException(exceptionString);
return sum;
}
}
