Last login: Tue Mar 20 21:45:09 on ttys000
Jia-hui-Ma:~ jma$ ssh jma289@unix.ucsc.edu
jma289@unix.ucsc.edu's password: 
Last login: Sun Mar 18 22:15:48 2018 from eduroam-169-233-238-113.ucsc.edu
===============================================================================
*                                                                             *
*               Welcome to the Learning Technologies Timeshare!               *
*                                                                             *
*  Need help? Have a question? Something isn't working? We're here for you!   *
*  Email us at help@ucsc.edu, call us at 459-HELP (459-4357) or open a        *
*  support ticket at http://itrequest.ucsc.edu                                *
*                                                                             *
*  For those of you that are new to UCSC, welcome aboard! For everyone else,  *
*  welcome back! We hope you had a great summer and are ready for another     *
*  school year here in the beautiful forest. You'll notice pretty much all of *
*  our computer labs have been upgraded in both hardware and software. May    *
*  those upgrades help you on your academic road to success. =) As always,    *
*  please let us know if you see any software issues or have any questions.   *
*  Hope you have a wonderful fall quarter!                                    *
*                                                                             *
===============================================================================
You are currently using 3% (34.5 MiB) of your 1.0 GiB quota.
-bash-4.2$ cd cs12a
-bash-4.2$ cd la
-bash: cd: la: No such file or directory
-bash-4.2$ ls
lab1  lab2  lab3  lab4  lab5  lab6  lab7  pa1  pa2  pa3  pa4  pa5  pa6
-bash-4.2$ cd pa4
-bash-4.2$ ls
Makefile  Roots.java
-bash-4.2$ vi Makefile
-bash-4.2$ ls
Makefile  Roots.java
-bash-4.2$ vi Roots.java






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
