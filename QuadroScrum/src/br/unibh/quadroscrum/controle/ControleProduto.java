package br.unibh.quadroscrum.controle;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.repositorio.ProdutoRepositorio;
import br.unibh.quadroscrum.ws.backlog.BacklogList;

public class ControleProduto {

	Context contexto;
	ProdutoRepositorio repositorio;
	
	 public ControleProduto(Context contexto){
		 this.contexto = contexto; 
		 repositorio = new ProdutoRepositorio(contexto);
	 }
	 
	 public boolean existeProduto(Produto produto){
		
		 Cursor c = repositorio.existeProduto(produto);
		 
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
	 
	 public ArrayList<Produto> getListProdutos (Produto produto){

		 ArrayList<Produto> produtos = null;
		 
		 if (produto != null){
			 produtos = new ArrayList<Produto>();
			 
			 Cursor c = repositorio.listarTodos();
			 
			 c.moveToFirst();
			 produtos.add(getProduto(c));
			 if (c.moveToNext()){
				 produtos.add(getProduto(c));
			 }
		 }
		 
		 
		 return produtos;
		 
		 
	 }

	 private Produto getProduto(Cursor c){
		 
		Produto produto = new Produto();
		produto.setId(c.getLong(Produto.INDICE_ID));
		produto.setNome(c.getString(Produto.INDICE_DESCRICAO));
		return produto;

	 }
	 
	 public void inserirTabela(BacklogList backlogList){
		 
		 
	 }
	 
}
