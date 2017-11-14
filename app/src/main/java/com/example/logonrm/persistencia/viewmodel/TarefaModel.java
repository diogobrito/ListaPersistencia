package com.example.logonrm.persistencia.viewmodel;

/**
 * Created by logonrm on 13/11/2017.
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.logonrm.persistencia.dao.BaseDados;
import com.example.logonrm.persistencia.model.Tarefa;

import java.util.List;


public class TarefaModel extends AndroidViewModel {
    private LiveData<List<Tarefa>> tarefas;
    private BaseDados bd;

    public TarefaModel(Application application) {
        super(application);
        bd = BaseDados.getDatabase(application.getApplicationContext());
        carregarDados();
    }

    public LiveData<List<Tarefa>> getTarefas() {
        return tarefas;
    }

    private void carregarDados() {
        tarefas = bd.tarefaDao().listarTodas();
    }
}