// Roots.java
// Jia-hui Ma
// jma289
// pa4
// determines real roots of polynomial in specified range

import java.util.Scanner;

class Roots{

   public static void main( String[] args ){
     double tolerance, threshold, a, b, oddroot, evenroot;
     a = 0.0;
     b = 0.0;
     tolerance = Math.pow(10, -11);
     threshold = Math.pow(10, -3);
     int degree, coefficients;
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter the degree: ");
     degree = sc.nextInt();
     coefficients = degree + 1;

     System.out.println("Enter " + coefficients + " coefficients: ");
     double [] C = new double [coefficients];
     for (int i=0; i<coefficients; i++) {
       int co = sc.nextInt();
       C[i] = co;
     }

     System.out.println("Enter endpoints, or q to quit: " );
     while (true) {
       if (!sc.hasNextDouble()) {
         System.out.println("bye!");
         break;
       }
       else {
         a = sc.nextDouble();
         b = sc.nextDouble();         
         double[] D = diff(C);

         if (poly(C, b)*poly(C, a)<0) {
           oddroot = findRoot(C, a, b, tolerance);
           System.out.printf("   Odd root in [" + a + ", " + b + "] found at: %.10f%n", oddroot);
         }
         else if (poly(D, b)*poly(D, a)<0) {
           oddroot = findRoot(D, a, b, tolerance);
           if (Math.abs(poly(C, oddroot))<threshold) {
             evenroot = oddroot;
             System.out.printf("   Even root in [" + a + ", " + b + "] found at: %.10f%n", evenroot);
           }
           else {
           System.out.println("   No root found in [" + a + ", " + b + "]");
           }
         }
         else {
           System.out.println("   No root found in [" + a + ", " + b + "]");
         }
       System.out.println("Enter endpoints, or q to quit: " );
       }
     }
   }
   static double poly(double[] C, double x){
     double sum = 0.0;
     for (int i=0; i<C.length; i++) {
       double a = C[i]*Math.pow(x, i);
       sum += a;
     }
     return sum;
   }

   static double[] diff(double[] C){
     double [] D = new double [C.length-1];
     for (int i=1; i<C.length; i++) {
       D[i-1] = C[i]*i;
     }
     return D;
   }

   static double findRoot(double[] C, double a, double b, double tolerance){
     double midpoint=0.0;
     double width = b-a;
     while (width>tolerance) {
       midpoint = (a+b)/2.0;
       if (poly(C, a)*poly(C, midpoint)<=0) {
         b = midpoint;
       }
       else {
         a = midpoint;
       }
       width = b-a;
     }
     return midpoint;
   }

}
