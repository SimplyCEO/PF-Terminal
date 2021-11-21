CC="/usr/lib/jvm/java-8-openjdk-amd64/bin"
MANIFEST="../src/main/META-INF/MANIFEST.MF"
OBJECTS-DIR="../src/main/com/kxmodules/pfterminal"
OBJECTS="BashCaller.java"

build:
	mkdir -p build && cd build && \
	mkdir -p com/kxmodules/pfterminal && cp $(MANIFEST) . && \
	$(CC)/javac $(OBJECTS-DIR)/$(OBJECTS) && mv $(OBJECTS-DIR)/Main.class . && \
	$(CC)/jar -cvfm ../PF-Terminal.jar MANIFEST.MF Main.class
clean:
	rm -rf build
