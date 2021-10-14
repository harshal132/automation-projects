package string_types;

class SimpleString  {

   public static void main(String args[])  {

     // Simple String Operations
      char c[] = {'J', 'a', 'v', 'a'};
      String s1 = new String(c);
      String s2 = new String(s1); 

      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s1.length());
      System.out.println(s1.indexOf('v'));
      String sb=s1.substring(1,3);
      System.out.println(sb);
      String s_1=String.valueOf(252.33);
      System.out.println(s_1);
      System.out.println(s_1.length());
      String s_2="   Cap  ";
      System.out.println(s_2.length());
      String s_3=s_2.trim();
      System.out.println(s_3.length());
      System.out.println(s_3);
      char ch=s_3.charAt(1);
      System.out.println(ch);
      String s_4="";
      if(s_4.length()==0) System.out.println("Empty string");
      // jdk 1.6
      if(s_4.isEmpty())  System.out.println("Empty string");

      // Using concatenation to prevent long lines.
      String longStr = "This could have been " +
                             "a very long line that would have " +
                             "wrapped around.  But string concatenation " +
                             "prevents this.";

       System.out.println(longStr);
   }
}
