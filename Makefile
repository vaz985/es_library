JFLAGS	=	-g
JC	=	javac
BIN	=	./bin

default	=	classes


classes:	prep
		$(JC)	src/*/*/*.java	-d	bin/
		$(JC)	-cp	bin	src/*/*.java	-d	bin/
		$(JC)	-cp	bin	src/*.java	-d	bin/

prep:
			mkdir	-p	$(BIN)

run:
			java	-cp	bin	Main /home/lucas/GitHub/es_library/

clean:	
			rm -r	bin
