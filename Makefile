
all: compile

compile:
	echo "comment" > sources.txt
	find . -depth -name "*.java" >> sources.txt #Find all java file and put path to sources.txt
	javac -d . -sourcepath @sources.txt #Compile
	java avaj.simulator.Simulator scenario.txt #Run

re: clean compile

clean:
	rm -rf avaj
	rm -rf out
	rm -rf sources.txt
	rm -rf simulation.txt
	find . -depth -name "*.class" -delete