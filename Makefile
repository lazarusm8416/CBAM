JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ColidableObject.java \
	PData.java \
	Player.java \
	World.java \
	CBAM.java \


  default: classes

  classes: $(CLASSES:.java=.class)

  clean:
	$(RM) *.class
