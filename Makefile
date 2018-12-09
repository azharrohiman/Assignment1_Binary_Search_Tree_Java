#
# Assignment 1 Makefile
# azhar rohiman - 8/4/2017

LIB = lib
SRCDIR = src
BINDIR = bin
TESTDIR = test
DOCDIR = doc

# JUNIT = $(LIB)/junit/junit-4.12.jar:$(LIB)/junit/hamcrest-core-1.3.jar
TOOLS = $(LIB)/tools

JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR):$(JUNIT)

vpath %.java $(SRCDIR)
vpath %.class $(BINDIR)

# define general build rule for java sources
.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<
	
all: Person.class BinarySearchTree.class PrintIt.class SearchIt.class SearchItLinear.class QueryFile.class doc

CLASSFILES = Person.class BinarySearchTree.class PrintIt.class SearchIt.class SearchItLinear.class

SOURCEFILES = Person.java BinarySearchTree.java PrintIt.java SearchIt.java SearchItLinear.java

doc: $(CLASSFILES)
	javadoc -version -author -d $(doc) $(SOURCEFILES)

test_classes: all BinarySearchTreeTest.class PersonTest.class

test: test_classes
	java -ea -cp $(TESTDIR):$(JUNIT) org.junit.runner.JUnitCore BinarySearchTree

jacoco.exec: test_classes
	java -ea -javaagent:$(LIB)/jacoco/jacocoagent.jar -cp $(TESTDIR):$(JUNIT) org.junit.runner.JUnitCore BinarySearchTree

report: jacoco.exec
	java -cp $(TESTDIR):$(CLI):$(JACOCO):$(ASM):$(TOOLS) Report --reporttype html .

#PrintIt.class:
#	javac $(JFLAGS) $(SRCDIR)/PrintIt.java
   
clean:
	@rm -f $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -f jacoco.exec *.xml *.csv
	@rm -Rf coveragereport
	@rm -Rf doc