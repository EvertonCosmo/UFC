package com.cosmo.everton.ufc.questao4;

public class MusicasInterator implements Interator{

	Musica[] listaMusicas;
	int posicao=0;

	public MusicasInterator(Musica[] listaMusicas){
		this.listaMusicas = listaMusicas;
	}


	@Override
	public boolean hasNext() {

		if(posicao >=listaMusicas.length || listaMusicas[posicao] == null){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Object next() {
		Musica musica = listaMusicas[posicao];
		posicao = posicao + 1;
		return musica;
	}

}
