import incubyte.SimpleStringCalculator;

class stage1Test
{
public static void main(String gs[])
{
int sum;
String args;
System.out.println("For stage 1 Test Cases :");
System.out.print("Case 1 :when an empty string is passed, sum= ");
sum=SimpleStringCalculator.Add("");
System.out.println(sum);
args="10,2,3,11,123,12,854,57643,2356,-12343";
System.out.print("Case 2 : passed \""+args+"\", sum=");
sum=SimpleStringCalculator.Add(args);
System.out.println(sum);
}
}
