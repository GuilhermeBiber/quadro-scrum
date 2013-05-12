package br.unibh.quadroscrum.controle;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.repositorio.ProdutoRepositorio;

public class ControleProduto {

	Context contexto;
	ProdutoRepositorio repositorio;
	
	 public ControleProduto(Context contexto){
		 this.contexto = contexto; 
		 repositorio = new ProdutoRepositorio(contexto);
	 }
	 
	 public boolean existeProduto(Produto produto){
		
		 Cursor c = repositorio.selectProduto(produto);
		 repositorio.fechar();
		 if(c.moveToFirst()){
			 c.close();
			 return true;
		 }	 
		 c.close();
		 return false;
	 }
	 
	 public boolean inserirProduto(Produto produto){
		 
		 Long id = repositorio.inserir(produto);
		 repositorio.fechar();
		 if(id != -1){
			return true;
		 }
		 return false;
	 }


}
