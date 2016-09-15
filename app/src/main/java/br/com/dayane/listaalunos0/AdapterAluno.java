package br.com.dayane.listaalunos0;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Dayane on 14/09/2016.
 */
public class AdapterAluno extends RecyclerView.Adapter<AdapterAluno.ItemAlunoViewHolder>{

    private final List<Aluno> listaAluno;
    private final Context context;

    public AdapterAluno(Context context,List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
        this.context = context;
    }

    public void addItem(Aluno aluno){
        this.listaAluno.add(aluno);
    }

    @Override
    //Infla a view
    public ItemAlunoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(this.context).inflate(R.layout.adapter_card_view_alunos,parent,false);
        ItemAlunoViewHolder itemAlunoViewHolder = new ItemAlunoViewHolder(view);
        return itemAlunoViewHolder;
    }

    @Override
    //Seta os valores na view
    public void onBindViewHolder(ItemAlunoViewHolder holder, int position) {
        Aluno aluno = this.listaAluno.get(position);
        holder.txtNome.setText(aluno.getNome());
        holder.txtCurso.setText(aluno.getCurso());
    }

    @Override
    public int getItemCount() {
        return (this.listaAluno != null) ? this.listaAluno.size():0;
    }

    public static class ItemAlunoViewHolder extends RecyclerView.ViewHolder{
        TextView txtNome;
        TextView txtCurso;

        public ItemAlunoViewHolder(View itemView) {
            super(itemView);
            txtNome = (TextView) itemView.findViewById(R.id.txtNome);
            txtCurso = (TextView) itemView.findViewById(R.id.txtCurso);
        }
    }
}
