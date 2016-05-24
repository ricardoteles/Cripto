JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		Arquivos.java \
        BaseNumerica.java \
		Chaves.java \
		Constantes.java \
		Ep.java \
		Funcoes.java \
		K128.java \
		Operacoes.java \
		Sboxes.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class