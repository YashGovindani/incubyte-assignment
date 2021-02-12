package incubyte;

public class SimpleStringCalculator
{
public static int Add(String args)
{
int sum;
if(args.trim().isEmpty()) return 0;
String nums[]=args.trim().split(",");
sum=0;
for(String num:nums) sum+=Integer.parseInt(num);
return sum;
}
}
