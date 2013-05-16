package br.unibh.quadroscrum.iu.listas;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import br.unibh.quadroscrum.controle.ControleProduto;
import br.unibh.quadroscrum.modelo.Produto;
import br.unibh.quadroscrum.modelo.Sprint;
import br.unibh.quadroscrum.repositorio.ProdutoRepositorio;
import br.unibh.quadroscrum.repositorio.SprintRepositorio;

public class SprintAdapter extends BaseExpandableListAdapter {

	Context contexto;
	ArrayList<Sprint> listaSprint;
	SprintRepositorio sprintRepositorio;
	ProdutoRepositorio produtoRepositorio;
	
	public SprintAdapter(Context contexto, ArrayList<Sprint> listaSprint){
		this.contexto = contexto;
		this.listaSprint = listaSprint;
	}
	
	@Override
	public Object getChild(int indicePoduto, int indiceSprint) {
		
		return listaSprint.get(indiceSprint);		
	}

	@Override
	public long getChildId(int indicePoduto, int indiceSprint) {
		
		return listaSprint.get(indiceSprint).getId();
		
		
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		TextView titulo = new TextView(contexto);
		
		Sprint sprint = listaSprint.get(childPosition);
		
		String tituloStr = "Descrição = " + sprint.getDescricao() +" - Titulo: " 
		+ sprint.getTitulo();
		
		titulo.setText(tituloStr);
		//alinhamento
		titulo.setPadding(10, 5, 0, 5);
		
		return titulo;
		
	}

	@Override
	public int getChildrenCount(int groupPosition) {

		return listaSprint.size();
	}

	@Override
	public Object getGroup(int groupPosition) {

		return listaSprint.get(groupPosition);
		
	}

	@Override
	public int getGroupCount() {

		return listaSprint.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		
		return listaSprint.get(groupPosition).getId();
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		TextView titulo = new TextView(contexto);
		
		String tituloStr = listaSprint.get(groupPosition).getDescricao();
		
		titulo.setText(tituloStr);
		
		titulo.setPadding(10, 5, 0, 5);
		
	
		return null;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
