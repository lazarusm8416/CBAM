JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ColidableObject.java \
	Player.java \
	World.java \
	CBAM.java \
	GameServer.java \
	GameRunner.java \
	DrawPlayer.java \
	Wall.java \
	Server.java \
	Client.java \
	ClientThread.java \
	UserClient.java \

  default: classes

  classes: $(CLASSES:.java=.class)

  clean:
	$(RM) *.class
