import os
import glob
#os.remove("TerminalChess.jar")
os.system("javac *.java")
os.system("jar cfe TerminalChess.jar Main *.class")
for file in glob.glob("*.class"):
	os.remove(file)
os.system("java -jar TerminalChess.jar")