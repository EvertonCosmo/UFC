all:run

lista.o:lista.c
	gcc -c lista.c -g
main.o: main.c
	gcc -c main.c
operacoes.o: operacoes.c
	gcc -c operacoes.c -g
main.x: lista.o main.o operacoes.o
	gcc -o main.x lista.o main.o operacoes.o
run:main.x
	./main.x
clean:
	rm -f *.o  *.x
