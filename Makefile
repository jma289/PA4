# Makefile
# Jia-hui Ma
# jma289
# pa4
# A simple Makefile for the Roots program
Roots: Roots.class
        echo Main-class: Roots > Manifest
        jar cvfm Roots Manifest Roots.class
        rm Manifest
        chmod u+x Roots
Roots.class: Roots.java
        javac -Xlint Roots.java
clean:
        rm -f Roots.class Roots
submit: Makefile Roots.java
        submit cmps012a-pt.w18 pa4 Makefile Roots.java
check:  
        ls /afs/cats.ucsc.edu/class/cmps012a-pt.w18/pa4/jma289
