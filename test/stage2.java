import incubyte.SimpleStringCalculator;

class stage2Test
{
public static void main(String gs[])
{
int sum;
String args;
System.out.println("For stage 2 Test Cases :");
args="//[;]\n10;2;3\n11;123\n12;854;57643;2356;-12343";
System.out.print("Case 1 : passed \""+args+"\", sum=");
sum=SimpleStringCalculator.Add(args);
System.out.println(sum);
try
{
args="[]\n10;2;3;11;123;12;854;57643;2356;-12343";
System.out.print("Case 2 : passed \""+args+"\", sum=");
sum=SimpleStringCalculator.Add(args);
System.out.println(sum);
}catch(IllegalArgumentException iae){System.out.println(iae.getMessage());}
try
{
args="//[xyz]\n10xyz2xyz\nxyz11xyz123xyz12xyz854xyz57643xyz2356xyz-12343";
System.out.print("Case 3 : passed \""+args+"\", sum=");
sum=SimpleStringCalculator.Add(args);
System.out.println(sum);
}catch(IllegalArgumentException iae){System.out.println(iae.getMessage());}
try
{
args="//[xyz]\n10xyz2xyz4578\n485xyz11xyz123xyz12xyz854xyz57643xyz2356xyz-12343";
System.out.print("Case 4 : passed \""+args+"\", sum=");
sum=SimpleStringCalculator.Add(args);
System.out.println(sum);
}catch(IllegalArgumentException iae){System.out.println(iae.getMessage());}
}
}
