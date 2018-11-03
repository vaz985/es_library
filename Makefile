JFLAGS	=	-g
JC	=	javac
BIN	=	./bin

default	=	classes


classes:	prep
		$(JC)	src/*/*.java	-d	bin/

prep:
			mkdir	-p	$(BIN)

run:
			java	-cp	bin	models.Library

clean:	
			rm -r	bin
