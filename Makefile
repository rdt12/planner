#OPENCV_JAR=/usr/local/share/OpenCV/java/opencv-344.jar
#CLASSPATH=.:$(OPENCV_JAR)
TARGET=PlanTest

all: $(TARGET).class Planner.class

$(TARGET).class: $(TARGET).java
	javac -classpath "$(CLASSPATH)" $^


clean:
	rm -f $(TARGET).class
