all: build

install:
	rsync -avz export/ fendres@www.sio-savary.fr:public_html/gestact

php:
	sed -i 's/^#-php/-php/' compile.hxml
	sed -i 's/^-neko/#-neko/' compile.hxml
	make build
	
neko:
	sed -i 's/^-php/#-php/' compile.hxml
	sed -i 's/^#-neko/-neko/' compile.hxml
	make build

build:
	sed -i /^-resource/d compile.hxml
	ls tpl/*.html | sed s',tpl/\(.*\).html,-resource tpl/\1.html@\1,' >> compile.hxml
	mkdir -p export
	haxe compile.hxml
	cp -f tpl/styles.css export/

sqlite:
	mkdir -p export/data
	chmod -R o+w export/data

clean:
	rm -rf export/{lib,res}
	rm -f export/index.php
	rm -f export/index.n
	rm -f export/styles.css
	rm -rf export/tests
	rm -rf out

run: neko
	cd export; nekotools server -p 8080

test:
	mkdir -p export/tests/
	haxe -js export/tests/index.js -cp tests -cp source -main ClientTestsRunner
	echo "<html><body><div id=\"haxe:trace\"></div><script src=\"index.js\"></script></body></html>" > export/tests/index.html

