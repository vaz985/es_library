JFLAGS	=	-g
JC	=	javac
BIN	=	./bin
TST	=	./tst

default	=	classes


classes:	prep
		$(JC)	-cp	bin	src/main/*/*.java	-d	bin/
		$(JC)	-cp	"bin:tst:/Applications/IntelliJ\ IDEA.app/Contents/lib/"	src/test/*/*.java	-d	tst/

prep:
			mkdir	-p	$(BIN)
			mkdir	-p	$(TST)

run:
			java	-cp	bin	Main 

clean:	
			rm -r	bin
